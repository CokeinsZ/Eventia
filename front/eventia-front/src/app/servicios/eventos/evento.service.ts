import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventoService {
  private url = 'http://localhost:8080/eventos';

  constructor(private http: HttpClient) { }

  getEventos(page: number): Observable<any> {
    let params = new HttpParams().set('pagina', page.toString());
    return this.http.get(`${this.url}/pagina`, { params });
  }

  getEvento(id: string): Observable<any> {
    return this.http.get(`${this.url}/${id}`);
  }

  getEventosOrganizador(id: string): Observable<any> {
    return this.http.get(`${this.url}/organizador/${id}`);
  }

  getAgendas(idEvento: string): Observable<any> {
    return this.http.get(`${this.url}/${idEvento}/agendas`);
  }

  getCategorias(): Observable<any> {
    return this.http.get(`${this.url}/categorias`);
  }
}
