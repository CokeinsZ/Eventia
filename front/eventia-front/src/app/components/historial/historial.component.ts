import { Component } from '@angular/core';
import { ValOptComponent } from './val-opt/val-opt.component';
import { InfoOptComponent } from './info-opt/info-opt.component';

@Component({
  selector: 'app-historial',
  imports: [ValOptComponent,InfoOptComponent],
  templateUrl: './historial.component.html',
  styleUrl: './historial.component.css'
})
export class HistorialComponent {

}
