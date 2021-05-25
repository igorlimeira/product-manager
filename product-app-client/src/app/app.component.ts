import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './views/auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'product-app-client';
  constructor(public authService: AuthService, private router: Router){

  }
  logout(){
    this.authService.logout();
    this.router.navigate(['/auth']);
  }
}
