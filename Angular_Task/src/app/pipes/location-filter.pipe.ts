import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'locationFilter',
})
export class LocationFilterPipe implements PipeTransform {
  transform(events: any[], searchLocation: string): any[] {
    if (!events || !searchLocation) {
      return events;
    }

    searchLocation = searchLocation.toLowerCase();

    return events.filter((event) =>
      event._embedded?.venues[0]?.name.toLowerCase().includes(searchLocation)
    );
  }
}
