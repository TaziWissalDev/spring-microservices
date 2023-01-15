import { Component, OnInit } from '@angular/core';
import { BillService } from './services/bill.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'billingApplication';
  bill: any;

  billForm = new FormGroup({
    id: new FormControl(0)
  })

  constructor(private billService: BillService) {
  }

  ngOnInit(): void {

  }

  getBill() {
    this.billService.getBillInformation(this.billForm.value.id ?? 1).subscribe(res => {
      this.bill = res;
    });

  }
}
