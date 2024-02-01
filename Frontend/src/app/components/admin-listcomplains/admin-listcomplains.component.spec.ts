import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListcomplainsComponent } from './admin-listcomplains.component';

describe('AdminListcomplainsComponent', () => {
  let component: AdminListcomplainsComponent;
  let fixture: ComponentFixture<AdminListcomplainsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListcomplainsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListcomplainsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
