import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {
  private url = 'http://localhost:8080/reserva';

  constructor(private http: HttpClient) { }

  getIngresosEvento(id: string): Observable<any> {
    return this.http.get(`${this.url}/evento/${id}/ingresos`);
  }

  showReservas(id: string): Observable<any> {
    return this.http.request('GET', `${this.url}/usuario`, {
      body: { idUsuario: id },
    });
  }
  

}
