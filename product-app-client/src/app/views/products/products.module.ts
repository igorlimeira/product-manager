import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductsView } from './products.view';
import { RouterModule, Routes } from '@angular/router';
import { ProductFormViewModule } from './products-form/product-form.view.module'
import { DataTablesModule } from 'angular-datatables';
const routes : Routes = [
  {
    path: '',
    component: ProductsView
  },
  {
    path: 'new',
    loadChildren: './products-form/product-form.view.module#ProductFormViewModule'
  },
  {
    path: ':id',
    loadChildren: './products-form/product-form.view.module#ProductFormViewModule'
  }
];

@NgModule({
  declarations: [ProductsView],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    DataTablesModule
  ]
})
export class ProductsModule { }
