import { Component, Input, AfterViewInit, ViewChild, ElementRef, OnChanges, SimpleChanges  } from '@angular/core';
import { Camera } from '../camera'

@Component({
  selector: 'camera-map',
  templateUrl: './camera-map.component.html',
    styleUrls: ['./camera-map.component.css']
})
export class CameraMapComponent implements OnChanges {

  @Input('cameras') cameras: Camera[];

  @ViewChild('mapContainer', {static: false}) gmap: ElementRef;

  map: google.maps.Map;
  mapOptions: google.maps.MapOptions;


     mapInitializer() {
      this.map = new google.maps.Map(this.gmap.nativeElement, this.mapOptions);
     }


  ngOnChanges(changes: SimpleChanges) {
      let cameras = changes.cameras.currentValue;

      let lat = 52.093599;
      let lng = 5.118325;
      let centerCoordinate =  new google.maps.LatLng(lat, lng);

      this.mapOptions = {
          center: centerCoordinate,
          zoom: 14
      }

      this.mapInitializer();


      for (let camera of cameras) {
          let cameraCoordinate =  new google.maps.LatLng(camera.latitude, camera.longitude);
          let cameraMarker = new google.maps.Marker({
            position: cameraCoordinate,
            map: this.map,
          });
      }
  }
}
