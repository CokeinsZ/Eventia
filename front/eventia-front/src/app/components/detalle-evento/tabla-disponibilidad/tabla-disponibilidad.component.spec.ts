import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaDisponibilidadComponent } from './tabla-disponibilidad.component';

describe('TablaDisponibilidadComponent', () => {
  let component: TablaDisponibilidadComponent;
  let fixture: ComponentFixture<TablaDisponibilidadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TablaDisponibilidadComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablaDisponibilidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
