import { Component } from '@angular/core';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { ContValoracionesComponent } from './cont-valoraciones/cont-valoraciones.component';
import { PrintUsersComponent } from '../../print-users/print-users.component';
import { PrintEventoComponent } from '../../print-evento/print-evento.component';

@Component({
  selector: 'app-org-comunidad',
  imports: [PerfilOrganizadorComponent,ContValoracionesComponent,PrintUsersComponent,PrintEventoComponent],
  templateUrl: './org-comunidad.component.html',
  styleUrl: './org-comunidad.component.css'
})
export class OrgComunidadComponent {
  users: string[] = [
    "juanperez", "mariagonzalez", "pedrolopez", "anafernandez", "carlossuarez",
    "luciaortiz", "miguelluna", "sofiaperez", "danielramirez", "josealvarez",
    "lauragonzalez", "ricardomartinez", "cristinasanchez", "javiergarcia", "elisaperez",
    "victoriacastro", "arturosoto", "paulavazquez", "juanamorales", "susanamartin"
  ];

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

  
  
}
