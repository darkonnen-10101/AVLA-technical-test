import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LandingDataService } from '../service/data/landing-data.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  username = '';

  constructor(private route: ActivatedRoute, private service: LandingDataService) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['username'];
  }

}
