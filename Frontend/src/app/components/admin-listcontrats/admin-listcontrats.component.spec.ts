import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListcontratsComponent } from './admin-listcontrats.component';

describe('AdminListcontratsComponent', () => {
  let component: AdminListcontratsComponent;
  let fixture: ComponentFixture<AdminListcontratsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListcontratsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListcontratsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
