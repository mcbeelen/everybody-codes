import { Component, Input } from '@angular/core';
import { Camera } from '../camera'

@Component({
  selector: 'camera-list',
  templateUrl: './camera-list.component.html',
  styleUrls: ['./camera-list.component.css']
})
export class CameraListComponent {

  @Input('cameras') cameras: Camera[];



}
