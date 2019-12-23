import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Camera } from '../camera'

@Component({
  selector: 'camera-overview',
  templateUrl: './camera-overview.component.html'
})
export class CameraOverviewComponent implements OnChanges {

  camerasInFirstColumn : Camera[] = [];
  camerasInSecondColumn : Camera[] = [];
  camerasInThirdColumn : Camera[] = [];
  camerasInFourthColumn : Camera[] = [];

  @Input('cameras') cameras: Camera[];



  ngOnChanges(changes: SimpleChanges) {
      let cameras = changes.cameras.currentValue
      for (let camera of cameras) {
          let columnNumber = this.determineColumnNumber(camera.cameraNumber)
          switch (columnNumber) {
            case FIRST : this.camerasInFirstColumn.push(camera);
                break;
            case SECOND : this.camerasInSecondColumn.push(camera);
                break;
            case THIRD : this.camerasInThirdColumn.push(camera);
                break;
            case OTHER : this.camerasInFourthColumn.push(camera);
                break;

          }
      }
  }

  determineColumnNumber(cameraNumber) : String {
    if (cameraNumber % 3 == 0 && cameraNumber % 5 == 0) return THIRD
    if (cameraNumber % 3 == 0 ) return FIRST
    if (cameraNumber % 5 == 0 ) return SECOND
    return OTHER
  }

}

const FIRST = "Fizz"
const SECOND = "Buzz"
const THIRD = "FizzBuzz"
const OTHER = "OTHER"
