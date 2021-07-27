import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
  MatBadgeModule
} from '@angular/material';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { MdePopoverModule } from '@material-extended/mde';
import { HomeComponent } from './home/home.component';
import { SingleRestaurantComponent } from './single-restaurant/single-restaurant.component';
import { SearchComponent } from './search/search.component';
import { HelpComponent } from './shared/help/help.component';
import { MyAccountComponent } from './account/my-account/my-account.component';
import { OrdersComponent } from './account/orders/orders.component';
import { PaymentsComponent } from './account/payments/payments.component';
import { FavouritesComponent } from './account/favourites/favourites.component';
import { AddressesComponent } from './account/addresses/addresses.component';
import { LoginComponent } from './shared/login/login.component';
import { SignupComponent } from './shared/signup/signup.component';
import { SelectAddressComponent } from './shared/select-address/select-address.component';
import { OfferComponent } from './offer/offer.component';
import { CartComponent } from './cart/cart.component';
import { NgxSkltnModule, SkltnConfig } from 'ngx-skltn';

import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { RestaurantItemComponent } from './home/restaurant-item/restaurant-item.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TabRestaurantComponentComponent } from './search/tab-restaurant-component/tab-restaurant-component.component';
import { TabDishesComponentComponent } from './search/tab-dishes-component/tab-dishes-component.component';
import { FoodOrderForRestaurantComponent } from './single-restaurant/food-order-for-restaurant/food-order-for-restaurant.component';
import { CartPopoverComponent } from './shared/header/cart-popover/cart-popover.component';
import { CartDetailsForRestComponent } from './single-restaurant/cart-details-for-rest/cart-details-for-rest.component';

const skltnConfig: SkltnConfig = {
  rectRadius: 10,
  flareWidth: '150px',
  bgFill: '#d8d5d1',
  flareFill: 'rgba(255,255,255, 0.5)',
};

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    SingleRestaurantComponent,
    FoodOrderForRestaurantComponent,
    SearchComponent,
    HelpComponent,
    MyAccountComponent,
    OrdersComponent,
    PaymentsComponent,
    FavouritesComponent,
    AddressesComponent,
    LoginComponent,
    SignupComponent,
    SelectAddressComponent,
    OfferComponent,
    CartComponent,
    RestaurantItemComponent,
    TabRestaurantComponentComponent,
    TabDishesComponentComponent,
    CartPopoverComponent,
    CartDetailsForRestComponent,
  ],
  imports: [
    NgbModule,
    Ng2SearchPipeModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    MatBadgeModule,
    MdePopoverModule,
    NgxSkltnModule.forRoot(skltnConfig)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
