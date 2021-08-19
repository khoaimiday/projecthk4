import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantsService } from '../services/restaurants.service';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.scss']
})
export class OfferComponent implements OnInit {
  loaderRestaurant = new Array(6);
  restaurants = new Array();

  tempIMG = "https://picsum.photos/300"
  constructor(private router: Router, private restaurantService: RestaurantsService) { 
    this.restaurantService.getAllRestaurants().subscribe(res=>{
      console.log(res)
      this.restaurants = res;
    });
  }

  ngOnInit() {
  }

  goToRestaurant(restaurant){

  }

}
