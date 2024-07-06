import { Component } from '@angular/core';
import { ProductCardComponent } from '../../components/product-card/product-card.component';
import {MatPaginatorModule} from '@angular/material/paginator';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ProductCardComponent, MatPaginatorModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
