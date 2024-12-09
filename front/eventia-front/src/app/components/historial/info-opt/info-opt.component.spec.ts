import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoOptComponent } from './info-opt.component';

describe('InfoOptComponent', () => {
  let component: InfoOptComponent;
  let fixture: ComponentFixture<InfoOptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InfoOptComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoOptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
