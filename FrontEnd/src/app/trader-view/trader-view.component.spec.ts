import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraderViewComponent } from './trader-view.component';

describe('TraderViewComponent', () => {
  let component: TraderViewComponent;
  let fixture: ComponentFixture<TraderViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TraderViewComponent]
    });
    fixture = TestBed.createComponent(TraderViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
