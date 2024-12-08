import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { CommonModule } from '@angular/common';
import { DetalleEventoComponent } from './components/detalle-evento/detalle-evento.component';


@Component({
  selector: 'app-root',
  imports: [CommonModule,HeaderComponent,RouterOutlet,DetalleEventoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'eventia-front';
}
