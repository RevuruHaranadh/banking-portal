import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl = `${environment.apiUrl}/transactions`;

  constructor(private http: HttpClient) {}

  transfer(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/transfer`, data, { responseType: 'text' });
  }
}