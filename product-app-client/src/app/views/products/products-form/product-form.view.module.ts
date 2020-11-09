import { NgModule } from "@angular/core";

//import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ProductFormView } from "./product-form.view";

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
        RouterModule.forChild(routes)
    ]
})
export class ProductFormViewModule {} 
