import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EquipmentService } from '../equipment.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Equipment } from '../equipment';

export interface PeriodicElement {
  equipmentId:number | undefined;
  equipmentname:string | undefined;
  eImage:string | undefined;
  ecount:number | undefined;
  rentDay:number | undefined;
  estate:string | undefined;
  ecity:string | undefined;
  evillage:string | undefined;
  epincode:number | undefined;
  econtact:string | undefined;
  enumber:number | undefined
}


@Component({
  selector: 'app-equipment',
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.css'],
})
export class EquipmentComponent implements OnInit{

  equipments: Equipment[] = [];
  constructor(private _service:EquipmentService,private router: ActivatedRoute, private _router: Router,private fb: FormBuilder,public dialog: MatDialog){}

  role!:string
  emailId!:string
  ngOnInit(): void
  {
    this.equpimentList();
    this.role=this.router.snapshot.params['role'];
    this.emailId=this.router.snapshot.params['emailId'];
  }

  gotRegistration(){
    this._router.navigate([`herader/${this.role}/${this.emailId}/registration`])
  }

  selectedFile!: File;
  imageUrl!: string;

  onFileSelected(event:any){

    this.selectedFile=event.target.files[0];
  }



  equipmentForm: FormGroup = this.fb.group({
    equipmentname: ['', [Validators.required]],
    eImage: ['', [Validators.required]],
    ecount: ['', [Validators.required]],
    rentDay: ['', [Validators.required]],
    enumber: ['', [Validators.required, Validators.minLength(10)]],
    evillage: ['', [Validators.required]],
    estate: ['', [Validators.required]],
    ecity: ['', [Validators.required]],
    epincode: ['', [Validators.required]],
  });


  get equipmentname(): any {
    return this.equipmentForm.get('equipmentname');
  }
  get eImage(): any {
    return this.equipmentForm.get('eImage');
  }
  get ecount(): any {
    return this.equipmentForm.get('ecount');
  }
  get rentDay(): any {
    return this.equipmentForm.get('rentDay');
  }
  get enumber(): any {
    return this.equipmentForm.get('enumber');
  }
  get evillage(): any {
    return this.equipmentForm.get('evillage');
  }

  get estate(): any {
    return this.equipmentForm.get('estate');
  }
  get ecity(): any {
    return this.equipmentForm.get('ecity');
  }
  get epincode(): any {
    return this.equipmentForm.get('epincode');
  }

  dataValue:any[]=[]
  registerFormSubmit(): void {
    const formData = this.equipmentForm.value;

    console.log(formData);


    this._service.AddEquipmentFromRemote(formData).subscribe(

  data=>{
    console.log("response received")

  })
  window.location.reload();
  }

  equpimentList(){
    this._service.AllEquipmentFromRemote().subscribe(
      data=>{
        this.equipments=data
        console.log(JSON.stringify(data)+"DATA")
        console.log(JSON.stringify(this.dataValue)+"DATAvALUE")

      }
    )
    this.dialog.closeAll();

  }
  callFinction(){
    this._router.navigate(['/edit'])
  }

  onNoClick():void{
    this.dialog.closeAll();
  }
  updateEquipment(id:number){
    this._router.navigate([`/header/${this.role}/${this.emailId}/update-equipment`,id])
  }
  deleteEquipment(id:number){
    this._service.deleteEquipment(id).subscribe( data => {
      console.log(data);
      this.equpimentList();
    })
  }

}
