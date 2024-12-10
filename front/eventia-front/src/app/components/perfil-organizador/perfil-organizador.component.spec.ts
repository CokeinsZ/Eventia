import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilOrganizadorComponent } from './perfil-organizador.component';

describe('PerfilOrganizadorComponent', () => {
  let component: PerfilOrganizadorComponent;
  let fixture: ComponentFixture<PerfilOrganizadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PerfilOrganizadorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilOrganizadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
