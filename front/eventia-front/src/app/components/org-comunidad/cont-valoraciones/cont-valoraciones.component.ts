import { Component } from '@angular/core';
import { VerifyStarsComponent } from '../../verify-stars/verify-stars.component';

@Component({
  selector: 'app-cont-valoraciones',
  imports: [VerifyStarsComponent],
  templateUrl: './cont-valoraciones.component.html',
  styleUrl: './cont-valoraciones.component.css'
})
export class ContValoracionesComponent {
nom_usuario='nombre de usuario';
banner_img='banner.jpg'
nom_evt='nombre del evento';
comentario='hola como estan espero que esten muy bien, aqui estoy colocando un texto ridiculamente largo';
}
