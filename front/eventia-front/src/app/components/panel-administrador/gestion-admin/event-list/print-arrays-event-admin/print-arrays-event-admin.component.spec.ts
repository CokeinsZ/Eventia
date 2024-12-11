import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintArraysEventAdminComponent } from './print-arrays-event-admin.component';

describe('PrintArraysEventAdminComponent', () => {
  let component: PrintArraysEventAdminComponent;
  let fixture: ComponentFixture<PrintArraysEventAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintArraysEventAdminComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintArraysEventAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
