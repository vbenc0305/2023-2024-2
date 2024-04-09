import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginComponent} from "./login/login.component";
import { RegisterComponent } from './register/register.component';
import {AppModule} from "../../app.module";
import {RouterLink} from "@angular/router";



@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
  ],
  imports: [
    CommonModule,
    RouterLink
  ]
})
export class UserPagesModule { }
