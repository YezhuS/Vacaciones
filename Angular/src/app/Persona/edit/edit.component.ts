import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/Modelo/Persona';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  persona:Persona = new Persona();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar(this.persona);
  }

  Editar(persona:Persona){
    let id = localStorage.getItem("id");
    this.service.getPersonaId(+id)
    .subscribe(data=>{
      this.persona = data;
    })
  }

  Actualizar(persona:Persona){
    this.service.updatePersona(persona.id, persona)
    .subscribe(data=>{
      this.persona=data;
      alert("Se ha actualizado los datos, cabezah");
      this.router.navigate(["listar"]);
    })
  }

}
