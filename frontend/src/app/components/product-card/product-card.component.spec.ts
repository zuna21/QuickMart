import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductCardComponent } from './product-card.component';

describe('ProductCardComponent', () => {
  let component: ProductCardComponent;
  let fixture: ComponentFixture<ProductCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProductCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have max width if mobile', () => {
    component.isMobilePortrait = true;
    fixture.detectChanges();
    const elementWidht = fixture.nativeElement.querySelector('mat-card')?.style.width
    expect(elementWidht).toBe('100%');
  });

  it('should have 280px if device larger than mobile', () => {
    component.isMobilePortrait = false;
    fixture.detectChanges();
    const elementWidht = fixture.nativeElement.querySelector('mat-card')?.style.width
    expect(elementWidht).toBe('280px');
  });
});
