import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-normal-evt',
  templateUrl: './normal-evt.component.html',
  styleUrl: './normal-evt.component.css'
})
export class NormalEvtComponent {
  bannerPic = 'banner.jpg';

  @Input() evento: { evt_nombre: string, promedioCalificaciones: number } = { evt_nombre: '', promedioCalificaciones: 0 };
}
