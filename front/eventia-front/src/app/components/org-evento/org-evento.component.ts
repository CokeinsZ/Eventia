import { Component } from '@angular/core';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { VerifyStarsComponent } from '../verify-stars/verify-stars.component';

@Component({
  selector: 'app-org-evento',
  imports: [PerfilOrganizadorComponent,VerifyStarsComponent],
  templateUrl: './org-evento.component.html',
  styleUrl: './org-evento.component.css'
})
export class OrgEventoComponent {
 cont_val=0;
 cont_comentarios=0;
}
