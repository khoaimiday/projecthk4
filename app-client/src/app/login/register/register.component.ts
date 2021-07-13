import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/model/user';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  errorMessage: string;
  constructor(public accountService: AccountService,
              public router: Router,
              private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  register(){
    this.accountService.signup(this.user).subscribe(
      response => {},
      error => {}
    )
  }
  
  notificationSuccess(notification: string) {
    this.toastr.success(notification, '', {
      timeOut: 2000, positionClass: 'toast-top-center'
    });
  }

  notificationError(notification: string) {
    this.toastr.error(notification, 'Thông báo');
  }

}
