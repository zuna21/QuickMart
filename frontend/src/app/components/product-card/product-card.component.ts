import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { NgClass, NgStyle } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import {MatCardModule} from '@angular/material/card';



@Component({
  selector: 'app-product-card',
  standalone: true,
  imports: [MatCardModule, NgStyle],
  templateUrl: './product-card.component.html',
  styleUrl: './product-card.component.css'
})
export class ProductCardComponent implements OnInit {
  private breakpointObserver = inject(BreakpointObserver);
  public isMobilePortrait: boolean = false;

  ngOnInit(): void {
    this.isMobilePortraitFun();
  }

  private isMobilePortraitFun(): void {
    this.breakpointObserver.observe([Breakpoints.HandsetPortrait]).subscribe({
      next: result => this.isMobilePortrait = result.matches
    });
  }

}
