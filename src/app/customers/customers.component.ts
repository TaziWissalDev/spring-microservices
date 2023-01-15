import { Component, OnInit, ViewChild } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { faTrash, faPen,faMoneyBill1Wave } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  @ViewChild('addCustomer') addCustomer: any;


  data: any;
  faTrash:any;
  faPen:any;
  faMoneyBill1Wave:any;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.faTrash = faTrash;
    this.faPen = faPen;
    this.faMoneyBill1Wave = faMoneyBill1Wave;


   this.customerService.getCustomer().subscribe(data =>{
    this.data = data
   });


  }

  showModal(customerId: number){
    this.addCustomer.show({ action: 'add', customerId: customerId });
  }
}
