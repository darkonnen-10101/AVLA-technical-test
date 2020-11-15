import { Component, OnInit } from '@angular/core';
import { HAuthService } from '../service/h-auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  // isUserLogged: boolean = false;

  constructor(public hAuth: HAuthService) { }

  ngOnInit(): void {
    // this.isUserLogged = this.hAuth.isUserLoggedIn();
  }

}
