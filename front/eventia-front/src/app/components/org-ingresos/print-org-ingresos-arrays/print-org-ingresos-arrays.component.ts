import { Component,Input,input } from '@angular/core';
import { OrgIngresosComponent } from '../org-ingresos.component';

@Component({
  selector: 'app-print-org-ingresos-arrays',
  imports: [OrgIngresosComponent],
  templateUrl: './print-org-ingresos-arrays.component.html',
  styleUrl: './print-org-ingresos-arrays.component.css'
})
export class PrintOrgIngresosArraysComponent {
  @Input() title='';
  @Input() ingresos='';
}
