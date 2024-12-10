import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePublishComponent } from './update-publish.component';

describe('UpdatePublishComponent', () => {
  let component: UpdatePublishComponent;
  let fixture: ComponentFixture<UpdatePublishComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdatePublishComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatePublishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
