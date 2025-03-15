import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { EventsComponent } from './components/events/events.component';
import { LocationFilterPipe } from './pipes/location-filter.pipe';
import { RegisterEventComponent } from './components/register-event/register-event.component'; // ✅ Fix: Import RegisterEventComponent
import { CommonModule } from '@angular/common';
import { EventDetailComponent } from './components/event-detail/event-detail.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    EventsComponent,
    LocationFilterPipe,
    RegisterEventComponent,
    EventDetailComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule
  ],
  providers: [provideHttpClient(withFetch())], // ✅ Enables Fetch API without affecting existing functionality
  bootstrap: [AppComponent]
})
export class AppModule { }
