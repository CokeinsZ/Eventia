import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalisisAdminComponent } from './analisis-admin.component';

describe('AnalisisAdminComponent', () => {
  let component: AnalisisAdminComponent;
  let fixture: ComponentFixture<AnalisisAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnalisisAdminComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnalisisAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
