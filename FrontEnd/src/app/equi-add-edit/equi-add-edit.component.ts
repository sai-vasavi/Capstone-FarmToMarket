import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { EquipmentService } from '../equipment.service';
import { Equipment } from '../equipment';

@Component({
  selector: 'app-equi-add-edit',
  templateUrl: './equi-add-edit.component.html',
  styleUrls: ['./equi-add-edit.component.css']
})
export class EquiAddEditComponent implements OnInit {
  equipmentId!: any;
 equipment: Equipment = new Equipment;
  role!: any;
  emailId!: any;

  constructor(private _router: ActivatedRoute,private router: Router,private equipmentService:EquipmentService){}
  ngOnInit(): void {
    this.equipmentId=this._router.snapshot.params['id'];
    this.role=this._router.snapshot.params['role'];
    this.emailId=this._router.snapshot.params['emailId'];
    console.log(JSON.stringify(this._router.snapshot.params),"param")
    this.equipmentService.getEquipmentById(this.equipmentId).subscribe(
      data=>{
        console.log(JSON.stringify(data)+"dataEquipment")
        console.log(JSON.stringify(this.equipmentId)+"dataEquipmentId")
        this.equipment=data;

      },error=>console.log(error)
    )


  }
  onSubmit(){
    this.equipmentService.updateEquipmentById(this.equipmentId,this.equipment).subscribe(data=>{
      this.goToEquipmentList();
    },error=>console.log(error))

  }
  goToEquipmentList(){
    this.router.navigate([`/header/${this.role}/${this.emailId}/equipment`])

  }

}
