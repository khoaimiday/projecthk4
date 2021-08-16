import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Dishes } from 'src/app/interfaces/dishes';
import { Restaurant } from 'src/app/interfaces/restaurant';
import { DishesService } from 'src/app/services/dishes.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-tab-dishes',
  templateUrl: './tab-dishes.component.html',
  styleUrls: ['./tab-dishes.component.scss']
})
export class TabDishesComponent implements OnInit {
  
  //properties for panigation
  thePageNumber: number = 0;
  thePageSize: number = 5;
  theTotalElements: number = 0;
  
  dishesList = new Array(6);
  constructor(private route: Router,
              private router: ActivatedRoute, 
              private dishesService: DishesService,
              private restaurantService: RestaurantsService) { }

  ngOnInit() {
    const searchKey = this.router.snapshot.paramMap.get('key')!;

    if (searchKey) {
        // search by key
        this.doSearch(searchKey);
    }else{
        // get all
        this.getListFood();
    }
  }

  getListFood(){   
    //Get all Food
    this.dishesService.getAllDishes().subscribe(res => {
      this.dishesList = res;
    }); 
  }
  
  async goToMyRestaurant(dishes : Dishes) {
    // get restaurant
    const theRestaurant: Restaurant = await this.restaurantService.getRestaurantByDishesId(dishes.id);
    // navigate to restaurant
    this.route.navigate(['/restaurants', theRestaurant.id] , {state:{...theRestaurant} });
  }

  doSearch(value: string){
      this.dishesService.searchDishesContainNamePaginate(value, 0, this.thePageSize)
                                                        .subscribe(this.processResult());
  }

  processResult(){
    return res => {
        this.dishesList = res._embedded.disheses;

        this.thePageNumber = 1;
        this.thePageSize = res.page.size;
        this.theTotalElements = res.page.totalElements;
    }
  }

  changePaginator({length,pageIndex,pageSize,previousPageIndex}){
    //Get all dishes
    // this.dishesService.getAllDishes(pageIndex, pageSize).subscribe(res => {
    //   console.log(res)
    //   this.dishesList = res._embedded.disheses;
    //   this.thePageNumber = 1;
    //   this.thePageSize = res.page.size;
    //   this.theTotalElements = res.page.totalElements;
    // });
  }

}
