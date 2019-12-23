import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { FlexLayoutModule } from '@angular/flex-layout';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CameraListComponent } from './camera/list/camera-list.component';
import { CameraOverviewComponent } from './camera/overview/camera-overview.component';
import { CameraServiceImpl } from './camera/camera-service';
import { CameraBackend } from './camera-backend';
import { CameraApplicationMaterialModule } from './camera-app-material'

@NgModule({
  declarations: [
    AppComponent,
    CameraOverviewComponent,
    CameraListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CameraApplicationMaterialModule,
    FlexLayoutModule
  ],
   providers: [
          CameraBackend,
          {provide: 'CameraService', useClass: CameraServiceImpl},
          ],
  bootstrap: [AppComponent]
})
export class AppModule { }
