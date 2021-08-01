import { Component, OnInit } from '@angular/core';
import { HelperService } from 'src/app/services/helper.service';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/Ilogin';
import { CartService } from '../../services/cart.service';
import { OktaAuthService } from '@okta/okta-angular';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  itemList = new Array(3);
  
  isAutenticated: boolean = false;
  userFullName: string;

  
  totalPrice: number = 0.00;
  totalQuantity: number = 0;
  
  constructor(private helperService: HelperService, 
              private router: Router,
              private cartService : CartService,
              private oktaAuthService: OktaAuthService) {
  }

  ngOnInit() {

    this.oktaAuthService.$authenticationState.subscribe(
      (result) => {
        this.isAutenticated = result;
        this.getUserDetails();
      }
    )

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

  getUserDetails() {
    if (this.isAutenticated) {
      
      //Fetch the logged in user details ( user's claims)
      //user fullname is exposed as a property name
      this.oktaAuthService.getUser().then(
        (res) => {
          this.userFullName = res.name;
        }
      )  
    }
  }

  logout(){
    // Terminates the session with Okta and removes current tokens
    this.oktaAuthService.signOut();
    this
  }

  openAddressSideNav (){
    this.helperService.addressSideNav.next(true);
  }

  openLoginSideNav(){
    this.helperService.loginSideNav.next(true);
  }

 
}
