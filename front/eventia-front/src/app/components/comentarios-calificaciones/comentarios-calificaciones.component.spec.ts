import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComentariosCalificacionesComponent } from './comentarios-calificaciones.component';

describe('ComentariosCalificacionesComponent', () => {
  let component: ComentariosCalificacionesComponent;
  let fixture: ComponentFixture<ComentariosCalificacionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComentariosCalificacionesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComentariosCalificacionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
