import { Component, OnInit } from '@angular/core';
import { EventoService } from '../../servicios/eventos/evento.service';
import { CommonModule } from '@angular/common';
import { TablaDisponibilidadComponent } from './tabla-disponibilidad/tabla-disponibilidad.component';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-detalle-evento',
  imports: [TablaDisponibilidadComponent, CommonModule],
  templateUrl: './detalle-evento.component.html',
  styleUrl: './detalle-evento.component.css'
})
export class DetalleEventoComponent implements OnInit {
  constructor(private route: ActivatedRoute, private eventoService: EventoService) {}

  eventId: string | null = "";
  evento: { 
    evt_id: number, 
    evt_organizador: number, 
    organizador_nombre: string,
    evt_nombre: string, 
    evt_descripcion: string, 
    evt_precio: number, 
    categorias: any[], 
    promedioCalificaciones: number 
  } = { 
    evt_id: 0, 
    evt_organizador: 0, 
    organizador_nombre: '',
    evt_nombre: '', 
    evt_descripcion: '', 
    evt_precio: 0, 
    categorias: [], 
    promedioCalificaciones: 0 
  };

  ngOnInit() {
    this.eventId = this.route.snapshot.paramMap.get('id');
    console.log(this.eventId);

    if (this.eventId) {
      this.eventoService.getEvento(this.eventId).subscribe(data => {
      this.evento = data;
      console.log(this.evento);
      });
    };

  };
  
}
