import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddcontractsComponent } from './admin-addcontracts.component';

describe('AdminAddcontractsComponent', () => {
  let component: AdminAddcontractsComponent;
  let fixture: ComponentFixture<AdminAddcontractsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddcontractsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddcontractsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
