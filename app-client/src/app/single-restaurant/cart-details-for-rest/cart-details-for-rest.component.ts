import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart-details-for-rest',
  templateUrl: './cart-details-for-rest.component.html',
  styleUrls: ['./cart-details-for-rest.component.scss']
})
export class CartDetailsForRestComponent implements OnInit {

  itemList = new Array(4)
  constructor() { }

  ngOnInit() {
  }

}
