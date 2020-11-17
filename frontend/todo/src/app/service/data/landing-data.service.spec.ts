import { TestBed } from '@angular/core/testing';

import { LandingDataService } from './landing-data.service';

describe('LandingDataService', () => {
  let service: LandingDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LandingDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
