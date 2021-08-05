import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Offer } from '../common/offer';
import { Restaurant } from '../interfaces/restaurant';
import { OfferService } from '../services/offer.service';
import { RestaurantsService } from '../services/restaurants.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  itemList = new Array(4);
  restaurants: Restaurant[]= [];
  offers: Offer[]= [];

  constructor(private router: Router, 
              private restaurantService: RestaurantsService,
              private offerService: OfferService) { }

  ngOnInit() {
    this.restaurantService.getAllRestaurants().subscribe(res=>{
      this.restaurants = res;
      console.log(this.restaurants)
    });

    this.getOffers();
  }

  goToRestaurant(restaurant : Restaurant){
    console.log(restaurant)
    this.router.navigate(['/restaurants', restaurant.id] , {state:{...restaurant} });
  }

  getOffers(){
    this.offerService.getAllOffer().subscribe(
      data => this.offers = data
    )
    console.table(this.offers)
  }

}



