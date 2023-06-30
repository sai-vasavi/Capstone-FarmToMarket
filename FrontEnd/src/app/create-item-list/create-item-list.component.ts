import { Component } from '@angular/core';
import { Items } from '../items';
import { ItemsServiceService } from '../items-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-create-item-list',
  templateUrl: './create-item-list.component.html',
  styleUrls: ['./create-item-list.component.css']
})
export class CreateItemListComponent {

id!:number
emailId!:string
role!:string
  itemsData: Items[] = [];
  url="./assets/image1.png"
  selectedFile: File | null=null;

  constructor(private _service:ItemsServiceService, private router: ActivatedRoute,private _router: Router,private fb: FormBuilder,public dialog: MatDialog){}

  onFileSelected(e:any){
    console.log(JSON.stringify(e)+'event')
    console.log(JSON.stringify(e.target)+'event')
if(e.target.files){
  var reader= new FileReader();
  reader.readAsDataURL(e.target.files[0]);
  reader.onload=(event:any)=>{
    this.url=event.target.result;
  }
}
    this.selectedFile=e.target.files[0];
  }

  ngOnInit(): void
  {
    this.itemsList();
    this.emailId=this.router.snapshot.params['emailId'];
    this.role=this.router.snapshot.params['role'];

  }

  itemsForm: FormGroup = this.fb.group({
    name: ['', [Validators.required]],
    photo: ['', [Validators.required]],
    description: ['', [Validators.required]],
    quantityavailable: ['', [Validators.required]],
  });


  get name(): any {
    return this.itemsForm.get('name');
  }
  get photo(): any {
    return this.itemsForm.get('photo');
  }
  get description(): any {
    return this.itemsForm.get('description');
  }
  get quantityavailable(): any {
    return this.itemsForm.get('quantityavailable');
  }


  dataValue:any[]=[]

  itemRegisterFormSubmit(): void {

    const formData = this.itemsForm.value;
    formData.photo=this.selectedFile;
    console.log(JSON.stringify(this.itemsForm.value)+'dataItem');

    console.log('dataItem calling'+JSON.stringify(this.emailId));


    this._service.AddItemsFromRemote(formData,this.emailId).subscribe(

    data=>{
    console.log("response received"+data)

    })
    window.location.reload();
  }

  itemsList(){
    this._service.AllItemsFromRemote().subscribe(
      data=>{
        this.itemsData=data
        console.log(JSON.stringify(data)+"DATA")
        console.log(JSON.stringify(this.dataValue)+"DATAvALUE")

      }
    )
    this.dialog.closeAll();

  }

  onNoClick():void{
    this.dialog.closeAll();
  }
  updateItem(id:number){
    this._router.navigate([`/header/${this.role}/${this.emailId}/edit-item`,id])
  }
  deleteItem(id:number){
    this._service.deleteItem(id).subscribe( data => {
      console.log(data);
      this.itemsList();
    })
  }
}
