import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RouterModule } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  private api = "http://localhost:8080/api/rating";

  constructor(private httpClient: HttpClient,
              ) { }

  submitRating(data: any){
    console.log(data)
    this.httpClient.post(`${this.api}/restaurant`, data).subscribe(
      result => {
         return result
        
      },
      err => {
        console.log(err)
        return null
      }
    )
  }

}
