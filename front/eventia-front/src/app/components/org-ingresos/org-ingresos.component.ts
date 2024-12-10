import { Component } from '@angular/core';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { ContValoresComponent } from './cont-valores/cont-valores.component';
import { ContValoracionesComponent } from "../org-comunidad/cont-valoraciones/cont-valoraciones.component";

@Component({
  selector: 'app-org-ingresos',
  imports: [PerfilOrganizadorComponent, ContValoresComponent],
  templateUrl: './org-ingresos.component.html',
  styleUrl: './org-ingresos.component.css'
})
export class OrgIngresosComponent {

}
