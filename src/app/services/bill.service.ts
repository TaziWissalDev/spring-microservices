import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BillService {

  constructor(private http: HttpClient) { }

  getBillInformation(id: Number):Observable<any>{
    return this.http.get('http://localhost:8888/BILLING-SERVICE/fullBill/'+ id);
  }
}
