import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionarSaldoComponent } from './gestionar-saldo.component';

describe('GestionarSaldoComponent', () => {
  let component: GestionarSaldoComponent;
  let fixture: ComponentFixture<GestionarSaldoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestionarSaldoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestionarSaldoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
