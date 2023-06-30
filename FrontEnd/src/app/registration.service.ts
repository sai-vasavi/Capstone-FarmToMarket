import { Injectable } from '@angular/core';
import { User } from './user';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http : HttpClient) { }

  public loginUserFromRemote(user:User):Observable<any>{
    return this._http.post<any>("http://localhost:8080/login",user)

  }
  public registrationUserFromRemote(user:User):Observable<any>{
    return this._http.post<any>("http://localhost:8080/registrationFormUser",user)

  }
  public getUserData(id:number):Observable<User>{
    return this._http.get<User>(`http://localhost:8080/user/${id}`)

  }
}
