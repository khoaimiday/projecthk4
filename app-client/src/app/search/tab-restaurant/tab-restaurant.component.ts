import { AfterViewInit, Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs/internal/Subject';
import { Restaurant } from 'src/app/interfaces/restaurant';
import { RestaurantsService } from 'src/app/services/restaurants.service';
import { FavouritesService } from 'src/app/services/favourites.service';
import { MatDialog } from '@angular/material';
import { RatingDialogComponent } from 'src/app/shared/rating-dialog/rating-dialog.component';

@Component({
  selector: 'app-tab-restaurant',
  templateUrl: './tab-restaurant.component.html',
  styleUrls: ['./tab-restaurant.component.scss']
})
export class TabRestaurantComponent implements OnInit{

  //properties for panigation
  thePageNumber: number = 0;
  thePageSize: number = 15;
  theTotalElements: number = 0;

  restaurants = new Array();

  constructor(private route: Router,
              private router: ActivatedRoute, 
              private restaurantService: RestaurantsService,
              private favouritesService: FavouritesService,
              public dialog: MatDialog) { }

  ngOnInit() {

    this.getListRestaurant();

  }


   getListRestaurant(){
    this.restaurantService.getAllRestaurantsPaginate(this.thePageNumber, this.thePageSize).subscribe(async res => {
      this.restaurants = await res._embedded.restaurants;
      this.thePageNumber = res.page.number +1;
      this.thePageSize = res.page.size;
      this.theTotalElements = res.page.totalElements;
    });
  }

  goToRestaurant(restaurant : Restaurant) {
    // navigate to restaurant
    this.route.navigate(['/restaurants', restaurant.id] , {state:{...restaurant} });
  }

  doSearch(key: string){
    //Search with tab Restaurant
      this.restaurantService.searchRestaurantsContainNamePaginate(key,  0, this.thePageSize)
                                                                                              .subscribe(this.processResult());
  }

  processResult(){
    return res => {
        this.restaurants = res._embedded.restaurants;

        this.thePageNumber = 1;
        this.thePageSize = res.page.size;
        this.theTotalElements = res.page.totalElements;
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

  addWishList(restaurant: Restaurant) {
    this.favouritesService.addWishList(restaurant);
  }

  openDialog(restaurant: Restaurant){
    this.dialog.open(RatingDialogComponent, {
      height: '400px',
      width: '800px',
      data: {
        restaurant: restaurant
      }
    })
  }

}
