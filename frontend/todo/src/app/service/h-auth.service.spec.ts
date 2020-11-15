import { TestBed } from '@angular/core/testing';

import { HAuthService } from './h-auth.service';

describe('HAuthService', () => {
  let service: HAuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HAuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
