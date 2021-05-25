import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http'
import {User} from './auth.model'
@Injectable({
  providedIn: 'root'
})
export class AuthService{
  private mAuthenticated = false;

  get authenticated(){
    return this.mAuthenticated;
  }

  login(user: User){
    if(user.username === 'root' && user.password === 'root'){
      this.mAuthenticated = true;
    }
  }

  logout(){
    this.mAuthenticated = false;
  }
}