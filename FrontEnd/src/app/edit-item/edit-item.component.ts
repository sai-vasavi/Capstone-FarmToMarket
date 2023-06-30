import { Component, OnInit } from '@angular/core';
import { Items } from '../items';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemsServiceService } from '../items-service.service';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit{
  id!: any;
  role!: string;
  emailId!: string;
  itemsData: Items = new Items;

   constructor(private _router: ActivatedRoute,private router: Router,private itemService:ItemsServiceService){}
   ngOnInit(): void {
     this.id=this._router.snapshot.params['id'];
     this.role=this._router.snapshot.params['role'];
     this.emailId=this._router.snapshot.params['emailId'];
     console.log(JSON.stringify(this._router.snapshot.params),"param")
     this.itemService.getItemById(this.id).subscribe(
       data=>{
         console.log(JSON.stringify(data)+"dataEquipment")
         console.log(JSON.stringify(this.id)+"dataEquipmentId")
         this.itemsData=data;

       },error=>console.log(error)
     )


   }
   onSubmit(){
     this.itemService.updateItemById(this.id,this.itemsData).subscribe(data=>{
       this.goToItemList();
     },error=>console.log(error))

   }
   goToItemList(){
     this.router.navigate([`/header/${this.role}/${this.emailId}/create-item-list`])

   }

}
