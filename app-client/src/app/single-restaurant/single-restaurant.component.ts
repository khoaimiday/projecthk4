import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Dishes } from '../interfaces/dishes';
import { Restaurant } from '../interfaces/restaurant';
import { AddressService } from '../services/address.service';
import { DishesService } from '../services/dishes.service';
import { RestaurantsService } from '../services/restaurants.service';
import {NgbRatingConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-single-restaurant',
  templateUrl: './single-restaurant.component.html',
  styleUrls: ['./single-restaurant.component.scss'],
  providers: [NgbRatingConfig] // add NgbRatingConfig to the component providers

})
export class SingleRestaurantComponent implements OnInit {

  restaurant : Restaurant;
  currentRestaurantId: number;
  dishesList: Dishes[] = [];

  color = 'accent';

  itemList = new Array(4);
  
  constructor(private restaurantService : RestaurantsService,
              private dishesService : DishesService,
              private addressService: AddressService,
              private route: ActivatedRoute,
              config: NgbRatingConfig) {
      
    //customize default values of ratings used by this component tree
      config.max = 5;
      config.readonly = true;
  }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.currentRestaurantId = +this.route.snapshot.paramMap.get('id')
      // this.restaurant = window.history.state;
      // console.log(this.currentRestaurantId)
      // console.log(this.restaurant)
      
      this.restaurantService.getRestaurantDetails(this.currentRestaurantId).subscribe(
        data => {
          this.restaurant = data
          console.log(this.restaurant)
        }
      )

      this.dishesService.getDishesByRestaurant(this.currentRestaurantId).subscribe(
        data => {
            this.dishesList = data;
        }
      )
    });
  }

  // getAddress() {
  //   this.addressService.getAddressForRestaurant(this.currentRestaurantId).subscribe(
  //     data => {
  //       this.restaurant.address = data
  //       console.log(this.restaurant)
  //     }
  //   )
  // }

}
