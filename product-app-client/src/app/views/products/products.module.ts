import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductsView } from './products.view';
import { RouterModule, Routes } from '@angular/router';

const routes : Routes = [
  {
    path: '',
    component: ProductsView
  }
];

@NgModule({
  declarations: [ProductsView],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class ProductsModule { }
