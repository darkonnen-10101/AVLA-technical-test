import { Injectable } from '@angular/core';
import { AUTHENTICATED_USER } from '../constants/constants';

@Injectable({
  providedIn: 'root'
})
export class HAuthService {

  constructor() { }

  authenticate(username: string, password: string) {

    // console.log(this.isUserLoggedIn());

    if (username === 'user1' && password === 'password') {
      sessionStorage.setItem(AUTHENTICATED_USER, username);
      // console.log(this.isUserLoggedIn());
      return true;
    } else {
      return false
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem(AUTHENTICATED_USER);
  }

}
