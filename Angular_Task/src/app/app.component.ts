import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'local-events-finder';
  isLoggedIn = false; // Track login state

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit() {
    // Subscribe to auth status for UI updates
    this.authService.authStatus$.subscribe(status => {
      this.isLoggedIn = status;
    });
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/']); // Redirect to home after logout
  }
}
