import { Component, OnInit, Inject } from '@angular/core';
import { CameraService } from './camera/camera-service'

@Component({
  selector: 'camera-application',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(

      @Inject("CameraService") private cameraService: CameraService
      ) { }


  title = 'Camera Frontend Application';

  cameras = []

   ngOnInit() {
        let cameraObserver = this.cameraService.getCameras()
        cameraObserver.subscribe(data => this.cameras = data)
    }
}
