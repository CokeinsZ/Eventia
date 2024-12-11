import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintUserListComponent } from './print-user-list.component';

describe('PrintUserListComponent', () => {
  let component: PrintUserListComponent;
  let fixture: ComponentFixture<PrintUserListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrintUserListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrintUserListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
