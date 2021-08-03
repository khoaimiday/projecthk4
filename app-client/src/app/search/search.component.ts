import { Component, OnInit,NgModule, ViewChild, AfterViewInit } from '@angular/core';
import { MatTabChangeEvent, MatTabGroup } from '@angular/material';
import { Router } from '@angular/router';
import { Dishes } from '../interfaces/dishes';
import { Restaurant } from '../interfaces/restaurant';
import { DishesService } from '../services/dishes.service';
import { RestaurantsService } from '../services/restaurants.service';

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

  //properties for panigation
  thePageNumber: number = 0;
  thePageSize: number = 5;
  theTotalElements: number = 0;

  constructor(private router: Router, 
              private restaurantService: RestaurantsService,
              private dishesService: DishesService) {}

  ngOnInit() {         
    //Get all restaurant
    this.getListRestaurant();
    //Get all Food
    this.getListFood();
  }

  getListRestaurant(){
    this.restaurantService.getAllRestaurantsPaginate(this.thePageNumber, this.thePageSize).subscribe(res => {
      console.log(res)
      this.restaurants = res._embedded.restaurants;
      this.thePageNumber = res.page.number +1;
      this.thePageSize = res.page.size;
      this.theTotalElements = res.page.totalElements;
    });
  }

  getListFood(){   
    //Get all Food
    this.restaurantService.getAllRestaurants().subscribe(res => {
      this.dishesList = res;
    }); 
  }

  goToRestaurant(restaurant : Restaurant) {
    // navigate to restaurant
    this.router.navigate(['/restaurants', restaurant.id] , {state:{...restaurant} });

  }

  async goToDishes(dishes : Dishes) {
    // get restaurant
    const theRestaurant: Restaurant = await this.restaurantService.getRestaurantByDishesId(dishes.id);

    // navigate to restaurant
    this.router.navigate(['/restaurants', theRestaurant.id] , {state:{...theRestaurant} });
  }

  onTabChange(event : MatTabChangeEvent) {
    // console.log(event.tab.textLabel)
    this.tabName = event.tab.textLabel;
    console.log(this.tabName)
  }

  doSearch(){
    //Search with tab Restaurant
    console.log(this.tabName)
    if (this.tabName == 'Restaurant') {
      this.restaurantService.searchRestaurantsContainNamePaginate(this.searchValue, 
                                                                  0, 
                                                                  this.thePageSize)
                                                                .subscribe(this.processResult());
    }

    //Search with tab Dishes
    if (this.tabName == 'Dishes') {
      this.dishesService.searchDishesContainNamePaginate(this.searchValue, 
                                                          0, 
                                                          this.thePageSize)
                                                        .subscribe(this.processResult());
    }
  }

  changePaginator({length,pageIndex,pageSize,previousPageIndex}){
    //Get all restaurant
    this.restaurantService.getAllRestaurantsPaginate(pageIndex, pageSize).subscribe(res => {
      console.log(res)
      this.restaurants = res._embedded.restaurants;
      this.thePageNumber = 1;
      this.thePageSize = res.page.size;
      this.theTotalElements = res.page.totalElements;
    });
  }

  processResult(){
    return res => {

      if (this.tabName == "Restaurant") {
        this.restaurants = res._embedded.restaurants;
      }else{
        this.dishesList = res._embedded.disheses;
        console.table(res)
      }

      this.thePageNumber = 1;
      this.thePageSize = res.page.size;
      this.theTotalElements = res.page.totalElements;
    }
  }

}
