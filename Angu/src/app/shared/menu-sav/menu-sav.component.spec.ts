import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuSavComponent } from './menu-sav.component';

describe('MenuSavComponent', () => {
  let component: MenuSavComponent;
  let fixture: ComponentFixture<MenuSavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MenuSavComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MenuSavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
