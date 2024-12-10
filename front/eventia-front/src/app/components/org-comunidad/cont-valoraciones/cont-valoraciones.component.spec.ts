import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContValoracionesComponent } from './cont-valoraciones.component';

describe('ContValoracionesComponent', () => {
  let component: ContValoracionesComponent;
  let fixture: ComponentFixture<ContValoracionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContValoracionesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContValoracionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
