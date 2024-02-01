// Create a service (e.g., data.service.ts)
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { MyContratDetails } from '../model/contrat.model';

@Injectable({
  providedIn: 'root',
})
export class dataService {
  



 // Déclarez votre source BehaviorSubject avec un type d'objet ou de tableau
 private usernameSource = new BehaviorSubject<{
  response1: string;
  response2: string;
  response3: string;
  response4: string;
  response5: string;
}>({
  response1: '',
  response2: '',
  response3: '',
  response4: '',
  response5: '',
});
 // Exposez votre Observable
 username$ = this.usernameSource.asObservable();

 // Méthode pour changer la réponse
 changeResponse(response1: string, response2: string,response3:string,response4:string,response5:string) {
   // Émettez un objet contenant les deux réponses
   this.usernameSource.next({ response1, response2 ,response3,response4,response5});
 }
 have(response1:string){
  return response1;
 }

 private dataSubject = new BehaviorSubject<string>('');

  sendData(data: string) {
    this.dataSubject.next(data);
  }

  getData() {
    return this.dataSubject.asObservable();
  }



}
