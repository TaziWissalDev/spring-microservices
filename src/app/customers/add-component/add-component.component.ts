import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from 'src/app/services/customer.service';
declare var $: any;

@Component({
  selector: 'app-add-component',
  templateUrl: './add-component.component.html',
  styleUrls: ['./add-component.component.css']
})
export class AddComponentComponent implements OnInit {

  modeSpec = {action: 'none', method: 'add'};

  customerForm = new FormGroup({
    full_name: new FormControl('', Validators.required),
    email: new FormControl('', Validators.compose([Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")])),
 
  })


  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
  }
  

  show(data:any){

    if(data?.method == 'edit'){

    }


    $('#addCustomer').modal('show');
  }



  save(){
    var formData: any = new FormData();

  }

  hide() : void{
    $('#addCustomer').modal('hide');
  }

}
