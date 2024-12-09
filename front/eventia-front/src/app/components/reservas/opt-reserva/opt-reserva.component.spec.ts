import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OptReservaComponent } from './opt-reserva.component';

describe('OptReservaComponent', () => {
  let component: OptReservaComponent;
  let fixture: ComponentFixture<OptReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OptReservaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OptReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
