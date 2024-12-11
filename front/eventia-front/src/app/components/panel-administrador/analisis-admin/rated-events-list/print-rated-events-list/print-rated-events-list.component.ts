import { Component, Input } from '@angular/core';
import { RatedEventsListComponent } from '../rated-events-list.component';

@Component({
  selector: 'app-print-rated-events-list',
  imports: [RatedEventsListComponent],
  templateUrl: './print-rated-events-list.component.html',
  styleUrl: './print-rated-events-list.component.css'
})
export class PrintRatedEventsListComponent {
@Input() nom_evento='';
@Input() date='';
@Input() place='';
}
