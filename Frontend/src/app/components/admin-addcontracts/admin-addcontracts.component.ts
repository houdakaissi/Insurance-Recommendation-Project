


import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginComponent } from '../login/login.component';
import { dataService } from 'src/app/service/dataService';
import { MyContratDetails } from 'src/app/model/contrat.model';
@Component({
  selector: 'app-admin-addcontracts',
  templateUrl: './admin-addcontracts.component.html',
  styleUrls: ['./admin-addcontracts.component.css']
})
export class AdminAddcontractsComponent {
  // AdminAddcontractsComponent
  
  ngOnInit(): void {
    this.dataservice.username$.subscribe(({response1,response2,response3,response4,response5}) => {
       this.seller.username = response1;
       this.seller.prenom = response2;
       this.seller.tel = response3;
       this.seller.CIN = response4;
       this.seller.nom= response5;
     
        
     });
      
     
  
}


showCarDetails = false;

onHasCarChange(event: Event) {
  const value = (event.target as HTMLInputElement)?.value;
  this.showCarDetails = value === 'yes';
}

showStageDetails = false;

onHasStageChange(event: Event) {
  const value = (event.target as HTMLInputElement)?.value;
  this.showStageDetails = value === 'yes';
}

showTravelDetails = false;

onHasTravelChange(event: Event) {
  const value = (event.target as HTMLInputElement)?.value;
  this.showTravelDetails = value === 'yes';
}




  seller: {
    nom: string,
    prenom: string,
    username: string,
    password: string,
    CIN: string,
    tel: string,
  } = {
    nom: '',
    prenom: '',
    username: '',
    password: '',
    CIN: '',
    tel: '',
  };

  cost: string='';
  date: string = '';
  propType: string = '';
  propDescc: string = '';
  contractDescription: string = '';
//new values.............
hasCar: boolean = false;
mileage: string = '';
age:string='';
hasStage: boolean =false;
duration: string = '';
startFranchise: string = '';
endFranchise: string = '';
 
 hasTravel:boolean=false;
 destination:string='';

  constructor(private http: HttpClient, private dataservice: dataService) {}

  register() {
    let bodyData = {
      "seller": {
        "nom": this.seller.nom,
        "prenom": this.seller.prenom,
        "username": this.seller.username,
        
        "password": this.seller.password,
        "CIN": this.seller.CIN,
        "tel": this.seller.tel,
        "roles": [{ "name": "ROLE_ADMIN" }]
      },
      "cost": this.cost,
      "date": this.date,
      "prop": {
        "id":2,
        "type": this.propType,
        "descc": this.propDescc
      },
      "descc": this.contractDescription,
       //new values

      "hasCar":this.hasCar,
       "mileage":this.mileage,
       "age":this.age,
       "hasStage":this.hasStage,
       "duration":this.duration,
       "startFranchise":this.startFranchise,
       "endFranchise":this.endFranchise,
     
        "hasTravel":this.hasTravel,
        "destination":this.destination,




    };
    alert("Contract  Registered Successfully.");
    this.http.post("http://192.168.49.2:30682/contrats/addContract", bodyData).subscribe((resultData: any) => {
      console.log(resultData);
      alert("Employee Registered Successfully");
      this.resetFormFields();
    });
  }

  save() {
    this.register();
  }

  private resetFormFields() {
    this.seller = {
      nom: '',
      prenom: '',
      username: '',
      password: '',
      CIN: '',
      tel: '',
    };
    this.cost = '';
    this.date = '';
    this.propType = '';
    this.propDescc = '';
    this.contractDescription = '';
   this.hasCar=false,
     this.mileage='',
    this.age='',
     this.hasStage=false,
          this.duration='',
     this.startFranchise='',
     this.endFranchise='',
      this.hasTravel=false,
      this.destination=''

  }
}
