import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  username = '';

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['username'];
  }

}
