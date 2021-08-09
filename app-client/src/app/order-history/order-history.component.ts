import { Component, AfterViewInit, ViewChild, OnInit } from '@angular/core';
import { OrderHistory } from '../common/order-history';
import { OrderHistoryService } from '../services/order-history.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.scss']
})
export class OrderHistoryComponent implements OnInit ,AfterViewInit {
  
  storage: Storage = sessionStorage;

  displayedColumns: string[] = ['orderTrackingNumber', 'totalPrice', 'totalQuantity', 'status', 'createdAt'];
  dataSource = new MatTableDataSource<OrderHistory>([])


  constructor(private orderHistoryService: OrderHistoryService) { }
  
  @ViewChild(MatPaginator, null) paginator: MatPaginator;

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {
    this.handleOrderHistory();
    console.log(this.displayedColumns)

  }

  handleOrderHistory() {

    //read the user's email address from browser storage
    let theEmail = JSON.parse(this.storage.getItem("userEmail"));
    if (theEmail == null) {
      theEmail = "khoaimiday@gmail.com";
    }

    //retrieve data from the service
    this.orderHistoryService.getOrderHistory(theEmail).subscribe(
      data => {
        console.log(data)
        this.dataSource.data = data._embedded.orders;
      }
    )
  }

}
