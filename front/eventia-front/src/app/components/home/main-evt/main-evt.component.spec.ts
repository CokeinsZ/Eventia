import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainEvtComponent } from './main-evt.component';

describe('MainEvtComponent', () => {
  let component: MainEvtComponent;
  let fixture: ComponentFixture<MainEvtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MainEvtComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MainEvtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
