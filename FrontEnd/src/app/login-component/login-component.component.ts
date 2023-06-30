import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  imagePath:string='cover.png'
  constructor(private _service:RegistrationService, private _router: Router,private fb: FormBuilder,public dialog: MatDialog){}

  ngOnInit()
  {

  }

  user = new User();
  msg='';
  isDialogOpen :boolean = true;
openDialog(){
  this.isDialogOpen =  true;
}
closeDialog(){
  this.isDialogOpen =  false;
  window.location.reload()
}
  loginUser(){

    this._service.loginUserFromRemote(this.user).subscribe(

  data=>{console.log("response received" ,this.user.role)
  this._router.navigate([`header/${this.user.role}/${this.user.emailId}/loginsuccess`,this.role,this.emailId])
},
  error=>{console.log("response received")
this.msg="Bad credential"}

);
  }

  gotRegistration(){
    this._router.navigate(['registration'])
  }

  registerForm: FormGroup = this.fb.group({
    firstName: ['', [Validators.required]],
    lastName: ['', [Validators.required]],
    emailId: ['', [Validators.required, Validators.email]],
    phonenumber: ['', [Validators.required, Validators.minLength(10)]],
    password: ['', [Validators.required, Validators.minLength(8)]],
    password1: ['', [Validators.required, Validators.minLength(8)]],
    role: ['', [Validators.required]],
    state: ['', [Validators.required]],
    city: ['', [Validators.required]],
    pincode: ['', [Validators.required]],
  });


  get firstName(): any {
    return this.registerForm.get('firstName');
  }
  get lastName(): any {
    return this.registerForm.get('lastName');
  }
  get emailId(): any {
    return this.registerForm.get('emailId');
  }
  get phonenumber(): any {
    return this.registerForm.get('phonenumber');
  }
  get password(): any {
    return this.registerForm.get('password');
  }
  get password1(): any {
    return this.registerForm.get('password1');
  }
  get role(): any {
    return this.registerForm.get('role');
  }
  get state(): any {
    return this.registerForm.get('state');
  }
  get city(): any {
    return this.registerForm.get('city');
  }
  get pincode(): any {
    return this.registerForm.get('pincode');
  }
  registerFormSubmit(): void {

    const formData = this.registerForm.value;

    console.log(formData);

    this._service.registrationUserFromRemote(formData).subscribe(

  data=>{
    console.log("response received")

 this.closeDialog()


    // Api Request Here
  })
}
}
