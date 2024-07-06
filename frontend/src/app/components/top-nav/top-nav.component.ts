import { Component, inject, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';



@Component({
  selector: 'app-top-nav',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatButtonModule, MatIconModule, MatToolbarModule],
  templateUrl: './top-nav.component.html',
  styleUrl: './top-nav.component.css'
})
export class TopNavComponent implements OnInit {

  private responsive = inject(BreakpointObserver);
  
  public isMobilePortrait: boolean = false;

  ngOnInit(): void {
    this.isMobilePortraitFun();
  }

  isMobilePortraitFun() {
    this.responsive.observe([Breakpoints.HandsetPortrait]).subscribe({
      next: result => this.isMobilePortrait = result.matches
    });
  }
}
