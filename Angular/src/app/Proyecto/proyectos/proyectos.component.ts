import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Proyecto } from 'src/app/Modelo/Proyecto';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectoComponent implements OnInit {

  proyecto:Proyecto[];
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit() {
    this.service.getProyectos()
    .subscribe(data=>{
      this.proyecto=data;
      console.log(data);
    })
  }

  Editar(proyecto:Proyecto):void{
    localStorage.setItem("id", proyecto.id.toString());
    this.router.navigate(["editarProyectos"]);
  }

  Eliminar(proyecto:Proyecto){
    this.service.deleteProyecto(proyecto.id)
    .subscribe();
    alert('Aió Proyecto');
    this.ngOnInit();
  }
  killThemAll(){
    this.service.deleteAllProjects()
    .subscribe();
    alert('Aió Proyectos');
    this.ngOnInit();
  }
}
