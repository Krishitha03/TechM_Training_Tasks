import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-event',
  templateUrl: './register-event.component.html',
  styleUrls: ['./register-event.component.css']
})
export class RegisterEventComponent {
  user = { username: '', password: '' };
  registeredUsers: any[] = [];

  constructor(private router: Router) {}

  registerUser() {
    if (this.user.username && this.user.password) {
      localStorage.setItem(this.user.username, JSON.stringify(this.user));
      alert('Registration successful! You can now log in.');
      this.router.navigate(['/login']);
    } else {
      alert('Please fill in all fields.');
    }
  }
}
