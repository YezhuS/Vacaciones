import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/Modelo/Skill';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-editar-skill',
  templateUrl: './editar-skill.component.html',
  styleUrls: ['./editar-skill.component.css']
})
export class EditarSkillComponent implements OnInit {

  Skill:Skill = new Skill();

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar(this.Skill);
  }

  Editar(Skill:Skill){
    let id = localStorage.getItem("id");
    this.service.getSkillId(+id)
    .subscribe(data=>{
      this.Skill = data;
    })
  }

  Actualizar(Skill:Skill){
    this.service.updateSkill(Skill.id, Skill)
    .subscribe(data=>{
      this.Skill=data;
      alert("Se ha actualizado los datos, cabezah");
      this.router.navigate(["skills"]);
    })
  }
}
