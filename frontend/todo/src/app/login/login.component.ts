import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthService } from '../service/basic-auth.service';
import { HAuthService } from '../service/h-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  errorMessage: string = 'Invalid credentials';
  invalidLogin: boolean = false;

  // Router

  constructor(private router: Router, private hAuthService: HAuthService, private basicAuthservice: BasicAuthService) { }

  ngOnInit(): void {
  }

  // DataBinding -> String Interpolation. Property Binding. Event Binding. Two-Way Data Binding.

  handleLogin() {
    // console.log(this.username);
    // console.log(this.password);
    // Hardcoding for testing purposes

    // if (this.username === 'user1' && this.password === 'password') {
    if (this.hAuthService.authenticate(this.username, this.password)) {
      // Redirect to Landing
      this.router.navigate(['landing', this.username]);
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }



  }

  handleJWTAuthLogin() {
    this.basicAuthservice.executeJWTAuthenticationService(this.username, this.password)
      .subscribe(
        data => {
          console.log(data);
          this.router.navigate(['landing', this.username]);
          this.invalidLogin = false;
        }, error => {
          console.log(error);
          this.invalidLogin = true;
        }
      )
  }


  handleAuthLogin() {
    this.basicAuthservice.executeAuthenticationService(this.username, this.password)
      .subscribe(
        data => {
          console.log(data);
          this.router.navigate(['landing', this.username]);
          this.invalidLogin = false;
        }, error => {
          console.log(error);
          this.invalidLogin = true;
        }
      )
  }


}
