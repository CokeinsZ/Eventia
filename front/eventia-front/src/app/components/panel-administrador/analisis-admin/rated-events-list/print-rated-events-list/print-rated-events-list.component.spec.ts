import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintRatedEventsListComponent } from './print-rated-events-list.component';

describe('PrintRatedEventsListComponent', () => {
  let component: PrintRatedEventsListComponent;
  let fixture: ComponentFixture<PrintRatedEventsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintRatedEventsListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintRatedEventsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
