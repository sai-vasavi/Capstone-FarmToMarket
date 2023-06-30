import { Component } from '@angular/core';
import { Farmer } from './header-component/Farmer';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'myapp';
  imagePath:string='image2.png'
  farmer:Farmer={
    id:10,
    UserName:"vasavi",
    Password:"vasavi",
    city:"dhone",
    pincode:518222,
    mobileNumber:87757843,
    state:"kurnool",
    Item:[{
      Itemid:1,
      ItemName:"rice",
      ItemPhoto:"rice",
      ItemDescription:"rices",
      QualityAvaliable:745874,

    },{
      Itemid:1,
      ItemName:"rice",
      ItemPhoto:"rice",
      ItemDescription:"rices",
      QualityAvaliable:745874,

    },{
      Itemid:1,
      ItemName:"rice",
      ItemPhoto:"rice",
      ItemDescription:"rices",
      QualityAvaliable:745874,

    }]
}

   click(){
   console.log("clicking")
  }
}
