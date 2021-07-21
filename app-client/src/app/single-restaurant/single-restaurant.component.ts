import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestaurantsService } from '../services/restaurants.service';

@Component({
  selector: 'app-single-restaurant',
  templateUrl: './single-restaurant.component.html',
  styleUrls: ['./single-restaurant.component.scss']
})
export class SingleRestaurantComponent implements OnInit {

  restaurant : any;
  currentRestaurantId: number;



  itemList = new Array(4);
  constructor(private restaurantService : RestaurantsService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.currentRestaurantId = +this.route.snapshot.paramMap.get('id')
      this.restaurant = window.history.state;
      console.log(this.currentRestaurantId)
      console.log(this.restaurant)
    });

  }

}
