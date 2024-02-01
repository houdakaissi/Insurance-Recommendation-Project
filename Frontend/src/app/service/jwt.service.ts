
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap,map } from 'rxjs/operators';
import { MyContratDetails } from '../model/contrat.model';
//import { MyContratDetails } from '../model/contrat.model';

//import * as jwt from 'jsonwebtoken';

const BASE_URL = ["http://192.168.49.2:30682/"] 
@Injectable({
  providedIn: 'root'
})
export class JwtService {

  constructor(private http: HttpClient) { }
  register(signRequest: any): Observable<any> {
    return this.http.post(BASE_URL + 'auth/signup', signRequest)
  }

  c(complete: any): Observable<any> {
    return this.http.post(BASE_URL + 'auth/signupp', complete)
  }
  login(loginRequest: any): Observable<any> {
    return this.http.post(BASE_URL + 'auth/signin', loginRequest)
  }
  

 
  public getContrats():Observable<MyContratDetails[]> {
    return this.http.get<MyContratDetails[]>("http://192.168.49.2:30682/contrats/listContrac")
  }
 





  
  hello(): Observable<any> {
    const jwtToken = localStorage.getItem('Token')
    
    let headers = {};

    if (jwtToken) {
      console.log("JWT token found in local storage", jwtToken)
      
      headers = {
        //"Authorization": "Bearer " + jwtToken
        "Authorization": "Bearer " + jwtToken
      };
      console.log("Headers:", headers);
     // const decodedToken = jwt.verify(jwtToken, 'your-secret-key');
      //console.log('Decoded Token:', decodedToken);

    } else {
      console.log("JWT token not found in local storage")
    }

    return this.http.get(BASE_URL + 'test/hello', { headers })
  }

public get11():Observable<MyContratDetails[]>{
  return this.http.get<MyContratDetails[]>("http://192.168.49.2:30682/contrats/listContracts")
}

public get(age: number, meliage: number):Observable<MyContratDetails[]>{
  const url = `http://192.168.49.2:30682/user_car_predict/${age}/${meliage}`;
  return this.http.get<MyContratDetails[]>(url);
  }
}








