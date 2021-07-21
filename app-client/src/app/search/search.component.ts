import { Component, OnInit,NgModule, ViewChild, AfterViewInit } from '@angular/core';
import { MatTabChangeEvent, MatTabGroup } from '@angular/material';
import { Router } from '@angular/router';
import { Dishes, DishesService } from '../services/dishes.service';
import { Restaurant, RestaurantsService } from '../services/restaurants.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  searchValue: string = '';
  tabName : string = 'Restaurant';

  dishesList = new Array(6);
  restaurants = new Array();

  constructor(private router: Router, 
              private restaurantService: RestaurantsService,
              private dishesService: DishesService) {}

  ngOnInit() { 
        
    //Get all restaurant
    this.restaurantService.getAllRestaurants().subscribe(res => {
      this.restaurants = res;
    });

    //Get all Food
    this.restaurantService.getAllRestaurants().subscribe(res => {
      this.dishesList = res;
    }); 
  }

  goToRestaurant(restaurant : Restaurant) {
    console.log(restaurant)
    this.router.navigate(['/restaurants', restaurant.id] , {state:{...restaurant} });
  }

  goToDishes(dishes : Dishes) {
    console.log(dishes)
    this.router.navigate(['dishes', dishes.id]);
  }

  onTabChange(event : MatTabChangeEvent) {
    console.log(event.tab.textLabel)
    this.tabName = event.tab.textLabel;
  }

  doSearch(){
    //Search with tab Restaurant
    if (this.tabName == 'Restaurant') {
      this.restaurantService.searchRestaurantsContainName(this.searchValue).subscribe(res => {
        this.restaurants = res;
      })
    }

    //Search with tab Dishes
    if (this.tabName == 'Dishes') {
      this.dishesService.searchDishesContainName(this.searchValue).subscribe(res => {
        this.dishesList = res;
      })
    }
  }

}
