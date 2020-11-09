import { NgModule } from "@angular/core";

//import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ProductFormView } from "./product-form.view";
import { ReactiveFormsModule } from '@angular/forms';

const routes : Routes = [
    {
        path: '',
        component: ProductFormView
    }
];
@NgModule({
    declarations: [ProductFormView],
    imports: [
        CommonModule,
        RouterModule.forChild(routes),
        ReactiveFormsModule
    ],
})
export class ProductFormViewModule {} 
