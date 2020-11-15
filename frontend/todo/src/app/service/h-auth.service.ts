import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HAuthService {

  constructor() { }

  authenticate(username: string, password: string) {

    // console.log(this.isUserLoggedIn());

    if (username === 'user1' && password === 'password') {
      sessionStorage.setItem('authenticatedUser', username);
      // console.log(this.isUserLoggedIn());
      return true;
    } else {
      return false
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser');
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('authenticatedUser');
  }

}
