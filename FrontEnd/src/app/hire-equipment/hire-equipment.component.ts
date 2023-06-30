import { Component, OnInit } from '@angular/core';
import { EquipmentService } from '../equipment.service';
import { Equipment } from '../equipment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hire-equipment',
  templateUrl: './hire-equipment.component.html',
  styleUrls: ['./hire-equipment.component.css']
})
export class HireEquipmentComponent implements OnInit {
  id!:number;
  equipments: Equipment[] = [];
  imagePath:string='machine1.jpg'
  constructor(private _service : EquipmentService,private roter :Router) { }
  ngOnInit(): void {
    this._service.AllEquipmentFromRemote().subscribe(
      data=>{
        this.equipments=data
        this.equipments.filter(data=>data.eImage=this.imagePath)
        console.log(JSON.stringify(data)+"DATA")

      }
    )
  }

  onBook(id:number){
    this.roter.navigate(['/header/view-hired-equipment',id])

  }
}
