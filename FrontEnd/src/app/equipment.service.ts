import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Equipment } from './equipment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {

  private baseURL = "http://localhost:8080";

  constructor(private _http : HttpClient) { }

  public AddEquipmentFromRemote(equipment:Equipment):Observable<Equipment>{
    return this._http.post<Equipment>("http://localhost:8080/equipment",equipment)

  }
  public AllEquipmentFromRemote():Observable<Equipment[]>{
    return this._http.get<Equipment[]>("http://localhost:8080/allequipments")

  }

  getEquipmentById(equipmentId: any): Observable<Equipment>{
    return this._http.get<Equipment>(`${this.baseURL}/equipment/${equipmentId}`);
  }
  updateEquipmentById(id: any,equipment:Equipment): Observable<Object>{
    return this._http.put(`${this.baseURL}/equipment/${id}`,equipment);
  }
  deleteEquipment(id: number): Observable<Object>{
    return this._http.delete(`${this.baseURL}/equipment/${id}`);
  }
}
