import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private url = 'http://localhost:8080/usuarios';

  constructor(private http: HttpClient) { }

  getCalificacionesOrganizador(id: string): Observable<any> {
    return this.http.get(`${this.url}/${id}/calificaciones/organizador`);
  }

  getUsuario(id: string): Observable<any> {
    return this.http.get(`${this.url}/${id}`);
  }

}
