import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/interfaces/cart';
import { User } from 'src/app/interfaces/Ilogin';
import { CartService } from 'src/app/services/cart.service';
import { HelperService } from 'src/app/services/helper.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-cart-detail-check-out',
  templateUrl: './cart-detail-check-out.component.html',
  styleUrls: ['./cart-detail-check-out.component.scss']
})
export class CartDetailCheckOutComponent implements OnInit {

  user: User;
  items: CartItem[] = [];

  totalPrice: number = 0;
  totalQuantity:number = 0;

  constructor(private helperService: HelperService,
    private router: Router, 
    public loginService: LoginService,
    private cartService: CartService) {
}

  ngOnInit() {
    this.loginService.loggedIn.subscribe(next => {
    this.user = next;
    });

    this.listCartDetail();
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

}
