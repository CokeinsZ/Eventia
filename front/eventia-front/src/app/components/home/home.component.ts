import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventoService } from '../../servicios/eventos/evento.service';
import { MainEvtComponent } from './main-evt/main-evt.component';
import { NormalEvtComponent } from './normal-evt/normal-evt.component';

@Component({
  selector: 'app-home',
  imports: [MainEvtComponent, NormalEvtComponent, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  constructor(private eventoService: EventoService) { }

  eventos = [];

  ngOnInit(): void {
    this.eventoService.getEventos(1).subscribe(data => {
      this.eventos = data;
      console.log(this.eventos);
    });

  }

}
