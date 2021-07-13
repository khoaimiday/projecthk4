import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthLoginInfo } from 'src/app/model/auth/login-info.model';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {

  private loginInfo: AuthLoginInfo;
  form: any = {};

  constructor(private router: Router,
              private toastr: ToastrService,
              private accountService: AccountService
              ) { }

  ngOnInit(): void {
  }

  login(){
    console.log(this.form)
    this.loginInfo = new AuthLoginInfo(
      this.form.username,
      this.form.password
    );

    this.accountService.signin(this.loginInfo).subscribe(
      response => {   
        this.notificationSuccess('Login Successful!');  
        console.log('Login Successful')        
        this.router.navigate(['home'], {queryParams: { isLogin: 'true' } });  
      },
      error => {
        console.log(error);
        this.notificationSuccess('Login failure');
      }
    )
  }

  notificationSuccess(notification: string) {
    this.toastr.success(notification, '', {
      timeOut: 1000, positionClass: 'toast-bottom-right'
    })
  }
}