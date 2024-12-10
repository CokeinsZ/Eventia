import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrgComunidadComponent } from './org-comunidad.component';

describe('OrgComunidadComponent', () => {
  let component: OrgComunidadComponent;
  let fixture: ComponentFixture<OrgComunidadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrgComunidadComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrgComunidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
