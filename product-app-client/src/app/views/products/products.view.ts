import { Component, OnDestroy, OnInit } from '@angular/core';
import { ProductsService } from './products.service'
import { Product } from './products.model'
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-products',
  templateUrl: './products.view.html',
  styleUrls: ['./products.view.scss']
})
export class ProductsView implements OnInit, OnDestroy {
  products: Product[];
  subs: Subscription;

  constructor(
    private productService: ProductsService
  ) { }

  ngOnInit() {
    this.subs = this.productService.products.subscribe(products => {
      this.products = products;
    });
    this.productService.fetchProducts().subscribe();
  }
  ngOnDestroy() {
    if (this.subs != null) {
      this.subs.unsubscribe();
    }
  }
}
