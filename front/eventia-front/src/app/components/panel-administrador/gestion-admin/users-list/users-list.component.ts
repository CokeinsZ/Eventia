import { Component } from '@angular/core';
import { GestionAdminComponent } from "../gestion-admin.component";

@Component({
  selector: 'app-users-list',
  imports: [GestionAdminComponent],
  templateUrl: './users-list.component.html',
  styleUrl: './users-list.component.css'
})
export class UsersListComponent {
  profile_pic='profile pic.png';
}
