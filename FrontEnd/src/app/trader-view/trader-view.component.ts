import { Component, OnInit } from '@angular/core';
import { Items } from '../items';
import { ItemsServiceService } from '../items-service.service';

@Component({
  selector: 'app-trader-view',
  templateUrl: './trader-view.component.html',
  styleUrls: ['./trader-view.component.css']
})
export class TraderViewComponent implements OnInit{
  items: Items[] = [];
  imagePath:string='whiterice.jpg'
  constructor(private _service : ItemsServiceService) { }
  ngOnInit(): void {
    this._service.AllItemsFromRemote().subscribe(
      data=>{
        this.items=data
        this.items.filter(data=>data.photo=this.imagePath)
        console.log(JSON.stringify(data)+"DATA")
        const dataValue=this.items.find(data=>data.user.id == 1)
        console.log(JSON.stringify(dataValue)+"userData")


      }
    )
  }

  onBook(){

  }
}
