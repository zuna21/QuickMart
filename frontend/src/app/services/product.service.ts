import { Injectable } from '@angular/core';
import { ProductInterface } from '../interfaces/product.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private initialProduct: ProductInterface = {
    id: -1,
    description: "",
    isNew: false,
    location: "",
    name: "",
    price: 0,
    views: 0
  }

  constructor() { }

  public getInitialProduct(): ProductInterface {
    return {...this.initialProduct};
  }
}
