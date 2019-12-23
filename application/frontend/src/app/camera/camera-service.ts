import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { Camera } from './camera'
import { CameraBackend } from '../camera-backend';
import {Observable, of} from "rxjs";

export interface CameraService {
  getCameras() : Observable<Camera[]>
}


@Injectable()
export class CameraServiceImpl implements CameraService {

  constructor(private httpClient: HttpClient, private cameraBackend : CameraBackend) {
    }

   getCameras() : Observable<Camera[]>{
          return this.httpClient.get<Camera[]>(this.cameraBackend.URL + "api/cameras");
      }

}
