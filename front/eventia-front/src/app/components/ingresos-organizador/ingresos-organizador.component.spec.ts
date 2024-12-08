import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresosOrganizadorComponent } from './ingresos-organizador.component';

describe('IngresosOrganizadorComponent', () => {
  let component: IngresosOrganizadorComponent;
  let fixture: ComponentFixture<IngresosOrganizadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IngresosOrganizadorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngresosOrganizadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
