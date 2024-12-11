import { Component } from '@angular/core';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { ContValoracionesComponent } from './cont-valoraciones/cont-valoraciones.component';
import { PrintUserEvtOrgComponent } from './print-user-evt-org/print-user-evt-org.component';


@Component({
  selector: 'app-org-comunidad',
  imports: [PerfilOrganizadorComponent,ContValoracionesComponent,PrintUserEvtOrgComponent],
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

  comentarios: string[] = [
    "La organización fue excelente, todo salió según lo planeado.",
    "Me encantó el ambiente, muy bien decorado y acogedor.",
    "El sonido estuvo increíble, se escuchaba todo claramente.",
    "Los ponentes fueron muy interesantes y aportaron mucho valor.",
    "La comida estuvo deliciosa, sobre todo los postres.",
    "Creo que el evento duró demasiado, podrían hacerlo más corto.",
    "Había mucha gente y faltaron sillas para todos.",
    "Los horarios fueron puntuales, algo que valoro mucho.",
    "El lugar era complicado de encontrar, deberían mejorar la señalización.",
    "El networking fue muy productivo, conocí a personas interesantes.",
    "La iluminación estaba perfecta, ayudó a crear un buen ambiente.",
    "El precio de la entrada fue justo para la calidad del evento.",
    "Las actividades interactivas estuvieron muy bien organizadas.",
    "Me habría gustado que hubiera más tiempo para preguntas y respuestas.",
    "El estacionamiento fue un problema, no había suficiente espacio.",
    "Los voluntarios fueron muy amables y serviciales.",
    "Hubo problemas técnicos al principio, pero los resolvieron rápido.",
    "La música en vivo fue un excelente toque, lo disfruté mucho.",
    "El acceso para personas con discapacidad fue limitado, deberían mejorarlo.",
    "¡Fue un evento memorable! Definitivamente asistiré a la próxima edición."
  ];
  

  
  
}
