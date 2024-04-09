import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TurainkComponent } from './turaink.component';

describe('TurainkComponent', () => {
  let component: TurainkComponent;
  let fixture: ComponentFixture<TurainkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TurainkComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TurainkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
