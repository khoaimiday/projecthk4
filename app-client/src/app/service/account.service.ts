import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { config } from '../../config/config';
import { User } from 'src/app/model/user';

import {map} from 'rxjs/operators';
import { ReplaySubject } from 'rxjs';
import { AuthLoginInfo } from '../model/auth/login-info.model';
import { ActivatedRoute, ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  currentUserSource = new ReplaySubject<User>(1);
  currentUser$ = this.currentUserSource.asObservable();

  constructor(private http:HttpClient, private router: Router) { }

  signin(credentials: AuthLoginInfo){
    return this.http.post( config.routeAPI + '/api/auth/signin', credentials, httpOptions).pipe(
      map( (response : any)=>{
        const user = response;
        if (user) {
          localStorage.setItem('user', JSON.stringify(user));
          this.currentUserSource.next(user);
        }
      })
    )
  }

  logout(){
    localStorage.removeItem('user');
    this.currentUserSource.next(null);
  }

  setCurrentUser(user: any){
    this.currentUserSource.next(user);
  }

  signup(info: User) {
    return this.http.post(config.routeAPI + '/api/auth/signup', info, httpOptions);
  }

  getDataUser(user: User){
    return this.http.post(config.data_user_API, user);
  }

  canActive(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    
    if (JSON.parse(localStorage.getItem('user')).username) {
      //logged in so return true
      return true;
  }
    //not logged in so redirect to login page with the return url
    this.router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
    return false;
  }
}
