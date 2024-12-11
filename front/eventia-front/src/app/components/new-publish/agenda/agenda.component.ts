import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UbicacionService } from '../../../servicios/ubicaciones/ubicacion.service';

@Component({
  selector: 'app-agenda',
  imports: [CommonModule],
  templateUrl: './agenda.component.html',
  styleUrl: './agenda.component.css'
})
export class AgendaComponent implements OnInit {
  ubicaciones: [{ubc_id: number, ubc_nombre: string, ubc_ciudad: string, ubc_capacidad: number}] = [{ubc_id: 1, ubc_nombre: '', ubc_ciudad: '', ubc_capacidad: 1}];

  constructor(private ubicacionService: UbicacionService) { }

  ngOnInit(): void {
    this.ubicacionService.getUbicaciones().subscribe(data => {
      this.ubicaciones = data;
      console.log(this.ubicaciones);
    });

  }
}
