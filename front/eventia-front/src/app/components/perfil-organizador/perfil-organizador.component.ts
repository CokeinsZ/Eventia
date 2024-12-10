import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil-organizador',
  imports: [],
  templateUrl: './perfil-organizador.component.html',
  styleUrl: './perfil-organizador.component.css'
})
export class PerfilOrganizadorComponent {
  rutaActual: string = '';

  constructor(private router: Router) {}

  ngOnInit(): void {
    // Guardar la ruta actual
    this.rutaActual = this.router.url;
  }
}
