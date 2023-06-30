import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponentComponent } from './header-component/header-component.component';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { RegistrationComponent } from './registration/registration.component';
import { EquipmentComponent } from './equipment/equipment.component';
import { EquiAddEditComponent } from './equi-add-edit/equi-add-edit.component';
import { CreateItemListComponent } from './create-item-list/create-item-list.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { HireEquipmentComponent } from './hire-equipment/hire-equipment.component';
import { TraderViewComponent } from './trader-view/trader-view.component';
import { ViewHiredEquipComponent } from './view-hired-equip/view-hired-equip.component';
import { AppComponent } from './app.component';
import { LoginComponentComponent } from './login-component/login-component.component';

const routes: Routes = [
  {path:'login', component :LoginComponentComponent},
  {path:'', redirectTo:"/login",pathMatch:'full'},
  {path:'header/:role/:emailId',component:HeaderComponentComponent,children:[
    {path:'loginsuccess',component:LoginsuccessComponent},
    {path:'loginsuccess/:role',component:LoginsuccessComponent},
    {path:'registration',component:RegistrationComponent},
    {path:'equipment',component:EquipmentComponent},
    {path:'edit',component:EquiAddEditComponent},
    {path: 'update-equipment/:id', component: EquiAddEditComponent},
    {path: 'equipment-details/:id', component: EquipmentComponent},
    {path:'create-item-list',component:CreateItemListComponent},
    {path:'create-item-list/:emailId',component:CreateItemListComponent},
    {path:'edit-item/:id',component:EditItemComponent},
    {path:'hire-equipment',component:HireEquipmentComponent},
    {path:'view-traders',component:TraderViewComponent},
    {path:'view-hired-equipment',component:ViewHiredEquipComponent},
    {path:'view-hired-equipment/:id',component:ViewHiredEquipComponent}
  ]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
