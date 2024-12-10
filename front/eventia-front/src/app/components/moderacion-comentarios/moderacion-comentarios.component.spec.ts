import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModeracionComentariosComponent } from './moderacion-comentarios.component';

describe('ModeracionComentariosComponent', () => {
  let component: ModeracionComentariosComponent;
  let fixture: ComponentFixture<ModeracionComentariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModeracionComentariosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModeracionComentariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
