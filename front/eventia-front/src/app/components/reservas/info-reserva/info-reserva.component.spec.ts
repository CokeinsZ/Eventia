import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoReservaComponent } from './info-reserva.component';

describe('InfoReservaComponent', () => {
  let component: InfoReservaComponent;
  let fixture: ComponentFixture<InfoReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InfoReservaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
