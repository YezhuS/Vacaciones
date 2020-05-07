import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Ausencia } from 'src/app/Modelo/Ausencia';

@Component({
  selector: 'app-ausencias',
  templateUrl: './ausencias.component.html',
  styleUrls: ['./ausencias.component.css']
})
export class AusenciasComponent implements OnInit {

  ausencia:Ausencia[];
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.service.getAusencias()
    .subscribe(data=>{
      this.ausencia = data;
      console.log(data);
    });
  }

  Editar(ausencia:Ausencia):void{
    localStorage.setItem("id", ausencia.id.toString());
    this.router.navigate(["editarAusencias"]); 
  }

  Eliminar(ausencia:Ausencia){
    this.service.deleteAusencia(ausencia.id)
    .subscribe();
    alert("Adiós a la Ausencia");
    this.ngOnInit();
  }

  killThemAll(){
    this.service.deleteAllAusencias()
    .subscribe();
    alert('Adiós chumachos!');
    this.ngOnInit();
  }

}
