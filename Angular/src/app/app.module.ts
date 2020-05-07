import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';

//Personas
import { ListarComponent } from './Persona/listar/listar.component';
import { AddComponent } from './Persona/add/add.component';
import { EditComponent } from './Persona/edit/edit.component';

//Proyectos
import { ProyectoComponent } from './Proyecto/proyectos/proyectos.component';
import { CrearProyectoComponent } from './Proyecto/crearProyecto/crearProyectos.component';
import { EditarProyectoComponent } from './Proyecto/editar-proyecto/editar-proyecto.component';

//Empleados
import { EmpleadosComponent } from './Empleado/empleados/empleados.component';
import { CrearEmpleadoComponent } from './Empleado/crear-empleado/crear-empleado.component';
import { EditarEmpleadoComponent } from './Empleado/editar-empleado/editar-empleado.component';

//Ausencias
import { AusenciasComponent } from './Ausencia/ausencias/ausencias.component';
import { CrearAusenciaComponent } from './Ausencia/crear-ausencia/crear-ausencia.component';
import { EditarAusenciaComponent } from './Ausencia/editar-ausencia/editar-ausencia.component';

//Skill
import { SkillsComponent } from './Skill/skills/skills.component';
import { CrearSkillComponent } from './Skill/crear-skill/crear-skill.component';
import { EditarSkillComponent } from './Skill/editar-skill/editar-skill.component';

//Service
import { ServiceService } from '../app/Service/service.service';


@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    AddComponent,
    EditComponent,
    ProyectoComponent,
    CrearProyectoComponent,
    EditarProyectoComponent,
    AusenciasComponent,
    CrearAusenciaComponent,
    EditarAusenciaComponent,
    EmpleadosComponent,
    CrearEmpleadoComponent,
    EditarEmpleadoComponent,
    SkillsComponent,
    CrearSkillComponent,
    EditarSkillComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
