import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsView } from './views/products/products.view';
import { ProductsModule } from './views/products/products.module'

const routes: Routes = [
  {
    path: '',
    redirectTo: '/products',
    pathMatch: 'full'
  },
  // {
  //   path: 'products',
  //   component: ProductsView
  // }
  {
    path: 'products',
    loadChildren: './views/products/products.module#ProductsModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
