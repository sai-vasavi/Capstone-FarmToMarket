import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Items } from './items';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemsServiceService {

  private baseURL = "http://localhost:8080";



  constructor(private _http : HttpClient) { }

  public AddItemsFromRemote(items:Items,emailId:string):Observable<any>{
    console.log(JSON.stringify(items)+"ITEMS")
    return this._http.post<Items>("http://localhost:8080/data",items,{params:new HttpParams().set('emailId',emailId)});
  }

  public AllItemsFromRemote():Observable<Items[]>{
    return this._http.get<Items[]>("http://localhost:8080/getItems")

  }
  getItemById(id: any): Observable<Items>{
    return this._http.get<Items>(`http://localhost:8080/getItems/${id}`);
  }
  updateItemById(id: any,items:Items): Observable<Object>{
    return this._http.put(`${this.baseURL}/updateItem/${id}`,items);
  }
  deleteItem(id: number): Observable<Object>{
    return this._http.delete(`${this.baseURL}/item/${id}`);
  }
}

