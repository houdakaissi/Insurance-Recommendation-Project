 
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JwtService } from 'src/app/service/jwt.service';
 
 

@Component({
  selector: 'app-complete',
  templateUrl: './complete.component.html',
  styleUrls: ['./complete.component.css']
})
export class CompleteComponent implements OnInit {

   
  completeProfileForm!: FormGroup;


  constructor(private fb: FormBuilder, private service: JwtService) {}

  ngOnInit(): void {
    this.completeProfileForm = this.fb.group({
      wallet: ['', Validators.required],
      // Add other fields as needed
    });
  }







submitCompleteProfileForm(): void {
    const formValue = this.completeProfileForm.value;
    console.log(formValue);
   // if (this.completeProfileForm.valid) {
      // Save the completed profile information using your service
      this.service.c(formValue).subscribe(
        (response) => {
          if (response != null) {
            alert("Hello ");
          }
          else{
            console.log("nooo")
          }
        }
      );;

      // Optionally, navigate to another page or perform other actions
   // }
  }



  showCarDetails = false;

  onHasCarChange(event: Event) {
    const value = (event.target as HTMLInputElement)?.value;
    this.showCarDetails = value === 'yes';
  }
  
  
 






}
