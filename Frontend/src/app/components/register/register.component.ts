/*import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
*/
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JwtService } from 'src/app/service/jwt.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  // Inside your component class
//roles: string[] = ["admin"];
 
//roles: any[] = [];
// In your component class
// In your component class
//roles: Set<string> = new Set(['User', 'Admin']);
rolesArray: string[] = ['User', 'Admin'];


  registerForm: FormGroup = this.fb.group({
    /*username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
    password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(40)]],
    nom: ['', [Validators.required, Validators.maxLength(20)]],
    prenom: ['', [Validators.required, Validators.maxLength(20)]],
    telephone: ['', [Validators.maxLength(20)]],
    account_address: ['', [Validators.maxLength(100)]],
    roles: ['', [Validators.required]],*/
    username: ['', [Validators.required]],
    password: ['', [Validators.required]],
    nom: ['', [Validators.required]],
    prenom: ['', [Validators.required]],
    telephone: ['', [Validators.maxLength(20)]],
    account_address: ['', [Validators.maxLength(100)]],
    roles: ['', [Validators.required]],
    wallet:['', [Validators.required]],

   //roles: this.rolesSet,


    confirmPassword: ['', [Validators.required]],
  }, { validator: this.passwordMatchValidator });
  
  constructor(
    private service: JwtService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    // You can keep this method for additional initialization if needed
  }

  // The rest of your component code remains unchanged
  passwordMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;
    if (password !== confirmPassword) {
      formGroup.get('confirmPassword')?.setErrors({ passwordMismatch: true });
    } else {
      formGroup.get('confirmPassword')?.setErrors(null);
    }
  }

 

  submitForm() {
    const formValue = this.registerForm.value;
    // Convert roles to an array if needed
    formValue.roles = Array.isArray(formValue.roles) ? formValue.roles : [formValue.roles];
    console.log(formValue);
    this.service.register(formValue).subscribe(
      (response) => {
        if (response.id != null) {
          alert("Hello " + response.username);
        }
      }
    );
  }
  getRegisterForm(): FormGroup{
    return this.registerForm;
  }
}
