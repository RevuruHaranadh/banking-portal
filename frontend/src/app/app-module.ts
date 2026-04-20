import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing-module';
import { AppComponent } from './app';
import { LoginComponent } from './pages/login/login';
import { RegisterComponent } from './pages/register/register';
import { DashboardComponent } from './pages/dashboard/dashboard';
import { TransferComponent } from './pages/transfer/transfer';
import { AuthInterceptor } from './interceptors/auth-interceptor';

@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    TransferComponent
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}