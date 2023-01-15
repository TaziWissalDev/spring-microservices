import { Component, OnInit } from '@angular/core';
import { faCoffee,faDollar,faTrash, faPen } from '@fortawesome/free-solid-svg-icons';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  data: any;
  faCoffee:any;
  faDollar:any;
  faTrash:any;
  faPen:any;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.faCoffee = faCoffee;
    this.faDollar = faDollar;
    this.faTrash = faTrash;
    this.faPen = faPen;

   this.productService.getProducts().subscribe(data =>{
    this.data = data
   });
  }

}
