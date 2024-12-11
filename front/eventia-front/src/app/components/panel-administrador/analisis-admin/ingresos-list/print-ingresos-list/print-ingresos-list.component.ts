import { Component, Input } from '@angular/core';
import { IngresosListComponent } from '../ingresos-list.component';

@Component({
  selector: 'app-print-ingresos-list',
  imports: [IngresosListComponent],
  templateUrl: './print-ingresos-list.component.html',
  styleUrl: './print-ingresos-list.component.css'
})
export class PrintIngresosListComponent {
@Input() date='';
@Input() ingreso='';
@Input() users='';
}
