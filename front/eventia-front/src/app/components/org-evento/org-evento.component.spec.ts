import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrgEventoComponent } from './org-evento.component';

describe('OrgEventoComponent', () => {
  let component: OrgEventoComponent;
  let fixture: ComponentFixture<OrgEventoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrgEventoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrgEventoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
