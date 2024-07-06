import { TestBed } from '@angular/core/testing';

import { ProductService } from './product.service';
import { ProductInterface } from '../interfaces/product.interface';

describe('ProductService', () => {
  let service: ProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('getInitialProduct', () => {
    it('should return initial product', () => {
      const product: ProductInterface = service.getInitialProduct();
      const initialProduct: ProductInterface = {
        id: -1,
        isNew: false,
        description: '',
        location: '',
        name: '',
        price: 0,
        views: 0
      };
  
      expect(product).toEqual(initialProduct);
    });
  });

});
