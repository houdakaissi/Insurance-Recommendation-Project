import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ContratsUserComponent } from './contrats-user/contrats-user.component';
import { AdminComponent } from './components/admin/admin.component';
import { AdminListcontratsComponent } from './components/admin-listcontrats/admin-listcontrats.component';
import { AdminAddcontractsComponent } from './components/admin-addcontracts/admin-addcontracts.component';
import { AdminListcomplainsComponent } from './components/admin-listcomplains/admin-listcomplains.component';

import { CompleteComponent } from './components/complete/complete.component';
import { SearchComponent } from './components/search/search.component';
import { ContractsComponent } from './components/contracts/contracts.component';
import { ListComponent } from './components/list/list.component';
const routes: Routes = [
  { path: "register", component: RegisterComponent },
 { path: 'login', component: LoginComponent },
  //{ path: 'signup', component: SignupComponent },
  //{ path: 'signout', component: SignoutComponent },
  { path: "contracts", component: ContractsComponent },
  { path: "dashboard", component: DashboardComponent },
  { path: "contrats-user", component: ContratsUserComponent},
  { path: "admin", component: AdminComponent},
{path: "admin_listcontrats",component:  AdminListcontratsComponent },
{path: "admin_addcontrats",component:  AdminAddcontractsComponent },
{path:"admin_listcomplains",component:AdminListcomplainsComponent},
 {path:"completerprofile", component:CompleteComponent},
 {path:"search", component:SearchComponent},
 {path:"list", component:ListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
