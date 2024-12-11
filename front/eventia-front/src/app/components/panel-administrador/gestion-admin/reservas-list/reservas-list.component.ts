import { Component } from '@angular/core';
import { GestionAdminComponent } from "../gestion-admin.component";
import { PrintReservasListComponent } from './print-reservas-list/print-reservas-list.component';

@Component({
  selector: 'app-reservas-list',
  imports: [GestionAdminComponent,PrintReservasListComponent
  ],
  templateUrl: './reservas-list.component.html',
  styleUrl: './reservas-list.component.css'
})
export class ReservasListComponent {
users=['Rogelio'];
nom_evento=['Fiesta'];
date=['hoy'];
place=['uam'];
}
