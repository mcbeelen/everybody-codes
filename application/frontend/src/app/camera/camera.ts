export interface Camera {
  cameraNumber: String,
  description: String,
  latitude: number,
  longitude: number
}



export function buildCamera(cameraNumber: String, description: String, latitude: number, longitude: number) : Camera {
  return  {'cameraNumber': cameraNumber, 'description': description, 'latitude': latitude, 'longitude': longitude}
}
