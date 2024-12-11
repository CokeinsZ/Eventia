import { Component,Input,input } from '@angular/core';
import { EventListComponent } from '../event-list.component';

@Component({
  selector: 'app-print-arrays-event-admin',
  imports: [EventListComponent],
  templateUrl: './print-arrays-event-admin.component.html',
  styleUrl: './print-arrays-event-admin.component.css'
})
export class PrintArraysEventAdminComponent {
  @Input() title='';
  @Input() description='';
  @Input() date='';
  @Input() place='';
  @Input() aforo='';
}
