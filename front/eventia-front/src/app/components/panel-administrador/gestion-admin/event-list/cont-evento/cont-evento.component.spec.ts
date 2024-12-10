import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContEventoComponent } from './cont-evento.component';

describe('ContEventoComponent', () => {
  let component: ContEventoComponent;
  let fixture: ComponentFixture<ContEventoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContEventoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContEventoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
