import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/Modelo/Proyecto';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-editar-proyecto',
  templateUrl: './editar-proyecto.component.html',
  styleUrls: ['./editar-proyecto.component.css']
})
export class EditarProyectoComponent implements OnInit {

  proyecto:Proyecto = new Proyecto();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar(this.proyecto);
  }

  Editar(proyecto:Proyecto){
    let id = localStorage.getItem("id");
    this.service.getProyectoId(+id)
    .subscribe(data=>{
      this.proyecto = data;
    })
  }

  Actualizar(proyecto:Proyecto){
    this.service.updateProyecto(proyecto.id, proyecto)
    .subscribe(data=>{
      this.proyecto=data;
      alert("Se ha actualizado los datos, cabezah");
      this.router.navigate(["proyectos"]);
    })
  }

}
