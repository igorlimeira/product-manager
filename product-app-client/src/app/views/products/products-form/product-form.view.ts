import { Component, OnInit } from '@angular/core'
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../products.model';
import { ProductsService } from '../products.service';

@Component({
    selector: 'app-product-form',
    templateUrl: './product-form.view.html',
    styleUrls: ['./product-form.view.scss']
})
export class ProductFormView implements OnInit{
    editMode = false;
    form: FormGroup
    product: Product;

    constructor(
        private productService: ProductsService,
        private route : ActivatedRoute
        ){}
    ngOnInit(){
        this.route.paramMap.subscribe(paramMap => {
            if(paramMap.has('id')){
                this.editMode = true;
                this.productService.getProduct(parseInt(paramMap.get('id'))).subscribe(product => {
                    this.product = product;
                    this.initForm();
                });
            }else{
                this.initForm();
            }            
        });
    }

    initForm(){
        this.form = new FormGroup({
            barCode: new FormControl(this.product ? this.product.barCode : null, {
                updateOn: 'blur',
                validators: [Validators.required]
            }),
            description: new FormControl(this.product ? this.product.description : null, {
                updateOn: 'blur',
                validators: [Validators.required]
            }),
            price: new FormControl(this.product ? this.product.price : null, {
                updateOn: 'blur',
                validators: [Validators.required]
            })
        });
    }
}