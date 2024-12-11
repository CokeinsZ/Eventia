import { Component } from '@angular/core';
import { AnalisisAdminComponent } from "../analisis-admin.component";
import { PrintRatedEventsListComponent } from './print-rated-events-list/print-rated-events-list.component';

@Component({
  selector: 'app-rated-events-list',
  imports: [AnalisisAdminComponent, PrintRatedEventsListComponent],
  templateUrl: './rated-events-list.component.html',
  styleUrl: './rated-events-list.component.css'
})
export class RatedEventsListComponent {
nom_evento=['una fiesta'];
date=['Hoy'];
place=['mi casa'];
}
