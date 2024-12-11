import { Component, Input } from '@angular/core';
import { ReservasListComponent } from '../reservas-list.component';

@Component({
  selector: 'app-print-reservas-list',
  imports: [ReservasListComponent],
  templateUrl: './print-reservas-list.component.html',
  styleUrl: './print-reservas-list.component.css'
})
export class PrintReservasListComponent {
@Input() users='';
@Input() nom_evento='';
@Input() date='';
@Input() place='';
}
