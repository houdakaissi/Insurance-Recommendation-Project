import { Component, OnInit } from '@angular/core';
import { JwtService } from '../service/jwt.service';
import { HttpClient, HttpRequest } from '@angular/common/http';

@Component({
  selector: 'app-contrats-user',
  templateUrl: './contrats-user.component.html',
  styleUrls: ['./contrats-user.component.css']
})
export class ContratsUserComponent implements OnInit {
  address: string ="";
  name: string ="";
   
  mobile: Number =0;

  
 seller:{
  username: string,
 }= {
   
 
  username: '',
  
};
 buyer:{
 username: string,
  password: string,
 }
 = {
  
   
  username: '',
  password: '',
  
};


  constructor(private service: JwtService,private http:HttpClient) { }

  ngOnInit(): void {
   // this.getContratsU();
  }
  /*
  public getContratsU(){
    return this.service.getContratsUser().subscribe(
      (response) => {
        
           console.log(response);
         
         },(err)=>{
           console.log(err);
         }
    )
  
    }
*/
    register()
    {
    
      let bodyData = {
        /*"seller": {
          
          "username": this.seller.username,
          "roles": [{ "name": "ROLE_ADMIN" }]
        },*/
        /*"buyer": {
          
          "username": this.buyer.username,
          "password": this.buyer.password,
           
          "roles": [{ "name": "ROLE_USER" }]
        },*/
        "date":  this.address,
        "desc": this.name,
         
        "email":   this.mobile,

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
  }

