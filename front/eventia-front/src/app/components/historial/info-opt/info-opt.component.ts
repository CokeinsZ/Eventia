import { Component,Input } from '@angular/core';
import { HistorialComponent } from '../historial.component';

@Component({
  selector: 'app-info-opt',
  imports: [HistorialComponent],
  templateUrl: './info-opt.component.html',
  styleUrl: './info-opt.component.css'
})
export class InfoOptComponent {
  @Input() title='';
  @Input() descriptions='';
}
