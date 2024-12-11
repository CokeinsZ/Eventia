import { Component } from '@angular/core';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { ContValoresComponent } from './cont-valores/cont-valores.component';
import { PrintOrgIngresosArraysComponent } from './print-org-ingresos-arrays/print-org-ingresos-arrays.component';

@Component({
  selector: 'app-org-ingresos',
  imports: [PerfilOrganizadorComponent, ContValoresComponent,PrintOrgIngresosArraysComponent],
  templateUrl: './org-ingresos.component.html',
  styleUrl: './org-ingresos.component.css'
})
export class OrgIngresosComponent {
 title=[];
 ingresos=[];
}
