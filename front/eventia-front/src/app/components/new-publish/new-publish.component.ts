import { Component, OnInit } from '@angular/core';
import { AgendaComponent } from './agenda/agenda.component';
import { EventoService } from '../../servicios/eventos/evento.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-new-publish',
  imports: [AgendaComponent, CommonModule],
  templateUrl: './new-publish.component.html',
  styleUrl: './new-publish.component.css'
})
export class NewPublishComponent implements OnInit {
  banner='banner.jpg';
  categorias: [{cat_nombre: string}] = [{cat_nombre: ''}];

  constructor (private eventoService: EventoService) { }

  ngOnInit(): void {
    this.eventoService.getCategorias().subscribe(data => {
      this.categorias = data;
      console.log(this.categorias);
    });
  }

}
