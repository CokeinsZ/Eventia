import { Component, Input } from '@angular/core';
import { HomeComponent } from '../home.component';

@Component({
  selector: 'app-normal-evt',
  imports: [HomeComponent],
  templateUrl: './normal-evt.component.html',
  styleUrl: './normal-evt.component.css'
})
export class NormalEvtComponent {
  bannerPic='banner.jpg';
  @Input() title = "";
}
