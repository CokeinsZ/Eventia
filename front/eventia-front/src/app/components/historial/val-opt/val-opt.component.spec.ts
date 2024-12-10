import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValOptComponent } from './val-opt.component';

describe('ValOptComponent', () => {
  let component: ValOptComponent;
  let fixture: ComponentFixture<ValOptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ValOptComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValOptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
