import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { ProductItemComponent } from './home/product-item/product-item.component';
import { CartComponent } from './home/cart/cart.component';
import { NavComponent } from './home/nav/nav.component';
import {HttpClientModule} from "@angular/common/http";
import { LoginFormComponent } from './login/login-form/login-form.component';

import {ToastrModule} from "ngx-toastr";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HeaderTopLinkComponent } from './header-top-link/header-top-link.component';
import { RegisterComponent } from './login/register/register.component';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,  
    LoginComponent,
    HomeComponent,
    ProductItemComponent,
    CartComponent,
    NavComponent,
    LoginFormComponent,
    HeaderTopLinkComponent,
    RegisterComponent,
    ProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({timeOut: 2000, progressBar: false, positionClass: 'toast-bottom-left'}),

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
