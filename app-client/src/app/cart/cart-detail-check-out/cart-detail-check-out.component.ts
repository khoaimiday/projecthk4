import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/common/address';
import { CartItem } from 'src/app/interfaces/cart';
import { User } from 'src/app/interfaces/Ilogin';
import { Restaurant } from 'src/app/interfaces/restaurant';
import { AddressService } from 'src/app/services/address.service';
import { CartService } from 'src/app/services/cart.service';
import { HelperService } from 'src/app/services/helper.service';
import { LoginService } from 'src/app/services/login.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';


@Component({
  selector: 'app-cart-detail-check-out',
  templateUrl: './cart-detail-check-out.component.html',
  styleUrls: ['./cart-detail-check-out.component.scss']
})
export class CartDetailCheckOutComponent implements OnInit {

  user: User;
  coordsCustomer = [];
  items: CartItem[] = [];

  totalPrice: number = 0;
  totalQuantity:number = 0;
  distance : number = 0;
  fee_shipping:number = 12000;

  restaurantInCart : Restaurant;
  address_ : any;

  constructor(private helperService: HelperService,
              private router: Router, 
              public loginService: LoginService,
              private cartService: CartService,
              private addressService: AddressService,
              private restaurantService: RestaurantsService) { 
}

  ngOnInit() {
    this.restaurantDetail();
    this.listCartDetail();
   
  }


    async restaurantDetail() {
     await this.cartService.getRestaurantIncart();
     await this.cartService.$restaurantInCar.subscribe(
       data => {
        this.restaurantInCart = data
      }
    )
    await this.calShippingPrice();
  }

  listCartDetail() {
    this.cartService.cartItemsSubject.subscribe(
    data => this.items = data
    )

    this.cartService.totalPrice.subscribe(
    data => this.totalPrice = data
    )

    this.cartService.totalQuantity.subscribe(
    data => this.totalQuantity = data
    )

    this.cartService.computeCartTotals();
  }

  remove(item: CartItem){
    console.log(item.quantity)
    if ( item.quantity > 0) {
        item.quantity--;
        console.log(item)
        this.addToCart(item)
      }
  }

  add(item: CartItem){
      item.quantity++;
      console.log(item);
      this.addToCart(item);
  }

  addToCart(theCartItem: CartItem) { 
    this.cartService.addToCart(theCartItem);
  }

  calShippingPrice(){  
    let LatLngFrom: number[] = [];
    let LatLngTo: number[] = [];

     this.addressService.getAddressForRestaurant(this.cartService.cartItems[0].restanrantId).subscribe(
       data => {
        LatLngFrom = [data.longtitude, data.latitude]
      }
    )
    this.helperService.latLongSubject.subscribe(
       data => {
        LatLngTo = data
      }
    )

    setTimeout(() => {
      console.log(LatLngFrom)
      console.log(LatLngTo)
      var distance = (google.maps.geometry.spherical.computeDistanceBetween(
        new google.maps.LatLng(LatLngFrom[1], LatLngFrom[0]), new google.maps.LatLng(LatLngTo[1], LatLngTo[0]))/1000
        ).toFixed(2);                           
      console.log( distance + " KM")
      this.distance = +distance;
    }, 500);

  }

}
