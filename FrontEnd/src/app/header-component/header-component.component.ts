import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-header-component',
  templateUrl: './header-component.component.html',
  styleUrls: ['./header-component.component.css']
})
export class HeaderComponentComponent implements OnInit{
  role!: any;
  emailId!: string;
 constructor(private _router: ActivatedRoute,private router:Router){}

  ngOnInit(): void {
    this.role=this._router.snapshot.params['role'];
    this.emailId=this._router.snapshot.params['emailId'];
    console.log(this.role + "userRole")
    console.log(JSON.stringify(this._router.snapshot.params) + "userRole")


  }
  imagePath:string='cover.png'
  logoutFunction(){
    window.location.href='/login';

  }

}
