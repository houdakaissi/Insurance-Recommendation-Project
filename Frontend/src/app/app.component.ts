import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public router! :Router;
  constructor( ) {}
  title = 'real';
  private route!: ActivatedRoute

  showCart: boolean = false;
  cart: any[] = []; 
  toggleCart() {
    this.showCart = !this.showCart;
  }
  isDashboardRoute(): boolean {
    return this.route.snapshot.routeConfig?.path === 'dashboard';
  }
  addToCart(element: any) {
    // Add logic to add an item to the cart
    this.cart.push(element);
    // Optionally, you can toggle the cart visibility when an item is added
    // this.showCart = true;
  }

}
