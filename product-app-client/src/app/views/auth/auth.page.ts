import {Component, OnInit} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {AuthService} from './auth.service'
@Component({
  selector: 'auth',
  templateUrl: './auth.page.html',
  styleUrls: ['./auth.page.scss']
})
export class AuthPage implements OnInit{

  form: FormGroup;
  constructor(private authService: AuthService, private router: Router){

  }
  ngOnInit(): void{
    this.form = new FormGroup({
      username: new FormControl(null, {
        updateOn: 'change',
        validators: [Validators.required]
      }),
      password: new FormControl(null, {
        updateOn: 'change',
        validators: [Validators.required]
      })
    });
  }


  login(){
    if(this.form.invalid){
      return
    }
  }
}