import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './Persona/listar/listar.component';
import { AddComponent } from './Persona/add/add.component';
import { EditComponent } from './Persona/edit/edit.component';
import { ProyectoComponent } from './Proyecto/proyectos/proyectos.component';
import { CrearProyectoComponent } from './Proyecto/crearProyecto/crearProyectos.component';
import { EditarProyectoComponent } from './Proyecto/editar-proyecto/editar-proyecto.component';
import { EmpleadosComponent } from './Empleado/empleados/empleados.component';
import { CrearEmpleadoComponent } from './Empleado/crear-empleado/crear-empleado.component';
import { EditarEmpleadoComponent } from './Empleado/editar-empleado/editar-empleado.component';
import { AusenciasComponent } from './Ausencia/ausencias/ausencias.component';
import { CrearAusenciaComponent } from './Ausencia/crear-ausencia/crear-ausencia.component';
import { EditarAusenciaComponent } from './Ausencia/editar-ausencia/editar-ausencia.component';
import { SkillsComponent } from './Skill/skills/skills.component';
import { CrearSkillComponent } from './Skill/crear-skill/crear-skill.component';
import { EditarSkillComponent } from './Skill/editar-skill/editar-skill.component';

const routes: Routes = [
  {path:'listar', component: ListarComponent},
  {path:'add', component: AddComponent},
  {path:'edit', component: EditComponent},
  {path:'proyectos', component:ProyectoComponent},
  {path:'crearProyectos', component:CrearProyectoComponent},
  {path:'editarProyectos', component:EditarProyectoComponent},
  {path:'empleados', component:EmpleadosComponent},
  {path:'crearEmpleados', component:CrearEmpleadoComponent},
  {path:'editarEmpleados', component:EditarEmpleadoComponent},
  {path:'ausencias', component:AusenciasComponent},
  {path:'crearAusencias', component:CrearAusenciaComponent},
  {path:'editarAusencias', component:EditarAusenciaComponent},
  {path:'skills', component:SkillsComponent},
  {path:'crearSkills', component:CrearSkillComponent},
  {path:'editarSkills', component:EditarSkillComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
