import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Restaurant } from '../interfaces/restaurant';
import { AddressService } from './address.service';
import { Address } from '../interfaces/address';

@Injectable({
  providedIn: 'root'
})
export class RestaurantsService {

  restaurants : Restaurant[] = [];
  restaurant: Restaurant;

  private api = "http://localhost:8080/api/restaurants";
  
  constructor(private httpClient: HttpClient,
              private addressService: AddressService) { }

  getAllRestaurantsPaginate(thePage: number, 
                            thePageSize: number): Observable<GetRestaurantsResponse> {
    const getUrl = `${this.api}?page=${thePage }&size=${thePageSize}`;
    console.log(getUrl)
    return this.httpClient.get<GetRestaurantsResponse>(getUrl)
  }

  getAllRestaurants(): Observable<Restaurant[]> {
    return this.httpClient.get<GetRestaurantsResponse>(this.api).pipe(
      map( response => this.restaurants = response._embedded.restaurants)
    ) 
  }

  //Function search for searchPage with name contain
  searchRestaurantsContainNamePaginate(searchValue: string,
                                      thePage: number,
                                      thePageSize: number): Observable<any>  {
    const searchUrl = `${this.api}/search/findByFullNameContaining?name=${searchValue}`
                    + `&page=${thePage}&size=${thePageSize}`;
    console.log(searchUrl)
    return this.httpClient.get<any>(searchUrl);
  }

  //Function search for searchPage with name contain
  searchRestaurantsContainName(searchValue: string) {
    const searchUrl = `${this.api}/search/findByFullNameContaining?name=${searchValue}`;
    return this.httpClient.get<GetRestaurantsResponse>(searchUrl).pipe(
      map( response => this.restaurants = response._embedded.restaurants)
    )
  }

  getRestaurantDetails(theRestaurantId: number): Observable<Restaurant>{
    const searchUrl = `${this.api}/${theRestaurantId}`;
    return  this.httpClient.get<Restaurant>(searchUrl).pipe(
      map (mainData => {
        this.restaurant = mainData;
        this.addressService.getAddressForRestaurant(mainData.id).subscribe(
          data => {
            this.restaurant.address = data
          },
           error => {
              console.log('address not found!');
              console.log(this.restaurant.address)
           }         
        )      
        return this.restaurant;
      })
    )
  } 

  getRestaurantByDishesId(theId: number): Restaurant{
    const searchUrl = `${this.api}/search/findByDishesListId?id=${theId}`;
    this.httpClient.get<Restaurant>(searchUrl).toPromise().then(
      result => {
        this.restaurant = result;
        this.addressService.getAddressForRestaurant(result.id).toPromise().then(
          result => this.restaurant.address = result
        )
      }
    )
    return this.restaurant
  }
}



interface GetRestaurantsResponse {
  _embedded: {
    restaurants: Restaurant[];
  },
  page: {
    size: number, //size off the page
    totalElements: number,
    totalPages: number, //total pages available
    number: number //current page number
  }
}
