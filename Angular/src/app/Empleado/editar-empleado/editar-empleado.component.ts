import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/Modelo/Empleado';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-editar-empleado',
  templateUrl: './editar-empleado.component.html',
  styleUrls: ['./editar-empleado.component.css']
})
export class EditarEmpleadoComponent implements OnInit {

  Empleado:Empleado = new Empleado();

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar(this.Empleado);
  }

  Editar(Empleado:Empleado){
    let id = localStorage.getItem("id");
    this.service.getEmpleadoId(+id)
    .subscribe(data=>{
      this.Empleado = data;
    })
  }

  Actualizar(Empleado:Empleado){
    this.service.updateEmpleado(Empleado.id, Empleado)
    .subscribe(data=>{
      this.Empleado=data;
      alert("Se ha actualizado los datos, cabezah");
      this.router.navigate(["empleados"]);
    })
  }

}
