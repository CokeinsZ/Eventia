import { Component,Input,input } from '@angular/core';
import { OrgEventoComponent } from '../../org-evento/org-evento.component';
import { OrgComunidadComponent } from '../org-comunidad.component';

@Component({
  selector: 'app-print-user-evt-org',
  imports: [OrgComunidadComponent],
  templateUrl: './print-user-evt-org.component.html',
  styleUrl: './print-user-evt-org.component.css'
})
export class PrintUserEvtOrgComponent {
  @Input() title='';
  @Input() users='';
  @Input() comentarios='';
  @Input() estrellas='';
}
