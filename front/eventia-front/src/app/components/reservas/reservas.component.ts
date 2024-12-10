import { Component } from '@angular/core';
import { OptReservaComponent } from './opt-reserva/opt-reserva.component';
import { InfoReservaComponent } from './info-reserva/info-reserva.component';

@Component({
  selector: 'app-reservas',
  imports: [OptReservaComponent,InfoReservaComponent],
  templateUrl: './reservas.component.html',
  styleUrl: './reservas.component.css'
})
export class ReservasComponent {

}
