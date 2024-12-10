import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrgIngresosComponent } from './org-ingresos.component';

describe('OrgIngresosComponent', () => {
  let component: OrgIngresosComponent;
  let fixture: ComponentFixture<OrgIngresosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrgIngresosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrgIngresosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
