import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainComponent} from "./pages/main/main.component";
import {GyikComponent} from "./pages/gyik/gyik.component";
import {TurainkComponent} from "./pages/turaink/turaink.component";
import {UserPagesModule} from "./pages/user-pages/user-pages.module";
import {LoginComponent} from "./pages/user-pages/login/login.component";
import {RegisterComponent} from "./pages/user-pages/register/register.component";

const routes: Routes = [
  { path: 'main', component: MainComponent},
  { path: 'gyik', component: GyikComponent},
  { path: 'turaink', component:TurainkComponent},
  {path: 'login', component: LoginComponent},
  {path: 'regi', component: RegisterComponent}
  //TODO: További path-ek beállítása
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
