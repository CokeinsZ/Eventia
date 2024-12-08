import { Component } from '@angular/core';
import { MainEvtComponent } from './main-evt/main-evt.component';
import { NormalEvtComponent } from './normal-evt/normal-evt.component';
@Component({
  selector: 'app-home',
  imports: [MainEvtComponent,NormalEvtComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
