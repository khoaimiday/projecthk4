import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DishesService } from 'src/app/services/dishes.service';
import { Cart } from 'src/app/interfaces/cart';


@Component({
  selector: 'app-food-order-for-restaurant',
  templateUrl: './food-order-for-restaurant.component.html',
  styleUrls: ['./food-order-for-restaurant.component.scss']
})
export class FoodOrderForRestaurantComponent implements OnInit {
  
  itemList: Cart[] = [];
  restaurantId: number;

  constructor(private route: ActivatedRoute,
              private dishesService: DishesService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.restaurantId = +this.route.snapshot.paramMap.get('id')

      this.dishesService.getDishesByRestaurant(this.restaurantId).subscribe(
        data => {
            this.itemList = data;
            console.log(this.itemList)
        }
      )
    });
  }

  remove(item: Cart){
    item.itemCount? item.itemCount-- : item.itemCount= 0;
    console.log(item.itemCount)
    console.log(item)
  }

  add(item: Cart){
    item.itemCount? item.itemCount++ : item.itemCount = 1;
    console.log(item.itemCount)
    console.log(item)
  }

}
