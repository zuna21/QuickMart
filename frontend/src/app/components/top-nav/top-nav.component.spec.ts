import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopNavComponent } from './top-nav.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

describe('TopNavComponent', () => {
  let component: TopNavComponent;
  let fixture: ComponentFixture<TopNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TopNavComponent],
      providers: [provideAnimationsAsync()]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TopNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render app name on mobile', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    component.isMobilePortrait = false;
    fixture.detectChanges();
    expect(compiled.querySelector('.title')?.textContent).toContain("QuickMart");
  });

  it('should not render app name if device is not mobile', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    component.isMobilePortrait = true;
    fixture.detectChanges();
    expect(compiled.querySelector('.title')?.textContent).toBeUndefined();
  })
});
