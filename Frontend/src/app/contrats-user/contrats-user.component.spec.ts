import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContratsUserComponent } from './contrats-user.component';

describe('ContratsUserComponent', () => {
  let component: ContratsUserComponent;
  let fixture: ComponentFixture<ContratsUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContratsUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContratsUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
