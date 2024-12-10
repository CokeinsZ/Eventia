import { Component } from '@angular/core';
import { AnalisisAdminComponent } from "../analisis-admin.component";

@Component({
  selector: 'app-ingresos-list',
  imports: [AnalisisAdminComponent],
  templateUrl: './ingresos-list.component.html',
  styleUrl: './ingresos-list.component.css'
})
export class IngresosListComponent {
ingresos_totales=3.33;
}
