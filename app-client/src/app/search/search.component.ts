import { Component, OnInit,NgModule } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantsService } from '../services/restaurants.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  searchValue: String = '';

  value = 'Clear me';
  products = new Array(6);
  foodList = new Array(6);
  restaurants = new Array();
  constructor(private router: Router, private restaurantService: RestaurantsService) {
    
    //Get all restaurant
    this.restaurantService.getAllRestaurants().subscribe(res => {
      this.restaurants = res;
    });

    //Get all Food
    this.restaurantService.getAllRestaurants().subscribe(res => {
      this.foodList = res;
    });
  }

  ngOnInit() {
  }

  goToRestaurant(id) {
    this.router.navigate(['restaurants/101']);
    // this.router.navigate(['restaurants/:id']);
  }

  goToFood(id) {
    this.router.navigate(['food/101/:id']);
  }

}
