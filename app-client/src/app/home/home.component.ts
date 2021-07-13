import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  
 
  constructor(private router: ActivatedRoute,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    // this.router.queryParams
    // .subscribe(params => {
    //   if(params.isLogin !== undefined && params.isLogin === 'true') {
    //     this.toastr.success('Login Successful!');
    //   }
    // });
  }

}
