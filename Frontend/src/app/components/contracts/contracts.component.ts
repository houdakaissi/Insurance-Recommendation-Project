import { Component, OnInit } from '@angular/core';
 
import { MyContratDetails } from 'src/app/model/contrat.model';
import { JwtService } from 'src/app/service/jwt.service';
import { LoginComponent } from '../login/login.component';
import { dataService } from 'src/app/service/dataService';
import { ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-contracts',
  templateUrl: './contracts.component.html',
  styleUrls: ['./contracts.component.css']
})
export class ContractsComponent implements OnInit {

  user: any; 
  columnsToDisplay =["cost","date","type","buyer.nom",];
  constructor(private service: JwtService,private data:dataService,private http: HttpClient ,private router: Router) { 














  }
  myContratDetails : MyContratDetails[]=[];
  // Assuming this is in your component class
filteredContratDetails = this.myContratDetails.filter(user => user.date === '22');



 



showTable: boolean = true;
receivedData!: string;
  ngOnInit(): void {
    this.get1();
    this.data.getData().subscribe((data: string) => {
      this.receivedData = data;
      // Do something with the received data
      console.log('Received dataaaaaaaaaaaaaaaaa:', this.receivedData);
      this.showTable ;
       
    });
/*
 <tr mat-header-row *matHeaderRowDef="columnsToDisplay"></tr>
        <tr mat-row *matRowDef="let myRowData; columns: columnsToDisplay"></tr>


*/
  
  

  }
  get1(){
    this.service.get11().subscribe(
      (response:MyContratDetails[]) => {
        this.myContratDetails=response;
        // (response:element) =>
           console.log(response);
           
         },(err)=>{
           console.log(err);
         }
    );
  }
  
  
  showForm: boolean = false;

  toggleForm(a :string ) {
    // Toggle the value of showForm
    this.susername=a;
    this.showForm = !this.showForm;
    
  }

  address: string ="";
  name: string ="";
   
  mobile: Number =0;

  



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
  buyer: {
    nom: string,
    prenom: string,
    username: string,
    password: string,
    CIN: string,
    tel: string,
  } = {
    nom: '',
    prenom: '',
    username:  this.receivedData,
    password: '',
    CIN: '',
    tel: '',
  };
  
  date: string = '';
  description: string = '';
  email: string = '';
  response: string = '';
  hasCar: boolean = false;
  mileage: string = '';
  age:string='';
  hasStage: boolean =false;
  duration: string = '';
  startFranchise: string = '';
  endFranchise: string = '';
   susername:string='';
   busername:string=this.receivedData;
   hasTravel:boolean=false;
   destination:string='';
 
  
   register()
   {
   
     let bodyData = {
     /* "seller": {
        "nom": this.seller.nom,
        "prenom": this.seller.prenom,
        "username": this.seller.username,
        
        "password": this.seller.password,
        "CIN": this.seller.CIN,
        "tel": this.seller.tel,
        "roles": [{ "name": "ROLE_ADMIN" }]
      },*/
     /* "buyer": {
        "nom": this.seller.nom,
        "prenom": this.seller.prenom,
        "username": this.seller.username,
        
        "password": this.seller.password,
        "CIN": this.seller.CIN,
        "tel": this.seller.tel,
        "roles": [{ "name": "ROLE_ADMIN" }]
      },*/
       "date":  this.address,
       "desc": this.name,
        "response":this.response,
       "email":   this.mobile,
       "susername":this.susername,
       "busername":this.receivedData,
       
     };
  
     this.http.post("http://192.168.49.2:30682/reclamation/addComplaint",bodyData).subscribe((resultData: any)=>
     {
         console.log(resultData);
         alert("Employee Registered Successfully")
         
         this.name = '';
         this.address = '';
        this.mobile  = 0;
     });
   }
 save()
   {
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
  this.buyer = {
    nom: '',
    prenom: '',
    username: this.receivedData,
    password: '',
    CIN: '',
    tel: '',
  };
 this.description='';
  this.date = '';
  this.email='';
  this.response='';
  


}
navigateToContractsUser() {
  this.router.navigate(['/contracts-user']);
}
  
  }
  
  
  
  




