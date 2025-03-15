import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private users: any[] = [];
  private loggedInUser: any = null;
  private authStatus = new BehaviorSubject<boolean>(this.isLoggedIn());

  authStatus$ = this.authStatus.asObservable();

  constructor() {
    if (typeof window !== 'undefined') {
      this.loadUsers();
    }
  }

  private loadUsers() {
    if (typeof window !== 'undefined' && localStorage) {
      const storedUsers = localStorage.getItem('users');
      this.users = storedUsers ? JSON.parse(storedUsers) : [];
    }
  }

  register(username: string, password: string) {
    if (!this.users.some(user => user.username === username)) {
      this.users.push({ username, password });
      if (typeof window !== 'undefined' && localStorage) {
        localStorage.setItem('users', JSON.stringify(this.users));
      }
      return true;
    }
    return false;
  }

  login(username: string, password: string): boolean {
    this.loadUsers();
    const user = this.users.find(u => u.username === username && u.password === password);
    if (user) {
      this.loggedInUser = user;
      if (typeof window !== 'undefined' && localStorage) {
        localStorage.setItem('loggedInUser', JSON.stringify(user));
      }
      this.authStatus.next(true); // Notify components of login state change
      return true;
    }
    return false;
  }

  logout() {
    this.loggedInUser = null;
    if (typeof window !== 'undefined' && localStorage) {
      localStorage.removeItem('loggedInUser');
    }
    this.authStatus.next(false); // Notify components of logout state change
  }

  isLoggedIn(): boolean {
    if (typeof window !== 'undefined' && localStorage) {
      return localStorage.getItem('loggedInUser') !== null;
    }
    return false;
  }
}
