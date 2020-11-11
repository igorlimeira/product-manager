import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Product } from './products.model'

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  // private mProducts = new BehaviorSubject<Product[]>([]);
  constructor(private http : HttpClient) { }
  private baseUrl = 'http://localhost:8080/products'

  // get products(): Observable<Product[]>{
  //   return this.mProducts.asObservable();
  // }

  fetchProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl + "/lap")
    // .pipe(
    //   tap(products => {
    //     this.mProducts.next(products);
    //   })
    // );
  }

  getProduct(id: number): Observable<Product>{
    return this.http.get<Product>(this.baseUrl + "/lp/" + id);
  }

  addProduct(product: Product): Observable<Product>{
    return this.http.post<Product>(this.baseUrl + "/save", product);
  }

  deleteProduct(id: number): Observable<Product>{
    return this.http.delete<Product>(this.baseUrl + "/delete/" + id);
  }
}
