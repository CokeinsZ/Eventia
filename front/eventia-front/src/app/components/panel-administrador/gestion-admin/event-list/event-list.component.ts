import { Component } from '@angular/core';
import { GestionAdminComponent } from "../gestion-admin.component";
import { ContEventoComponent } from "./cont-evento/cont-evento.component";
import { PrintArraysEventAdminComponent } from './print-arrays-event-admin/print-arrays-event-admin.component';

@Component({
  selector: 'app-event-list',
  imports: [GestionAdminComponent, ContEventoComponent,PrintArraysEventAdminComponent],
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css'
})
export class EventListComponent {
  title=['titulo de evento'];
  description=['descripcion de evento'];
  date=['2024-02-02'];
  place=['madrid'];
  aforo=[6000]
}
