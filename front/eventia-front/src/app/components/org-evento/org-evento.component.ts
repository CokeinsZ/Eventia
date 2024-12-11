import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { VerifyStarsComponent } from '../verify-stars/verify-stars.component';
import { PrintEventoComponent } from '../../print-evento/print-evento.component';
import { EventoService } from '../../servicios/eventos/evento.service';

interface Evento {
  evt_id: number,
  evt_nombre: string,
  evt_descripcion: string,
  evt_precio: number,
  categorias: [{cat_nombre: string}],
  evt_organizador: number,
  organizador_nombre: string,
  promedioCalificaciones: number
}

@Component({
  selector: 'app-org-evento',
  imports: [PerfilOrganizadorComponent,VerifyStarsComponent,PrintEventoComponent, CommonModule],
  templateUrl: './org-evento.component.html',
  styleUrl: './org-evento.component.css'
})
export class OrgEventoComponent implements OnInit {

  idOrganizador: string = "3";
  eventos: Evento[] = [
    {
      evt_id: 1,
      evt_nombre: "",
      evt_descripcion: "",
      evt_precio: 1,
      categorias: [{cat_nombre: ""}],
      evt_organizador: 1,
      organizador_nombre: "",
      promedioCalificaciones: 1
    }
  ];

  numeroAgendas: string[] = [""];

  constructor(private eventosService: EventoService) { }

  ngOnInit(): void {
    this.eventosService.getEventosOrganizador(this.idOrganizador).subscribe(data => {
      this.eventos = data;
      this.eventos.forEach(evento => {
        this.eventosService.getAgendas(evento['evt_id'].toString()).subscribe(data => {
          this.numeroAgendas[evento['evt_id']] = data.length;

          console.log(this.numeroAgendas);
          console.log(this.eventos);
        });
      });
    });
  }
}
