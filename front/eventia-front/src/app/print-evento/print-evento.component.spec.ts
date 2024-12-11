import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintEventoComponent } from './print-evento.component';

describe('PrintEventoComponent', () => {
  let component: PrintEventoComponent;
  let fixture: ComponentFixture<PrintEventoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintEventoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintEventoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
