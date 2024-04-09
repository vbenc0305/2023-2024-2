import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './pages/main/main.component';
import { TurainkComponent } from './pages/turaink/turaink.component';
import { GyikComponent } from './pages/gyik/gyik.component';
import { MenuSavComponent } from './shared/menu-sav/menu-sav.component';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { getAuth, provideAuth } from '@angular/fire/auth';
import { getFirestore, provideFirestore } from '@angular/fire/firestore';
import { getStorage, provideStorage } from '@angular/fire/storage';
import {enviroment} from "../enviroment/enviroment.prod";
import {AngularFireModule} from "@angular/fire/compat";
import { UserPagesModule } from './pages/user-pages/user-pages.module';
import { LoginComponent } from './pages/user-pages/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    TurainkComponent,
    GyikComponent,
    MenuSavComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFireModule,
    //provideFirebaseApp(() => initializeApp(enviroment.firebase)),
    provideAuth(() => getAuth()),
    provideFirestore(() => getFirestore()),
    provideStorage(() => getStorage()),
    UserPagesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
