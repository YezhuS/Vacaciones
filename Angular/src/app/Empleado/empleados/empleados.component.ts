import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/Modelo/Empleado';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent implements OnInit {

  empleado:Empleado[];
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.service.getEmpleados()
    .subscribe(data=>{
      this.empleado = data;
      console.log(data);
    })
  }

  Editar(empleado:Empleado):void{
    localStorage.setItem("id", empleado.id.toString());
    this.router.navigate(["editarEmpleados"]);
  }

  Eliminar(empleado:Empleado){
    this.service.deleteEmpleado(empleado.id)
    .subscribe();
    alert('Aió empleado');
    this.ngOnInit();
  }
  killThemAll(){
    this.service.deleteAll()
    .subscribe();
    alert('Aió empleados');
    this.ngOnInit();
  }
}
