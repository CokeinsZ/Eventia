import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PerfilOrganizadorComponent } from '../perfil-organizador/perfil-organizador.component';
import { ContValoracionesComponent } from './cont-valoraciones/cont-valoraciones.component';
import { PrintUserEvtOrgComponent } from './print-user-evt-org/print-user-evt-org.component';
import { UsuarioService } from '../../servicios/usuarios/usuario.service';
import { EventoService } from '../../servicios/eventos/evento.service';

interface Usuario {
  usr_id: number,
  usr_correo: string,
  usr_contrasena: string,
  usr_saldo: number,
  usr_nombre1: string,
  usr_nombre2: string,
  usr_apellido1: string,
  usr_apellido2: string,
  usr_telefono: string,
  usr_cedula: string,
  usr_rol: number,
  rol_nombre: string,
  usr_estado: string
}

interface Evento {
  evt_id: number,
  evt_nombre: string,
  evt_descripcion: string,
  evt_precio: number,
  categoriaa: [{cat_nombre: string}],
  evt_organizador: number,
  organizador_nombre: string,

}

interface Calificacion {
  cal_num_estrellas: number,
  cal_puntuacion: number,
  cal_comentario: string,
  cal_usuario: number,
  cal_evento: number
}

@Component({
  selector: 'app-org-comunidad',
  imports: [PerfilOrganizadorComponent,ContValoracionesComponent,PrintUserEvtOrgComponent, CommonModule],
  templateUrl: './org-comunidad.component.html',
  styleUrl: './org-comunidad.component.css'
})

export class OrgComunidadComponent implements OnInit {

  calificaciones = [];
  idOrganizador: string = '3'; // NO OLVIDAR CAMBIAR EL ID DEL ORGANIZADOR

  users: string[] = [""];
  title: string[] = [""];
  comentarios: string[] = [""];
  estrellas: string[] = [""]; 
  
  constructor(private usuarioService: UsuarioService, private eventoService: EventoService) { }
  
  ngOnInit(): void {
    this.usuarioService.getCalificacionesOrganizador(this.idOrganizador).subscribe(data => { // NO OLVIDAR CAMBIAR EL ID DEL ORGANIZADOR
      this.calificaciones = data;
      console.log(this.calificaciones);

      this.calificaciones.forEach(calificacion => {
        this.usuarioService.getUsuario(calificacion['cal_usuario']).subscribe(data => {
          let usuario: Usuario = data;
          console.log(usuario);
          this.users.push(usuario['usr_nombre1'] + usuario['usr_apellido1']);
        });
  
        this.eventoService.getEvento(calificacion['cal_evento']).subscribe(data => {
          let evento: Evento = data;
          console.log(evento);
          this.title.push(evento['evt_nombre']);
        });
  
        this.comentarios.push(calificacion['cal_comentario']);
        this.estrellas.push(calificacion['cal_num_estrellas']);
      });
    });

  }
  
}
