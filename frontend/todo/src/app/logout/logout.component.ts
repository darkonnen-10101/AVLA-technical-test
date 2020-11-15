import { Component, OnInit } from '@angular/core';
import { HAuthService } from '../service/h-auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(public hAuth: HAuthService) { }

  ngOnInit(): void {
    this.hAuth.logout();
  }

}

