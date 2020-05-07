import { Component, OnInit } from '@angular/core';
import { AusenciasComponent } from '../ausencias/ausencias.component';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Ausencia } from 'src/app/Modelo/Ausencia';

@Component({
  selector: 'app-editar-ausencia',
  templateUrl: './editar-ausencia.component.html',
  styleUrls: ['./editar-ausencia.component.css']
})
export class EditarAusenciaComponent implements OnInit {

  ausencia:Ausencia = new Ausencia();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar(this.ausencia);
  }

  Editar(ausencia:Ausencia){
    let id = localStorage.getItem("id");
    this.service.getAusenciaId(+id)
    .subscribe(data=>{
      this.ausencia = data;
    })
  }

  Actualizar(ausencia:Ausencia){
    this.service.updateAusencia(ausencia.id, ausencia)
    .subscribe(data=>{
      this.ausencia = data;
      alert('Se ha actualizado los datos');
      this.router.navigate(["ausencias"]);
    })
  }

}
