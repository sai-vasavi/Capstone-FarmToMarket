import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatButtonModule} from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponentComponent } from './header-component/header-component.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { RegistrationComponent } from './registration/registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {  HttpClientModule } from '@angular/common/http';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { EquipmentComponent } from './equipment/equipment.component';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import {MatTableModule} from '@angular/material/table';
import { EquiAddEditComponent } from './equi-add-edit/equi-add-edit.component';
import { CreateItemListComponent } from './create-item-list/create-item-list.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { HireEquipmentComponent } from './hire-equipment/hire-equipment.component';
import { ViewHiredEquipComponent } from './view-hired-equip/view-hired-equip.component';
import { TraderViewComponent } from './trader-view/trader-view.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponentComponent,
    LoginComponentComponent,
    RegistrationComponent,
    LoginsuccessComponent,
    EquipmentComponent,
    EquiAddEditComponent,
    CreateItemListComponent,
    EditItemComponent,
    HireEquipmentComponent,
    ViewHiredEquipComponent,
    TraderViewComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatIconModule,
    MatTableModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
