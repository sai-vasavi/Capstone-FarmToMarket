import { Component, OnInit } from '@angular/core';
import { EquipmentService } from '../equipment.service';
import { ActivatedRoute } from '@angular/router';
import { Equipment } from '../equipment';

@Component({
  selector: 'app-view-hired-equip',
  templateUrl: './view-hired-equip.component.html',
  styleUrls: ['./view-hired-equip.component.css']
})
export class ViewHiredEquipComponent implements OnInit{
  id!: any;
  equipmentsData: Equipment =new Equipment;
 constructor(private service:EquipmentService,private _router: ActivatedRoute,){}

  ngOnInit(): void {
    this.id=this._router.snapshot.params['id'];
    this.service.getEquipmentById(this.id).subscribe(
      data=>{this.equipmentsData =data
        console.log(JSON.stringify(this.equipmentsData)+"getEquipdata")}
    )
  }

}
