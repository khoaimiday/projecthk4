import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Restaurant } from '../interfaces/restaurant';
import { HelperService } from './helper.service';

@Injectable({
  providedIn: 'root'
})
export class FavouritesService {

  api = "http://localhost:8080/api/favourites";

  storage: Storage = sessionStorage;

  userEmail:string = '';

  constructor(private httpClient: HttpClient,
              private helperService: HelperService) { }

  addWishList(restaurant: Restaurant){

    this.userEmail = this.storage.getItem('userEmail');
    console.log(this.userEmail)

    //Check user login
    if (this.userEmail) {
      const data = {
          restaurantId: restaurant.id,
          customerEmail: this.userEmail 
      }
      this.httpClient.post(this.api, data).subscribe(
        data => console.log(data),
        err => console.log(err)
      )

    }else{
      this.openLoginSideNav();
    }  
  }

  openLoginSideNav(){
    this.helperService.loginSideNav.next(true);
  }
}
