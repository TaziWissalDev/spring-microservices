import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getCustomer():Observable<any>{
    return this.http.get('http://localhost:8888/CUSTOMER-SERVICE/customers');
  }

  getBillByCustomer(customerId: number): Observable<any>{
    return this.http.get('http://localhost:8888/BILLING-SERVICE/bills/search/byCustomerId?customerId'+ customerId);
  }
}
