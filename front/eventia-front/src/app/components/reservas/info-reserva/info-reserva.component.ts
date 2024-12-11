import { Component, Input } from '@angular/core';
import { ReservasComponent } from '../reservas.component';

@Component({
  selector: 'app-info-reserva',
  imports: [ReservasComponent],
  templateUrl: './info-reserva.component.html',
  styleUrl: './info-reserva.component.css'
})
export class InfoReservaComponent {
  @Input() title="";
  @Input() descriptions="";
}
