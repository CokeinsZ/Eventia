import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintReservasListComponent } from './print-reservas-list.component';

describe('PrintReservasListComponent', () => {
  let component: PrintReservasListComponent;
  let fixture: ComponentFixture<PrintReservasListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintReservasListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintReservasListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
