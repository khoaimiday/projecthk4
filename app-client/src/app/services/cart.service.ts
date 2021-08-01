import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from '../interfaces/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems : CartItem[] = [];
  
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalQuantity: Subject<number> = new BehaviorSubject<number>(0);

  cartItemsSubject: Subject<CartItem[]> = new Subject<CartItem[]>();

  storage: Storage = sessionStorage;

  constructor() { 
    //read data from storage
    let data = JSON.parse(this.storage.getItem('cartItems'));

    if (data != null) {
      this.cartItems = data;
    }

    //compute totals based on the data that is read from storage
    this.computeCartTotals();
  }

  addToCart(theCartItem: CartItem){

    let existingCartItem: CartItem = undefined;

    if (this.cartItems.length > 0) {
      //find the item in the cart based on item id
      existingCartItem = this.cartItems.find( (tempCartItem, index) => {
        return tempCartItem.id === theCartItem.id
      });
    }

    if (existingCartItem != undefined) {
      existingCartItem.quantity = theCartItem.quantity;
    }else{
      this.cartItems.push(theCartItem);
    }
    console.log(this.cartItems)
    //compute cart total price and total quantity
    this.computeCartTotals();
  }

  computeCartTotals() {
    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    this.cartItems = this.cartItems.filter( el => el.quantity > 0)
    this.cartItemsSubject.next(this.cartItems);

    for (const currentCartItem of this.cartItems) {
      totalPriceValue += currentCartItem.quantity * currentCartItem.price;
      totalQuantityValue += currentCartItem.quantity;
    }

    //publish the new values.. all subscribers will receive the new data
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);

    //log cart data just for debugging purposes
    this.logCartData(totalPriceValue, totalQuantityValue);

    //persist cart data
    this.persistCartItems();
  }

  persistCartItems(){
    this.storage.setItem('cartItems', JSON.stringify(this.cartItems));
  }

  removeCartItems() {
    this.storage.removeItem('cartItems');
    this.cartItems = [];
  }

  logCartData(totalPriceValue: number, totalQuantityValue: number) {
    console.log(`Contents of the cart`);
    for (const tempCartItem of this.cartItems) {
      const subTotalPrice = tempCartItem.quantity * tempCartItem.price;
      console.log(`name: ${tempCartItem.name}, quantity: ${tempCartItem.quantity}, 
                  unitPrice=${tempCartItem.price},  subTotalPrice=${subTotalPrice}`);
    }
    console.log(`totalPrice: ${totalPriceValue.toFixed(2)}, totalQuantity: ${totalQuantityValue}`);
    console.log('------------------------')
  }

}
