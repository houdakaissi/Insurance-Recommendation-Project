



import { dataService } from 'src/app/service/dataService';
import { Component } from '@angular/core';
import { MyContratDetails } from 'src/app/model/contrat.model';
//import { MyContratDetails } from 'src/app/model/contrat.model';
import { JwtService } from 'src/app/service/jwt.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  sortField: string | null = null;
  message: string;
  //displayedColumns =["cost","desc","date"];
  myContratDetails : MyContratDetails[]=[];
  element: MyContratDetails[]=[] ;
   
  term:any;
  constructor(
    private service: JwtService,private http: HttpClient,private data:dataService
  ) {
    
    this.message = ""; 
   }

   cart: any[] = [];

   // Function to add contract to cart
   addToCart(contract: any): void {
     // You can customize the data you want to store in the cart
     const contractToAdd = {
       cost: contract.cost,
       desc: contract.desc,
       date: contract.date,
       // Add other properties as needed
     };
 
     // Push the contract to the cart array
     this.cart.push(contractToAdd);
 
     // Optionally, you can update any additional logic or UI changes related to the cart
   }

   toggleMoreDetails(contract: MyContratDetails): void {
    // Toggle the showDetails property to display/hide details
    contract.showDetails = !contract.showDetails;
  }
  selectedAssurance: any;
 
  ngOnInit() {
    this.hello();
    this.getContrats();
    this.data.getData().subscribe((data: string) => {
      this.receivedData = data;
      // Do something with the received data
      console.log('Received dataaaaaaaaaaaaaaaaa:', this.receivedData);
    });
   
  }

  receivedData!: string;
  selectAssurance(element: any) {

   this.buyer.username=this.receivedData;
    this.seller.username = element.seller.username;
    console.log("hiiiiiiiiiiiiiiiiiiiii"+this.seller.username);
    this.seller.password = element.seller.password;
    this.seller.nom = element.seller.nom;
    this.seller.prenom = element.seller.prenom;
    this.seller.CIN = element.seller.CIN;
    this.seller.tel = element.seller.tel;
    this.cost = element.cost;
    this.date = element.date;
   // 
   this.hasCar = element.hasCar;
   this.mileage = element.mileage;
   this.age = element.age;
   this.hasStage = element.hasStage;
   this.duration = element.duration;
   this.startFranchise = element.startFranchise;
   this.endFranchise = element.endFranchise;
   this.hasTravel = element.hasTravel;
   this.destination = element.destination;
  //new values.............
  
 
  
    this.register();
  }
  
  
  
  showCart: boolean = false;

  toggleCart() {
    this.showCart = !this.showCart;
  }
  hello() {
    this.service.hello().subscribe(
      (response) => {
        console.log(response);
        this.message = response.message;
      }
    )
  }
  getContrats(){
    this.service.getContrats().subscribe(
      (response:MyContratDetails[]) => {
     // (response:element) =>
        console.log(response);
       this.myContratDetails=response;
      },(err)=>{
        console.log(err);
      }


    )
  }

  sortBy(field: string): void {
    if (field === this.sortField) {
      // If already sorted by the same field, reverse the order
      this.myContratDetails.reverse();
    } else {
      // Sort the contracts by the selected field
      this.myContratDetails.sort((a, b) => (a[field] > b[field] ? 1 : -1));
      this.sortField = field;
    }
  }



  
  seller: {
    nom: string,
    prenom: string,
    username: string,
    password: string,
    CIN: string,
    tel: string,
  } = {
    nom:  '',
    prenom: '',
    username: '',
    password: '',
    CIN: '',
    tel: '',
  };
  buyer: {
     
    username: string,
    
  } = {
    
    username: '',
    
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










  register() {
   // this.selectAssurance(this.element);
    let bodyData = {
      "seller": {
        "nom":this.seller.nom,
        "prenom": this.seller.prenom,
        "username": this.seller.username,
        
        "password": this.seller.password,
        "CIN": this.seller.CIN,
        "tel": this.seller.tel,
        "roles": [{ "name": "ROLE_ADMIN" }]
      },
      "buyer":{
        "username":this.buyer.username,
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