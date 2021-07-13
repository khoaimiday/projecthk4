import { Component, Input, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';
import { AccountService } from 'src/app/service/account.service';


@Component({
  selector: 'app-header-top-link',
  templateUrl: './header-top-link.component.html',
  styleUrls: ['./header-top-link.component.scss']
})
export class HeaderTopLinkComponent implements OnInit {
  
  currentUser$ : Observable<any> ;

  constructor(private accountService: AccountService,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.currentUser$ = this.accountService.currentUser$;
  }

  logout(){
    this.accountService.logout();
    this.toastr.success("Logout Successful", '', {
      timeOut: 1000, positionClass: 'toast-bottom-right'
    })
  }
}
