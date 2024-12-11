import { Component, OnInit } from '@angular/core';
import { EventoService } from '../../servicios/eventos/evento.service';
import { MainEvtComponent } from './main-evt/main-evt.component';
import { NormalEvtComponent } from './normal-evt/normal-evt.component';

@Component({
  selector: 'app-home',
  imports: [MainEvtComponent, NormalEvtComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  eventos = [];

  title = ["El mejor titulo de la historia", "El segundo mejor titulo de la historia","El tercer mejor titulo de la historia", "4", "5", "6", "7", "8", "9", "10"];

  constructor(private eventoService: EventoService) { }

  ngOnInit(): void {
    this.eventoService.getEventos(1).subscribe(data => {
      this.eventos = data;
    });

    console.log(this.eventos);
  }
}
