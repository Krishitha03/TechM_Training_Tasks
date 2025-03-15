import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EventsService {
  private API_KEY = 'fyyEUabAGLQLBdqCtUCAt9ZPg27NV9Ay';
  private BASE_URL = 'https://app.ticketmaster.com/discovery/v2/events.json';

  constructor(private http: HttpClient) {}

  getEvents(page: number, size: number): Observable<any> {
    const url = `${this.BASE_URL}?apikey=${this.API_KEY}&page=${page}&size=${size}`;
    return this.http.get<any>(url);
  }

  getEventById(eventId: string): Observable<any> {
    const url = `https://app.ticketmaster.com/discovery/v2/events/${eventId}.json?apikey=${this.API_KEY}`;
    return this.http.get<any>(url);
  }
}
