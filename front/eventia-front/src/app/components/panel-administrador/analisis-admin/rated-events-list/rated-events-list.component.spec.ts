import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RatedEventsListComponent } from './rated-events-list.component';

describe('RatedEventsListComponent', () => {
  let component: RatedEventsListComponent;
  let fixture: ComponentFixture<RatedEventsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RatedEventsListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RatedEventsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
