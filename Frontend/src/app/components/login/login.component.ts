/*import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}*/



import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/service/jwt.service';
import { RegisterComponent } from '../register/register.component';
import { AdminAddcontractsComponent } from '../admin-addcontracts/admin-addcontracts.component';
import { dataService } from 'src/app/service/dataService';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 // loginForm: FormGroup | undefined;
 loginForm!: FormGroup;
 registercomponent!: RegisterComponent;
 // Example initialization
 private add!: AdminAddcontractsComponent

  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router,
    private dataservice: dataService
   // private registercomponent: RegisterComponent,
  ) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]], // Corrected here
      password: ['', [Validators.required]], // Corrected here
      roles:['', [Validators.required]], 
    });
  }
  
 

submitForm()  {
  
  this.service.login(this.loginForm.value).subscribe(
    (response) => {
   //   console.log(this.registercomponent.getRegisterForm().value.roles)
      console.log(response);
      
      
      if (response.accessToken != null) {
        alert("Hello, Your token is " + response.accessToken);
        const jwtToken = response.accessToken;  // Fix typo here
        localStorage.setItem('Token', jwtToken); 
        const a = response.username;
        const b=response.tel;
        const c=response.prenom;
        const d=response.account_address;
        const e=response.cin;
        // AdminAddcontractsComponent
        this.dataservice.changeResponse(a,b,c,d,e);
         this.dataservice.sendData(a);
    

   
      
        
        // Fix key name here
    if (this.loginForm.value.roles === 'Admin' ) {
        // if (this.registercomponent.getRegisterForm().value.roles===''  &&this.loginForm.value.username==='' ) {
       // Redirect to /admin if username and password are 'x'
          this.router.navigateByUrl("/admin");
        } else {
          // Redirect to /dashboard for any other case
          this.router.navigateByUrl("/dashboard");
        }
        //this.router.navigateByUrl("/dashboard");
      }
    }
    
  );

}






}



