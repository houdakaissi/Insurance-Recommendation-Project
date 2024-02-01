import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { JwtService } from 'src/app/service/jwt.service';
import { MyContratDetails } from 'src/app/model/contrat.model';
import { dataService } from 'src/app/service/dataService';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  ngOnInit(): void {
    this.dataservice.username$.subscribe(({response1,response2,response3,response4,response5}) => {
      this.etudiant=response1;
     
        
     });
      
     
  
}
  myContratDetails : MyContratDetails[]=[];

  hascar: boolean = false;
  meliage: number = 0;
  age: number = 0;
  
  hasstage: boolean =false;
  duration: string = '';
  startFranchise: string = '';
  endFranchise: string = '';
   hastravel:boolean=false;
   duration1: string = '';
  startFranchise1: string = '';
  endFranchise1: string = '';
  destination:string='';

  constructor(private http: HttpClient,private service: JwtService, private dataservice: dataService) {}

  register() {
    let bodyData = {
      
      "hasCar":false,
      "mileage": this.meliage,
      "age": this.age,
      "hasStage": this.hasstage,
      "duration": this.duration,
      "startFranchise": this.startFranchise,
      "endFranchise": this.endFranchise,
      "hasTravel": this.hastravel,
      "destination": this.destination
    };
    
    alert("Contract Registered Successfully.");
   
    const url = 'http://localhost:8081/user_car_predict/' + this.age + '/' + this.meliage;
   



// Assuming this is within your component class
this.service.get(this.age, this.meliage).subscribe(
  (resultData: MyContratDetails[]) => {
    console.log(resultData);
    alert("Car Registered Successfully");
    this.myContratDetails = resultData;
    this.resetFormFields();
  },
  (error) => {
    console.error('Error in get request:', error);
    // Handle the error if needed
  }
);


   
   
    
  }

  save() {
    this.register();
  }
save1(){
  let bodyData = {
      
    "hasCar":false,
    "mileage": this.meliage,
    "age": this.age,
    "hasStage": this.hasstage,
    "duration": this.duration,
    "startFranchise": this.startFranchise,
    "endFranchise": this.endFranchise,
    "hasTravel": this.hastravel,
    "destination": this.destination
  };
  
  alert("Contract Registered Successfully.");
 
 
  const url1 = 'http://localhost:8081/user_travel_predict/' + this.duration + '/' + this.startFranchise+'/'+this.endFranchise+'/'+this.destination;



  



 

  this.http.get(url1).subscribe(
    (resultData: any) => {
      console.log(resultData);
      alert("travel Registered Successfully");
      this.resetFormFields();
    },
    (error) => {
      console.error('Error in get request:', error);
      // Handle the error if needed
    }
  );
}
save2(){
  let bodyData = {
      
    "hasCar":false,
    "mileage": this.meliage,
    "age": this.age,
    "hasStage": this.hasstage,
    "duration": this.duration,
    "startFranchise": this.startFranchise,
    "endFranchise": this.endFranchise,
    "hasTravel": this.hastravel,
    "destination": this.destination
  };
  
  alert("Contract Registered Successfully.");
 
 


  const url2 = 'http://localhost:8081/user_internship_predict/' + this.duration + '/' + this.startFranchise+'/'+this.endFranchise;



this.http.get(url2).subscribe(
    (resultData: any) => {
      console.log(resultData);
      alert("car Registered Successfully");
      this.myContratDetails = resultData;
      this.resetFormFields();
    },
    (error) => {
      console.error('Error in get request:', error);
      // Handle the error if needed
    }
  );

}
  private resetFormFields() {
    
     this.hascar=false,
    this.meliage =0,
    this.age=0,
     this.hasstage=false,
     this.duration='',
     this.startFranchise='',
    this.startFranchise='',
      this.hastravel=false,
      this.duration='',
    this.startFranchise='',
     this.endFranchise='',
     this.destination=''
  }


  showCarDetails = false;

  onHasCarChange(event: Event) {
    const value = (event.target as HTMLInputElement)?.value;
    this.showCarDetails = value === 'yes';
  }

   get1(){
    this.service.get(this.age, this.meliage).subscribe(
      (response:MyContratDetails[]) => {
        this.myContratDetails=response;
        // (response:element) =>
           console.log(response);
           
         },(err)=>{
           console.log(err);
         }
    );
  
        }



// Assuming this is within your component class
 
//aadd

etudiant: string=''
 
  society: String =  '';
 
    amount:number=0;
    durationInDays:number=0;


registerr() {
  let bodyData = {
    "etudiant":this.etudiant,
    "society":this.society,
    "amount":this.amount,
    "durationInDays":this.durationInDays,
      
    




  };
  alert("assurance  Registered Successfully.");
  this.http.post("http://192.168.49.2:30682/selected-insurances/create", bodyData).subscribe((resultData: any) => {
    console.log(resultData);
    alert("Employee Registered Successfully");
    this.resetFormFieldss();
  });
}

savee(agency: string,premium:number) {
  this.society = agency;
  this.amount=premium;
   
  this.register();
}

private resetFormFieldss() {
  
   this.etudiant='';
  this.society='';
  this.amount=0;
  this.durationInDays=0;
    

}







}

