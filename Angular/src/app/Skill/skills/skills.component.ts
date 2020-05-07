import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/Modelo/Skill';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  Skill:Skill[];
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.service.getSkills()
    .subscribe(data=>{
      this.Skill = data;
      console.log(data);
    })
  }

  Editar(Skill:Skill):void{
    localStorage.setItem("id", Skill.id.toString());
    this.router.navigate(["editarSkills"]);
  }

  Eliminar(Skill:Skill){
    this.service.deleteSkill(Skill.id)
    .subscribe();
    alert('Aió Skill');
    this.ngOnInit();
  }
  killThemAll(){
    this.service.deleteAllSkills()
    .subscribe();
    alert('Aió skills');
    this.ngOnInit();
  }
}
