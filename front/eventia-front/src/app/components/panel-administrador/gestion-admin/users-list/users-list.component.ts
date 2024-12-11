import { Component } from '@angular/core';
import { GestionAdminComponent } from "../gestion-admin.component";
import { PrintUserListComponent } from './print-user-list/print-user-list.component';

@Component({
  selector: 'app-users-list',
  imports: [GestionAdminComponent,PrintUserListComponent],
  templateUrl: './users-list.component.html',
  styleUrl: './users-list.component.css'
})
export class UsersListComponent {
  profile_pic='profile pic.png';
  users=['juanito'];
  date_Inicio=['hoy'];
}
