import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from '../interfaces/restaurant';
import { RestaurantsService } from '../services/restaurants.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  itemList = new Array(4);
  restaurants: Restaurant[]= [];

  constructor(private router: Router, 
              private restaurantService: RestaurantsService) { }

  ngOnInit() {
    this.restaurantService.getAllRestaurants().subscribe(res=>{
      this.restaurants = res;
      console.log(this.restaurants)
    });
  }

  goToRestaurant(restaurant : Restaurant){
    console.log(restaurant)
    this.router.navigate(['/restaurants', restaurant.id] , {state:{...restaurant} });

  }

}



