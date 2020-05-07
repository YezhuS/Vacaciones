import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Proyecto } from 'src/app/Modelo/Proyecto';

@Component({
  selector: 'app-crearProyectos',
  templateUrl: './crearProyectos.component.html',
  styleUrls: ['./crearProyectos.component.css']
})
export class CrearProyectoComponent implements OnInit {

  proyecto:Proyecto = new Proyecto();

  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit() {
  }

  Guardar(proyecto:Proyecto){
    this.service.createProyecto(proyecto)
    .subscribe(data=>{
      alert("Se ha creado un nuevo Proyecto");
      this.router.navigate(["proyectos"]);
      console.log(data);
    })
  }

}
