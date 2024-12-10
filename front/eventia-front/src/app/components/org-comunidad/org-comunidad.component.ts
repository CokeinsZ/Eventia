import { Component } from '@angular/core';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { ContValoracionesComponent } from './cont-valoraciones/cont-valoraciones.component';

@Component({
  selector: 'app-org-comunidad',
  imports: [PerfilOrganizadorComponent,ContValoracionesComponent],
  templateUrl: './org-comunidad.component.html',
  styleUrl: './org-comunidad.component.css'
})
export class OrgComunidadComponent {

}
