import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintIngresosListComponent } from './print-ingresos-list.component';

describe('PrintIngresosListComponent', () => {
  let component: PrintIngresosListComponent;
  let fixture: ComponentFixture<PrintIngresosListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintIngresosListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintIngresosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
