import { Component, OnInit } from '@angular/core';
import { HelperService } from 'src/app/services/helper.service';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/Ilogin';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  itemList = new Array(3);
  user: User;
  
  totalPrice: number = 0.00;
  totalQuantity: number = 0;
  
  constructor(private helperService: HelperService, 
              private router: Router,
              private cartService : CartService,
    public loginService: LoginService) {
  }

  ngOnInit() {
    this.loginService.loggedIn.subscribe(next => {
      this.user = next;
    });

    this.updateCartStatus();
  }

  updateCartStatus() {
    //subscribe to the cart status totalPrice
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    )

    //subscribe to the cart status totalQuantity
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    )
  }

  openAddressSideNav (){
    this.helperService.addressSideNav.next(true);
  }
  openLoginSideNav(){
    this.helperService.loginSideNav.next(true);
  }
  logout() {
    this.user = null;
    // this.loginService.loggedIn.next(this.user);
  }
  
}
