import { Component, OnInit } from '@angular/core'

@Component({
    selector: 'app-product-form',
    templateUrl: './product-form.view.html',
    styleUrls: ['./product-form.view.scss']
})
export class ProductFormView implements OnInit{
    editMode = false;
    
    constructor(){

    }
    ngOnInit(){

    }
}