import { Component, OnDestroy, OnInit } from '@angular/core';
import { ProductsService } from './products.service'
import { Product } from './products.model'
import { Subject, Subscription } from 'rxjs';
@Component({
  selector: 'app-products',
  templateUrl: './products.view.html',
  styleUrls: ['./products.view.scss']
})
export class ProductsView implements OnInit, OnDestroy {
  
  dtTrigger = new Subject();
  products: Product[];
  // subs: Subscription;

  constructor(
    private productService: ProductsService
  ) { }

  ngOnInit() {
    this.productService.fetchProducts().subscribe(products => {
      this.products = products;
      this.dtTrigger.next();
    });
    // this.productService.fetchProducts().subscribe();
  }

  deleteProduct(id: number){
    this.productService.deleteProduct(id).subscribe(res => {
      this.products = this.products.filter(product => product.id !== res.id);
    });
  }

  ngOnDestroy() {
    this.dtTrigger.unsubscribe();
    // if (this.subs != null) {
    //   this.subs.unsubscribe();
    // }
  }
}
