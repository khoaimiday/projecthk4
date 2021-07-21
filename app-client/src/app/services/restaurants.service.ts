import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestaurantsService {

  restaurants : Restaurant[] = [];

  api = "http://localhost:8080/api/restaurants";
  constructor(private httpClient: HttpClient) { }

  getAllRestaurants(): Observable<Restaurant[]> {
    return this.httpClient.get<GetRestaurantsResponse>(this.api).pipe(
      map( response => this.restaurants = response._embedded.restaurants)
    ) 
  }

  getRestaurantDetails(theRestaurantId: number): Observable<Restaurant>{
    const searchUrl = `${this.api}/${theRestaurantId}`;
    return  this.httpClient.get<Restaurant>(searchUrl).pipe(
      // map(response => response)
    )
  }

  //Function search for searchPage with name contain
  // http://localhost:8080/api/restaurants/search/findByFullNameContaining?name=k&page=0&size=20
  searchRestaurantsContainName(searchValue: string) {
    const searchUrl = `${this.api}/search/findByFullNameContaining?name=${searchValue}`;
    console.log(searchUrl)
    return this.httpClient.get<GetRestaurantsResponse>(searchUrl).pipe(
      map( response => this.restaurants = response._embedded.restaurants)
    )
  }
}

interface GetRestaurantsResponse {
  _embedded: {
    restaurants: Restaurant[];
  }
}

export interface Restaurant {
  active: boolean;
  createdAt: Date;
  email: string;
  fullName: string;
  id: number;
  imageURL: string;
  navigationId: number
  phoneNumber: string;
  rate: number;
  updatedAt: Date;
}