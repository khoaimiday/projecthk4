import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { User } from '../interfaces/Ilogin';
import { HelperService } from '../services/helper.service';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { CartItem } from '../interfaces/cart';
import { CartService } from '../services/cart.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { CheckOutValidators } from '../validators/check-out-validators';
import { CheckoutService } from '../services/checkout.service';
import { Order } from '../common/order';
import { OrderItem } from '../common/order-item';
import { Purchase } from '../common/purchase';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  
  checkoutFormGroup: FormGroup;

  user: User;
  items: CartItem[] = [];

  totalPrice: number = 0;
  totalQuantity:number = 0;
  totalPriceExchange: number = 0;

  storage: Storage = sessionStorage;

  constructor(private helperService: HelperService,
              private router: Router, 
              public loginService: LoginService,
              private cartService: CartService,
              private formBuilder: FormBuilder,
              private checkoutService: CheckoutService) {
  }

  @ViewChild('paypalRef', {static: true}) private paypalRef: ElementRef;
  ngOnInit() {

    this.renderButtonPaypal();

    this.loginService.loggedIn.subscribe(next => {
      this.user = next;
    });

    //read the user's email address from browser storage
    const theEmail = JSON.parse(this.storage.getItem("userEmail"));

    this.checkoutFormGroup = this.formBuilder.group({
      
      customer: this.formBuilder.group({
        fullName: new FormControl('', 
                              [Validators.required, 
                               Validators.minLength(2), 
                               CheckOutValidators.notOnlyWhitespace]),

        phoneNumber:  new FormControl('', 
                              [Validators.required, 
                               Validators.pattern("[0-9]{8,11}")]),
                               
        email: new FormControl(theEmail,
                              [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')])
      }),

      shippingAddress: this.formBuilder.group({
        street: new FormControl('',
                                [ Validators.required, 
                                  Validators.minLength(2), 
                                  CheckOutValidators.notOnlyWhitespace ]),
        
        ward:   new FormControl('',
                                [ Validators.required, 
                                  Validators.minLength(2), 
                                  CheckOutValidators.notOnlyWhitespace ]),
        
        district:   new FormControl('',
                                [ Validators.required, 
                                  Validators.minLength(2), 
                                  CheckOutValidators.notOnlyWhitespace ]),

        city: new FormControl('',
                              [ Validators.required,
                                Validators.minLength(2),
                                CheckOutValidators.notOnlyWhitespace ]),

        state: new FormControl(''),

        country: new FormControl(''),

        zipCode: new FormControl('')                                                       
      })

    })


    this.listCartDetail();
  }

  renderButtonPaypal() {
    
    paypal.Buttons(
      {
        style: {
          layout: 'horizontal',
          color: 'blue',
          shape: 'rect',
          label: 'paypal'
        },

        createOrder:  (date, actions) => {
          return actions.order.create({
            purchase_units: [
              {
                amount: {
                  value: this.checkoutFormGroup.invalid ? '0' : `${this.totalPriceExchange.toFixed(2)}`,
                  currency_code: 'USD',
                  
                }
              }
            ],
          })
        },

        onApprove: (data, actions) => {
          console.log(data)
          return actions.order.capture().then(details => {
            console.log(details)
            this.saveOrder('Paid with Paypal');
          })
        },

        onError: error => {
          console.log(error)
        }
      }
    ).render(this.paypalRef.nativeElement);
  }

  listCartDetail() {
    this.cartService.cartItemsSubject.subscribe(
      data => this.items = data
    )

    this.cartService.totalPrice.subscribe(
      data => {
        this.totalPrice = data;
        this.totalPriceExchange = data/24000;
      }
    )

    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    )

    this.cartService.computeCartTotals();
  }

  openLoginSideNav(){
    this.helperService.loginSideNav.next(true);
  }

  remove(item: CartItem){
    console.log(item.quantity)
    if ( item.quantity > 0) {
        item.quantity--;
        console.log(item.quantity)
        console.log(item)
        this.addToCart(item)
      }
  }

  add(item: CartItem){
      item.quantity++;
      console.log(item.quantity)
      console.log(item);
      this.addToCart(item);
  }

  addToCart(theCartItem: CartItem) { 
    this.cartService.addToCart(theCartItem);
  }

  
  get fullName() { return this.checkoutFormGroup.get('customer.fullName'); }
  get phoneNumber() { return this.checkoutFormGroup.get('customer.phoneNumber'); }
  get email() { return this.checkoutFormGroup.get('customer.email'); }

  get shippingAddressStreet() { return this.checkoutFormGroup.get('shippingAddress.street'); }
  get shippingAddressWard() { return this.checkoutFormGroup.get('shippingAddress.ward'); }
  get shippingAddressDistrict() { return this.checkoutFormGroup.get('shippingAddress.district'); }
  get shippingAddressCity() { return this.checkoutFormGroup.get('shippingAddress.city'); }
  get shippingAddressState() { return this.checkoutFormGroup.get('shippingAddress.state'); }
  get shippingAddressZipCode() { return this.checkoutFormGroup.get('shippingAddress.zipCode'); }
  get shippingAddressCountry() { return this.checkoutFormGroup.get('shippingAddress.country'); }

  get creditCardType() { return this.checkoutFormGroup.get('creditCard.cardType'); }
  get creditCardNameOnCard() { return this.checkoutFormGroup.get('creditCard.nameOnCard'); }
  get creditCardNumber() { return this.checkoutFormGroup.get('creditCard.cardNumber'); }
  get creditCardSecurityCode() { return this.checkoutFormGroup.get('creditCard.securityCode'); }

  onSubmit() {

    if (this.checkoutFormGroup.invalid) {
      console.log("Cancel submit button");
      this.checkoutFormGroup.markAllAsTouched();
      return;
    }
    console.log("Handling the submit button");

    this.saveOrder('Cash On Delivery');

  }

  saveOrder(payment: string) {
    //setup order
    let order = new Order();
    order.totalPrice = this.totalPrice;
    order.totalQuantity = this.totalQuantity;
    order.status = payment;

    //get cart items
    const cartItems = this.cartService.cartItems;
    let orderItems: OrderItem[] = cartItems.map( tempCartItem => new OrderItem(tempCartItem));

    //setup purchase
    let purchase = new Purchase();

    //populate purchase - user
    purchase.customer = this.checkoutFormGroup.controls['customer'].value;

    //populete purchase - shipping address
    purchase.shippingAddress = this.checkoutFormGroup.controls['shippingAddress'].value;

    //populate purchase - order and oderItems
    purchase.order = order;
    purchase.orderItem = orderItems;
    
    //call REST API via the CheckoutService
    this.checkoutService.placeOrder(purchase).subscribe(
      response => {
        console.log(`Your order has been received.\nOrder tracking number: ${response.orderTrackingNumber}`)
        this.resetCart();
      },
      error => {
          if (error.status == 200) {
            this.resetCart();
          }
          console.log(error);         
      }
    )
  }

  resetCart() {
    //reset Cart data
    this.cartService.cartItems = [];
    this.cartService.totalPrice.next(0);
    this.cartService.totalQuantity.next(0);
    this.cartService.cartItemsSubject.next(this.cartService.cartItems);
    
    //reset the form
    this.checkoutFormGroup.reset();

    //navigate back to the home page
    this.router.navigateByUrl("/");
  }
}
