import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UbicacionService {
  private url = 'http://localhost:8080/ubicaciones';

  constructor(private http: HttpClient) { }

  getUbicaciones(): Observable<any> {
    return this.http.get(`${this.url}/`);
  }

}
