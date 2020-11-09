import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductsView } from './products.view';
import { RouterModule, Routes } from '@angular/router';
import { ProductFormViewModule } from './products-form/product-form.view.module'
const routes : Routes = [
  {
    path: '',
    component: ProductsView
  },
  {
    path: 'new',
    loadChildren: './products-form/product-form.view.module#ProductFormViewModule'
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
