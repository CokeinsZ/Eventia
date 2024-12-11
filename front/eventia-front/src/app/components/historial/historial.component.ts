import { Component } from '@angular/core';
import { ValOptComponent } from './val-opt/val-opt.component';
import { InfoOptComponent } from './info-opt/info-opt.component';

@Component({
  selector: 'app-historial',
  imports: [ValOptComponent,InfoOptComponent],
  templateUrl: './historial.component.html',
  styleUrl: './historial.component.css'
})
export class HistorialComponent {
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
 
  descriptions: string[] = [
    "Evento donde expertos en tecnología presentan las últimas innovaciones.",
    "Celebración que reúne a músicos de diversos géneros para un evento único.",
    "Muestra de arte contemporáneo con obras de artistas locales e internacionales.",
    "Carrera de larga distancia que atrae a atletas de todo el mundo.",
    "Feria que reúne a emprendedores para exponer sus productos y servicios.",
    "Ciclo de películas proyectadas al aire libre en un ambiente relajado.",
    "Gran espectáculo de bandas de rock en vivo en un ambiente energético.",
    "Evento para los amantes de los autos clásicos con exhibiciones y competiciones.",
    "Competencia de videojuegos en la que participan jugadores de todas partes.",
    "Feria que ofrece una variedad de platos de diferentes culturas y países.",
    "Muestra de cine independiente con proyecciones de películas de bajo presupuesto.",
    "Charla educativa que explora las aplicaciones actuales de la inteligencia artificial.",
    "Evento para conectar a empresarios y crear oportunidades de colaboración.",
    "Evento de comedia en vivo con artistas locales y nacionales.",
    "Competencia de robótica con equipos de estudiantes y profesionales en el área.",
    "Exposición que presenta una selección de las mejores obras fotográficas.",
    "Seminario para aprender sobre las últimas estrategias en marketing digital.",
    "Feria que conecta a buscadores de empleo con empresas que ofrecen vacantes.",
    "Evento cultural donde se presentan danzas tradicionales de diversas regiones.",
    "Concurso donde los participantes capturan la belleza de la noche a través de la fotografía."
  ];
}
