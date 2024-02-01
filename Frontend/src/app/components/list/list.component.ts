import { Component, OnInit } from '@angular/core';
 
import { HttpClient } from '@angular/common/http';
import { JwtService } from 'src/app/service/jwt.service';
import { MyContratDetails } from 'src/app/model/contrat.model';
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent  {

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

  constructor(private http: HttpClient,private service: JwtService) {}

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
 
 


  const url2 = 'http://192.168.49.2:30682/user_internship_predict/' + this.duration + '/' + this.startFranchise+'/'+this.endFranchise;



this.http.get(url2).subscribe(
    (resultData: any) => {
      console.log(resultData);
      alert("car Registered Successfully");
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
}
