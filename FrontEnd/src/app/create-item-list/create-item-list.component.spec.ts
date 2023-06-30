import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateItemListComponent } from './create-item-list.component';

describe('CreateItemListComponent', () => {
  let component: CreateItemListComponent;
  let fixture: ComponentFixture<CreateItemListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateItemListComponent]
    });
    fixture = TestBed.createComponent(CreateItemListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
