import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventoService } from '../../../servicios/eventos/evento.service';

@Component({
  selector: 'app-tabla-disponibilidad',
  imports: [CommonModule],
  templateUrl: './tabla-disponibilidad.component.html',
  styleUrl: './tabla-disponibilidad.component.css'
})
export class TablaDisponibilidadComponent implements OnInit {
  @Input() idEvento = "0";
  agenda: {
    agd_id: number,
    ubc_id: number,
    ubc_nombre: string,
    ubc_ciudad: string,
    evt_id: number,
    agd_fecha_inicio: string,
    agd_estado: string,
    agd_fecha_fin: string,
    entradas_disponibles: number
    
  } = {
    agd_id: 1,
    ubc_id: 1,
    ubc_nombre: 'Location 1',
    ubc_ciudad: 'City 1',
    evt_id: 1,
    agd_fecha_inicio: '2023-01-01 10:00:00',
    agd_estado: 'activo',
    agd_fecha_fin: '2023-01-01 12:00:00',
    entradas_disponibles: 1
  };
  agendas: [{
    agd_id: number,
    ubc_id: number,
    ubc_nombre: string,
    ubc_ciudad: string,
    evt_id: number,
    agd_fecha_inicio: string,
    agd_estado: string,
    agd_fecha_fin: string
    entradas_disponibles: number
  }] = [{
    agd_id: 1,
    ubc_id: 1,
    ubc_nombre: 'Location 1',
    ubc_ciudad: 'City 1',
    evt_id: 1,
    agd_fecha_inicio: '2023-01-01 10:00:00',
    agd_estado: 'activo',
    agd_fecha_fin: '2023-01-01 12:00:00',
    entradas_disponibles: 1
  }];

  constructor(private eventoService: EventoService) { }

  ngOnInit() {
    this.eventoService.getAgendas(this.idEvento).subscribe(data => {
      this.agendas = data;
      console.log(this.agendas);
    });
  }

}
