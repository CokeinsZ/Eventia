import { Component } from '@angular/core';
import { TablaDisponibilidadComponent } from './tabla-disponibilidad/tabla-disponibilidad.component';


@Component({
  selector: 'app-detalle-evento',
  imports: [TablaDisponibilidadComponent],
  templateUrl: './detalle-evento.component.html',
  styleUrl: './detalle-evento.component.css'
})
export class DetalleEventoComponent {

}
