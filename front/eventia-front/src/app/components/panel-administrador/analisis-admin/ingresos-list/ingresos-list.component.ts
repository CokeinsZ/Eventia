import { Component } from '@angular/core';
import { AnalisisAdminComponent } from "../analisis-admin.component";
import { PrintIngresosListComponent } from './print-ingresos-list/print-ingresos-list.component';

@Component({
  selector: 'app-ingresos-list',
  imports: [AnalisisAdminComponent,PrintIngresosListComponent],
  templateUrl: './ingresos-list.component.html',
  styleUrl: './ingresos-list.component.css'
})
export class IngresosListComponent {


date=['hoy'];
ingreso=[3000];
users=['persona3'];

ingresos_totales=this.ingreso.reduce((acumulador: number, valorActual: number) => acumulador + valorActual, 0);

}
