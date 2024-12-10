import { Component } from '@angular/core';
import { GestionAdminComponent } from "../gestion-admin.component";
import { ContEventoComponent } from "./cont-evento/cont-evento.component";

@Component({
  selector: 'app-event-list',
  imports: [GestionAdminComponent, ContEventoComponent],
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css'
})
export class EventListComponent {

}
