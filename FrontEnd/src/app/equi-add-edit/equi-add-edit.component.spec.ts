import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquiAddEditComponent } from './equi-add-edit.component';

describe('EquiAddEditComponent', () => {
  let component: EquiAddEditComponent;
  let fixture: ComponentFixture<EquiAddEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EquiAddEditComponent]
    });
    fixture = TestBed.createComponent(EquiAddEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
