import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsView } from './views/products/products.view';
import { ProductsModule } from './views/products/products.module'
import {AuthModule} from './views/auth/auth.module'
import {AuthGuard} from './views/auth/auth.guard'

const routes: Routes = [
  {
    path: '',
    redirectTo: '/admin/products',
    pathMatch: 'full'
  },
  {
    path: 'admin/products',
    loadChildren: './views/products/products.module#ProductsModule',
    canActivate: [AuthGuard]
  },
  {
    path: 'auth',
    loadChildren: './views/auth/auth.module#AuthModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
