import { Component, OnInit } from '@angular/core';
import { AusenciasComponent } from '../ausencias/ausencias.component';
import { Ausencia } from 'src/app/Modelo/Ausencia';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-crear-ausencia',
  templateUrl: './crear-ausencia.component.html',
  styleUrls: ['./crear-ausencia.component.css']
})
export class CrearAusenciaComponent implements OnInit {

  ausencia:Ausencia = new Ausencia();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }

  Guardar(ausencia:Ausencia){
    this.service.createAusencia(ausencia)
    .subscribe(data=>{
      alert('Se agregó!');
      this.router.navigate(["ausencias"]);
    })
  }

}
