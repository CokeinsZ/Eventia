import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintOrgIngresosArraysComponent } from './print-org-ingresos-arrays.component';

describe('PrintOrgIngresosArraysComponent', () => {
  let component: PrintOrgIngresosArraysComponent;
  let fixture: ComponentFixture<PrintOrgIngresosArraysComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintOrgIngresosArraysComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintOrgIngresosArraysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
