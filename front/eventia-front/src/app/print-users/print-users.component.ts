import { Component, Input } from '@angular/core';
import { OrgComunidadComponent } from '../components/org-comunidad/org-comunidad.component';

@Component({
  selector: 'app-print-users',
  imports: [OrgComunidadComponent],
  templateUrl: './print-users.component.html',
  styleUrl: './print-users.component.css'
})
export class PrintUsersComponent {
 @Input() users="";
}
