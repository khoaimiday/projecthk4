import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DishesService {

  dishes : Dishes[] = [];

  api = "http://localhost:8080/api/disheses";
  constructor(private httpClient: HttpClient) { }

  getAllDishes(): Observable<Dishes[]> {
    return this.httpClient.get<GetDishesResponse>(this.api).pipe(
      map( response => this.dishes = response._embedded.disheses)
    )
  }

  getDishDetails(theDishesId : number): Observable<Dishes>{
    const searchUrl = `${this.api}/${theDishesId}`;
    return this.httpClient.get<Dishes>(searchUrl)
  }

  getDishesByRestaurant(restId: number): Observable<any>{
    const searchUrl = `${this.api}/search/findAllByRestaurantId?id=${restId}`;
    console.log(searchUrl)
    return this.httpClient.get<GetDishesResponse>(searchUrl).pipe(
      map(response => this.dishes = response._embedded.disheses)
    )
  }

  //Function search for searchPage with name contain
  // http://localhost:8080/api/disheses/search/findByFullNameContaining?name=k&page=0&size=20
  searchDishesContainName(searchValue: string){
    const searchUrl = `${this.api}/search/findByFullNameContaining?name=${searchValue}`;
    console.log(searchUrl)
    return this.httpClient.get<GetDishesResponse>(searchValue).pipe(
      map(response => this.dishes = response._embedded.disheses)
    )
  }

  searchDishesByDishCategory(searchValue: string){
    const searchUrl = `${this.api}/search/findAllByDishCategoryId?name=${searchValue}`;
    console.log(searchUrl)
    return this.httpClient.get<GetDishesResponse>(searchValue).pipe(
      map(response => this.dishes = response._embedded.disheses)
    )
  }



}

interface GetDishesResponse {
  _embedded: {
    disheses: Dishes[];
  }
}

export interface Dishes{
createdAt : Date;
updatedAt: Date;
id: number;
fullName: string;
unit: string;
quantity: number;
note: string;
rate: number;
price: number;
like: number;
delivered: number;
imageURL: string;
active: boolean;
itemCount :number;
}