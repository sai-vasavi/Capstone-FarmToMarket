import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewHiredEquipComponent } from './view-hired-equip.component';

describe('ViewHiredEquipComponent', () => {
  let component: ViewHiredEquipComponent;
  let fixture: ComponentFixture<ViewHiredEquipComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewHiredEquipComponent]
    });
    fixture = TestBed.createComponent(ViewHiredEquipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
