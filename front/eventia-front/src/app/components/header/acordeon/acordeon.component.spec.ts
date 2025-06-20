import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcordeonComponent } from './acordeon.component';

describe('AcordeonComponent', () => {
  let component: AcordeonComponent;
  let fixture: ComponentFixture<AcordeonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AcordeonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcordeonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
