import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintUsersComponent } from './print-users.component';

describe('PrintUsersComponent', () => {
  let component: PrintUsersComponent;
  let fixture: ComponentFixture<PrintUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintUsersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
