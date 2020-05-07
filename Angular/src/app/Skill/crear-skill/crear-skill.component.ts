import { Component, OnInit } from '@angular/core';
import { SkillsComponent } from '../skills/skills.component';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Skill } from 'src/app/Modelo/Skill';

@Component({
  selector: 'app-crear-skill',
  templateUrl: './crear-skill.component.html',
  styleUrls: ['./crear-skill.component.css']
})
export class CrearSkillComponent implements OnInit {

  skill:Skill = new Skill();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }

  Guardar(skill:Skill){
    this.service.createSkill(skill)
    .subscribe(data=>{
      alert('Se agregó');
      this.router.navigate(["skills"]);
    })
  }

}
