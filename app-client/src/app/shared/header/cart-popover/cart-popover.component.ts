import { Component, OnInit } from '@angular/core';
import { CartItem } from '../../../interfaces/cart';
import { CartService } from '../../../services/cart.service';

@Component({
  selector: 'app-cart-popover',
  templateUrl: './cart-popover.component.html',
  styleUrls: ['./cart-popover.component.scss']
})
export class CartPopoverComponent implements OnInit {

  itemList: CartItem[] = [];
  totalPrice: number = 0;
  totalQuantity:number = 0;

  constructor(private cartService: CartService) { }

  ngOnInit() {
    this.listCartDetail();
  }

  listCartDetail() {
    this.itemList = this.cartService.cartItems;

    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    )

    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    )

    this.cartService.computeCartTotal();
  }

}
