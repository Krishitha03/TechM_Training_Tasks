import { Component, OnInit } from '@angular/core';
import { EventsService } from '../../services/event.service';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css'],
})
export class EventsComponent implements OnInit {
  events: any[] = [];
  searchLocation: string = '';
  currentPage: number = 0;
  totalPages: number = 1;
  pageSize: number = 10;

  constructor(
    private eventsService: EventsService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadEvents();
  }

  loadEvents(): void {
    if (this.currentPage >= this.totalPages) return;

    this.eventsService.getEvents(this.currentPage, this.pageSize).subscribe(
      (response) => {
        if (response._embedded?.events) {
          this.events = [...this.events, ...response._embedded.events];
          this.totalPages = response.page.totalPages;
          this.currentPage++;
        }
      },
      (error) => {
        console.error('Error fetching events:', error);
      }
    );
  }

  loadMore(): void {
    this.loadEvents();
  }

  viewDetails(eventId: string): void {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/event', eventId]);
    } else {
      this.router.navigate(['/login']);
    }
  }
}
