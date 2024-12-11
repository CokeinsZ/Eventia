import { Component } from '@angular/core';
import { AgendaComponent } from './agenda/agenda.component';

@Component({
  selector: 'app-new-publish',
  imports: [AgendaComponent],
  templateUrl: './new-publish.component.html',
  styleUrl: './new-publish.component.css'
})
export class NewPublishComponent {
  banner='banner.jpg';
  capacidad_max=3000;
}
