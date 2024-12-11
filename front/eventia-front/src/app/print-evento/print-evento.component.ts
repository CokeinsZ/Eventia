import { Component,Input,input } from '@angular/core';
import { OrgEventoComponent } from '../components/org-evento/org-evento.component';
import { OrgComunidadComponent } from '../components/org-comunidad/org-comunidad.component';
import { OrgIngresosComponent } from '../components/org-ingresos/org-ingresos.component';

@Component({
  selector: 'app-print-evento',
  imports: [OrgEventoComponent,OrgComunidadComponent,OrgIngresosComponent],
  templateUrl: './print-evento.component.html',
  styleUrl: './print-evento.component.css'
})
export class PrintEventoComponent {
  @Input() title='';
  @Input() agendas='';
  @Input() promedio: number = 0;
}
