import { Component } from '@angular/core';
import { GestionAdminComponent } from "../../gestion-admin.component";
import { NewPublishComponent } from "../../../../new-publish/new-publish.component";

@Component({
  selector: 'app-update-publish',
  imports: [GestionAdminComponent, NewPublishComponent],
  templateUrl: './update-publish.component.html',
  styleUrl: './update-publish.component.css'
})
export class UpdatePublishComponent {

}
