import { Component, Input } from '@angular/core';
import { UsersListComponent } from '../users-list.component';

@Component({
  selector: 'app-print-user-list',
  imports: [UsersListComponent],
  templateUrl: './print-user-list.component.html',
  styleUrl: './print-user-list.component.css'
})
export class PrintUserListComponent {
@Input() users='';
@Input() date='';
}
