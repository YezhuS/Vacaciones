import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/Modelo/Empleado';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { EmpleadosComponent } from '../empleados/empleados.component';

@Component({
  selector: 'app-crear-empleado',
  templateUrl: './crear-empleado.component.html',
  styleUrls: ['./crear-empleado.component.css']
})
export class CrearEmpleadoComponent implements OnInit {

  empleado:Empleado = new Empleado();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }

  Guardar(empleado:Empleado){
    this.service.createEmpleado(empleado)
    .subscribe(data=>{
      alert('Se agregó!');
      this.router.navigate(["empleados"]);
    })
  }

}
