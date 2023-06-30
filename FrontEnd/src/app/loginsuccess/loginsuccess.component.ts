import { Component, OnInit } from '@angular/core';
import { Farmer } from '../header-component/Farmer';

@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit{
  ngOnInit(): void {
    this.imagePath
    this.imagePath2
  }
  imagePath:string='AboutImage.png'
  imagePath2:string='AboutImage2.png'
}
