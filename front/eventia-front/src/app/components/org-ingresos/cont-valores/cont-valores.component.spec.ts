import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContValoresComponent } from './cont-valores.component';

describe('ContValoresComponent', () => {
  let component: ContValoresComponent;
  let fixture: ComponentFixture<ContValoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContValoresComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContValoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
