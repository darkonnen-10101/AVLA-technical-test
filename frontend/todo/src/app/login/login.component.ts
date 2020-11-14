import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = 'user1';
  password: string = 'password';
  errorMessage: string = 'Invalid credentials';
  invalidLogin: boolean = false;

  // Router

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  // DataBinding -> String Interpolation. Property Binding. Event Binding. Two-Way Data Binding.

  handleLogin() {
    // console.log(this.username);
    // console.log(this.password);
    // Hardcoding for testing purposes

    if (this.username === 'user1' && this.password === 'password') {
      // Redirect to Landing
      this.router.navigate(['landing', this.username]);
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }



  }

}
