import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestaurantsService {

  restaurants : Restaurant[] = [];

  private api = "http://localhost:8080/api/restaurants";
  
  constructor(private httpClient: HttpClient) { }

  getAllRestaurantsPaginate(thePage: number, 
                            thePageSize: number): Observable<GetRestaurantsResponse> {
    const getUrl = `${this.api}?page=${thePage -1 }&size=${thePageSize}`;
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
    console.log(searchUrl)
    return this.httpClient.get<GetRestaurantsResponse>(searchUrl).pipe(
      map( response => this.restaurants = response._embedded.restaurants)
    )
  }

  getRestaurantDetails(theRestaurantId: number): Observable<Restaurant>{
    const searchUrl = `${this.api}/${theRestaurantId}`;
    return  this.httpClient.get<Restaurant>(searchUrl).pipe(
      // map(response => response)
    )
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