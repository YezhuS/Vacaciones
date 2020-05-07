import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularSpringSQL';

  constructor(private router:Router){}

  Listar(){
    this.router.navigate(["listar"]);
  }
  Nuevo(){
    this.router.navigate(["add"]);
  }
  Proyectos(){
    this.router.navigate(["proyectos"]);
  }
  CrearProyectos(){
    this.router.navigate(["crearProyectos"]);
  }
  Ausencias(){
    this.router.navigate(["ausencias"]);
  }
  CrearAusencias(){
    this.router.navigate(["crearAusencias"]);
  }
  Empleados(){
    this.router.navigate(["empleados"]);
  }
  CrearEmpleados(){
    this.router.navigate(["crearEmpleados"]);
  }
  Skills(){
    this.router.navigate(["skills"]);
  }
  CrearSkills(){
    this.router.navigate(["crearSkills"]);
  }
}
