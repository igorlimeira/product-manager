import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { Routes, RouterModule } from "@angular/router";
import { AuthPage } from "./auth.page";

const routes: Routes = [
  {
    path: '',
    component: AuthPage
  }
]
@NgModule({
  declarations: [AuthPage],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule
  ]
})
export class AuthModule{

}