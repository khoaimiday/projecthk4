import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Dishes } from '../interfaces/dishes';
import { DishesService } from '../services/dishes.service';
import { Restaurant, RestaurantsService } from '../services/restaurants.service';

@Component({
  selector: 'app-single-restaurant',
  templateUrl: './single-restaurant.component.html',
  styleUrls: ['./single-restaurant.component.scss']
})
export class SingleRestaurantComponent implements OnInit {

  restaurant : Restaurant;
  currentRestaurantId: number;
  dishesList : Dishes[] = [];


  itemList = new Array(4);
  constructor(private restaurantService : RestaurantsService,
              private dishesService : DishesService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.currentRestaurantId = +this.route.snapshot.paramMap.get('id')
      // this.restaurant = window.history.state;
      // console.log(this.currentRestaurantId)
      // console.log(this.restaurant)
      
      this.restaurantService.getRestaurantDetails(this.currentRestaurantId).subscribe(
        data => {
          console.log(data)
          this.restaurant = data
        }
      )

      this.dishesService.getDishesByRestaurant(this.currentRestaurantId).subscribe(
        data => {
          console.log(data)
            this.dishesList = data;
        }
      )
    });

  }

}
