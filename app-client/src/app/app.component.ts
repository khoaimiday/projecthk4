import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AccountService } from './service/account.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app-client';
  user : any;

  constructor(private http: HttpClient, private accountService: AccountService ){}

  ngOnInit(){
    this.getUser();
    this.setCurrentUser();
  }

  setCurrentUser(){
    const user: any = JSON.parse(localStorage.getItem('user'));
    this.accountService.setCurrentUser(user);
  }

  getUser() {
  }
}
