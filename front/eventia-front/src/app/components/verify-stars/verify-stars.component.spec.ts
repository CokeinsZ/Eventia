import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerifyStarsComponent } from './verify-stars.component';

describe('VerifyStarsComponent', () => {
  let component: VerifyStarsComponent;
  let fixture: ComponentFixture<VerifyStarsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerifyStarsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerifyStarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
