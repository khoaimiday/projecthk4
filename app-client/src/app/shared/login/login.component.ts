import { Component, OnInit } from '@angular/core';
import { HelperService } from 'src/app/services/helper.service';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/interfaces/Ilogin';
import { OktaAuthService } from '@okta/okta-angular';
import * as OktaSignIn from '@okta/okta-signin-widget';

import myAppConfig from 'src/app/config/my-app-config';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  oktaSignin: any;
  user = {} as User;
 
  constructor(private helperService: HelperService, 
              private loginService: LoginService,
              private oktaAuthService: OktaAuthService) { 
          
                this.oktaSignin = new OktaSignIn({
                  logo: '',
                  features: {
                    registration: true
                  },
                  baseUrl: myAppConfig.oidc.issuer.split('/oauth2')[0],
                  clientId: myAppConfig.oidc.clientId,
                  redirectUri: myAppConfig.oidc.redirectUri,
                  authParams: {
                    pkce: true,
                    issuer: myAppConfig.oidc.issuer,
                    scopes: myAppConfig.oidc.scopes
                  }
                });
              }
              
  ngOnInit(): void {
    this.oktaSignin.remove();

    this.oktaSignin.renderEl({
      el: '#okta-sign-in-widget'}, // this name should be same as div tag id in login.component.html
      (response) => {
        if (response.status === 'SUCCESS') {
          this.oktaAuthService.signInWithRedirect();
        }
      },
      (error) => {
        throw error;
      }
    );
  }

  signupEnable (){
   this.helperService.enableAccount.next('signup');
  }

  closeLoginNav(){
    this.helperService.loginSideNav.next(false);
  }

  login(){
    this.user.username = 'Piyush';
    this.user.email = '';
    this.loginService.loggedIn.next(this.user);
    this.closeLoginNav();
  }
}
