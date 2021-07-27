import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from '../../interfaces/cart';
import { Dishes } from '../../interfaces/dishes';
import { CartService } from '../../services/cart.service';
import { DishesService } from '../../services/dishes.service';


@Component({
  selector: 'app-food-order-for-restaurant',
  templateUrl: './food-order-for-restaurant.component.html',
  styleUrls: ['./food-order-for-restaurant.component.scss']
})
export class FoodOrderForRestaurantComponent implements OnInit {
  
  itemList: Dishes[] = [];
  restaurantId: number;

  constructor(private route: ActivatedRoute,
              private cartService: CartService,
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

  remove(item: Dishes){
    if (item.quantity > 0) item.quantity--;
    console.log(item.quantity)
    console.log(item)
    this.addToCart(item)
  }

  add(item: Dishes){
    item.quantity++;
    console.log(item.quantity)
    console.log(item);
    this.addToCart(item)
  }

  addToCart(item: Dishes) {  
    const theCartItem = new CartItem(item);
    theCartItem.restanrantId = this.restaurantId;

    this.cartService.addToCart(theCartItem);
  }

}
