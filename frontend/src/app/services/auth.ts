import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { environment } from '../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = `${environment.apiUrl}/auth`;

  constructor(private http: HttpClient) {}

  register(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, data, { responseType: 'text' });
  }

  login(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, data).pipe(
      tap((res: any) => {
        localStorage.setItem('token', res.token);
        localStorage.setItem('role', res.role);
      })
    );
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  logout(): void {
    localStorage.clear();
  }
}