import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NormalEvtComponent } from './normal-evt.component';

describe('NormalEvtComponent', () => {
  let component: NormalEvtComponent;
  let fixture: ComponentFixture<NormalEvtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NormalEvtComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NormalEvtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
