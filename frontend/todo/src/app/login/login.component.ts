import { Component, OnInit } from '@angular/core';

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

  constructor() { }

  ngOnInit(): void {
  }

  // DataBinding -> String Interpolation. Property Binding. Event Binding. Two-Way Data Binding.

  handleLogin() {
    // console.log(this.username);
    // console.log(this.password);
    // Hardcoding for testing purposes

    if (this.username === 'user1' && this.password === 'password') {
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }



  }

}
