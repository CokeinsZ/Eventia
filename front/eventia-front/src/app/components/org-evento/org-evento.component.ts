import { Component } from '@angular/core';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { VerifyStarsComponent } from '../verify-stars/verify-stars.component';
import { PrintEventoComponent } from '../../print-evento/print-evento.component';

@Component({
  selector: 'app-org-evento',
  imports: [PerfilOrganizadorComponent,VerifyStarsComponent,PrintEventoComponent],
  templateUrl: './org-evento.component.html',
  styleUrl: './org-evento.component.css'
})
export class OrgEventoComponent {
 cont_val=0;
 cont_comentarios=0;
 title: string[] = [
  "Conferencia de Tecnología",
  "Festival de Música",
  "Exposición de Arte Contemporáneo",
  "Maratón Internacional",
  "Feria de Emprendedores",
  "Cine al Aire Libre",
  "Concierto de Rock",
  "Exhibición de Autos Clásicos",
  "Torneo de Videojuegos",
  "Feria de Comida Internacional",
  "Festival de Cine Independiente",
  "Charla sobre Inteligencia Artificial",
  "Evento de Networking Empresarial",
  "Festival de Comedia",
  "Competencia de Robótica",
  "Exposición de Fotografía",
  "Seminario de Marketing Digital",
  "Feria de Empleo",
  "Festival de Danza Folclórica",
  "Concurso de Fotografía Nocturna"
];
dates: string[] = [
  "2024-12-10", "2024-12-11", "2024-12-12", "2024-12-13", "2024-12-14",
  "2024-12-15", "2024-12-16", "2024-12-17", "2024-12-18", "2024-12-19",
  "2024-12-20", "2024-12-21", "2024-12-22", "2024-12-23", "2024-12-24",
  "2024-12-25", "2024-12-26", "2024-12-27", "2024-12-28", "2024-12-29"
];

numbers: number[] = [
  34, 87, 21, 56, 99, 14, 72, 48, 63, 8,
  90, 26, 77, 59, 41, 53, 11, 67, 30, 82
];


}
