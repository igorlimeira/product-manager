import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AuthService{
  constructor(private http : HttpClient) { }
  private baseUrl = 'http://localhost:8080/auth'
}