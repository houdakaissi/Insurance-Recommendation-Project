import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
 
import { MatTableModule } from '@angular/material/table';
import { MatCommonModule } from '@angular/material/core';
import { MatCardModule } from '@angular/material/card';
//import { SigninComponent } from './signin/signin.component';
//import { SignupComponent } from './signup/signup.component';
//import { SignoutComponent } from './signout/signout.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms'
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ContratsUserComponent } from './contrats-user/contrats-user.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { AdminComponent } from './components/admin/admin.component';
 
import { MatIconModule } from '@angular/material/icon';
import { AdminListcontratsComponent } from './components/admin-listcontrats/admin-listcontrats.component';
import { AdminAddcontractsComponent } from './components/admin-addcontracts/admin-addcontracts.component';
import { AdminListcomplainsComponent } from './components/admin-listcomplains/admin-listcomplains.component';
import { CompleteComponent } from './components/complete/complete.component';
import { SearchComponent } from './components/search/search.component';
import { ContractsComponent } from './components/contracts/contracts.component';
import { ReclamationComponent } from './components/reclamation/reclamation.component';
import { ListComponent } from './components/list/list.component';
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    DashboardComponent,
    ContratsUserComponent,
    AdminComponent,
    AdminListcontratsComponent,
    AdminAddcontractsComponent,
    AdminListcomplainsComponent,
    CompleteComponent,
    SearchComponent,
    ContractsComponent,
    ReclamationComponent,
    ListComponent,
   // ReactiveFormsModule,
   // SigninComponent,
    //SignupComponent,
   // SignoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatCommonModule,
    MatCardModule,
    Ng2SearchPipeModule,
    MatIconModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
