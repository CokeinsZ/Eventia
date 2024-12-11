import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintUserEvtOrgComponent } from './print-user-evt-org.component';

describe('PrintUserEvtOrgComponent', () => {
  let component: PrintUserEvtOrgComponent;
  let fixture: ComponentFixture<PrintUserEvtOrgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintUserEvtOrgComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintUserEvtOrgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
