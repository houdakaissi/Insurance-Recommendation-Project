import { Component, OnInit } from '@angular/core';
import { MyContratDetails } from 'src/app/model/contrat.model';
import { JwtService } from 'src/app/service/jwt.service';
import { LoginComponent } from '../login/login.component';
import { dataService } from 'src/app/service/dataService';
import { ChangeDetectorRef } from '@angular/core';
@Component({
  selector: 'app-admin-listcontrats',
  templateUrl: './admin-listcontrats.component.html',
  styleUrls: ['./admin-listcontrats.component.css']
})
export class AdminListcontratsComponent implements OnInit {
  user: any; 
  columnsToDisplay =["cost","date","type","buyer.nom",];
  constructor(private service: JwtService,private data:dataService ) { }
  myContratDetails : MyContratDetails[]=[];
  // Assuming this is in your component class
filteredContratDetails = this.myContratDetails.filter(user => user.date === '22');



 









showTable: boolean = true;
receivedData!: string;
  ngOnInit(): void {
    this.get1();
    this.data.getData().subscribe((data: string) => {
      this.receivedData = data;
      // Do something with the received data
      console.log('Received dataaaaaaaaaaaaaaaaa:', this.receivedData);
      this.showTable ;
       
    });
/*
 <tr mat-header-row *matHeaderRowDef="columnsToDisplay"></tr>
        <tr mat-row *matRowDef="let myRowData; columns: columnsToDisplay"></tr>


*/
  
  

  }
get1(){
  this.service.get11().subscribe(
    (response:MyContratDetails[]) => {
      this.myContratDetails=response;
      // (response:element) =>
         console.log(response);
         
       },(err)=>{
         console.log(err);
       }
  );
}





}



