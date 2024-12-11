import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { PrintOrgIngresosArraysComponent } from './print-org-ingresos-arrays/print-org-ingresos-arrays.component';
import { UsuarioService } from '../../servicios/usuarios/usuario.service';
import { EventoService } from '../../servicios/eventos/evento.service';
import { ReservaService } from '../../servicios/reservas/reserva.service';

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
  selector: 'app-org-ingresos',
  imports: [PerfilOrganizadorComponent, PrintOrgIngresosArraysComponent, CommonModule],
  templateUrl: './org-ingresos.component.html',
  styleUrl: './org-ingresos.component.css'
})

export class OrgIngresosComponent implements OnInit{
 title: string[]=[];
 ingresos: number[]=[];
 organizadorId: string = "3"

 constructor(private usuariosService: UsuarioService, private eventoService: EventoService, private reservaService: ReservaService) {}

  ngOnInit(): void {
    this.eventoService.getEventosOrganizador(this.organizadorId).subscribe((data: Evento[]) => {
      data.forEach((evento: Evento) => {
        this.title.push(evento.evt_nombre);
        
        this.reservaService.getIngresosEvento(evento.evt_id.toString()).subscribe((data: any) => {
          this.ingresos.push(data);

        });
      });
    });
  }
}
