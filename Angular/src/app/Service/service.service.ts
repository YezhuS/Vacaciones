import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Persona } from 'src/app/Modelo/Persona';
import { Proyecto } from 'src/app/Modelo/Proyecto';
import { Empleado } from 'src/app/Modelo/Empleado';
import { Ausencia } from 'src/app/Modelo/Ausencia';
import { Skill } from 'src/app/Modelo/Skill';


@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  constructor(private http:HttpClient) { }


  //Personas

  Url='http://localhost:8080/api/customers';

  getPersonas(){
    return this.http.get<Persona[]>(this.Url);
  }
  createPersona(persona:Persona){
    return this.http.post<Persona>(`${this.Url}` + `/create`, persona);
  }
  getPersonaId(id:number){
    return this.http.get<Persona>(`${this.Url}/${id}`);
  }
  updatePersona(id:number, persona:Persona){
    return this.http.put<Persona>(`${this.Url}/${id}`, persona);
  }
  deletePersona(id:number){
    return this.http.delete<Persona>(`${this.Url}/${id}`);
  }
  deleteAll(){
    return this.http.delete<Persona>(`${this.Url}` + `/delete`);
  }


  //Proyectos

  UrlProyecto='http://localhost:8080/api/projects';

  getProyectos(){
    return this.http.get<Proyecto[]>(this.UrlProyecto);
  }
  createProyecto(Proyecto:Proyecto){
    return this.http.post<Proyecto>(`${this.UrlProyecto}`, Proyecto);
  }
  getProyectoId(id:number){
    return this.http.get<Proyecto>(`${this.UrlProyecto}/${id}`);
  }
  updateProyecto(id:number, Proyecto:Proyecto){
    return this.http.put<Proyecto>(`${this.UrlProyecto}/${id}`, Proyecto);
  }
  deleteProyecto(id:number){
    return this.http.delete<Proyecto>(`${this.UrlProyecto}/${id}`);
  }
  deleteAllProjects(){
    return this.http.delete<Proyecto>(`${this.UrlProyecto}`);
  }


  //Empleados

  UrlEmpleado = 'http://localhost:8080/api/employees';

  getEmpleados(){
    return this.http.get<Empleado[]>(`${this.UrlEmpleado}`)
  }
  getEmpleadoId(id:number){
    return this.http.get<Empleado>(`${this.UrlEmpleado}/${id}`)
  }
  createEmpleado(empleado:Empleado){
    return this.http.post<Empleado>(`${this.UrlEmpleado}`, empleado)
  }
  updateEmpleado(id:number, empleado:Empleado){
    return this.http.put<Empleado>(`${this.UrlEmpleado}/${id}`, empleado)
  }
  deleteEmpleado(id:number){
    return this.http.delete<Empleado>(`${this.UrlEmpleado}/${id}`)
  }
  deleteAllEmpleados(){
    return this.http.delete<Empleado>(`${this.UrlEmpleado}`)
  }



  //Ausencias

  UrlAusencia = 'http://localhost:8080/api/absences';

  getAusencias(){
    return this.http.get<Ausencia[]>(`${this.UrlAusencia}`)
  }
  getAusenciaId(id:number){
    return this.http.get<Ausencia>(`${this.UrlAusencia}/${id}`)
  }
  createAusencia(Ausencia:Ausencia){
    return this.http.post<Ausencia>(`${this.UrlAusencia}`, Ausencia)
  }
  updateAusencia(id:number, Ausencia:Ausencia){
    return this.http.put<Ausencia>(`${this.UrlAusencia}/${id}`, Ausencia)
  }
  deleteAusencia(id:number){
    return this.http.delete<Ausencia>(`${this.UrlAusencia}/${id}`)
  }
  deleteAllAusencias(){
    return this.http.delete<Ausencia>(`${this.UrlAusencia}`)
  }


  //Skills

  UrlSkill = 'http://localhost:8080/api/skills';

  getSkills(){
    return this.http.get<Skill[]>(`${this.UrlSkill}`)
  }
  getSkillId(id:number){
    return this.http.get<Skill>(`${this.UrlSkill}/${id}`)
  }
  createSkill(Skill:Skill){
    return this.http.post<Skill>(`${this.UrlSkill}`, Skill)
  }
  updateSkill(id:number, Skill:Skill){
    return this.http.put<Skill>(`${this.UrlSkill}/${id}`, Skill)
  }
  deleteSkill(id:number){
    return this.http.delete<Skill>(`${this.UrlSkill}/${id}`)
  }
  deleteAllSkills(){
    return this.http.delete<Skill>(`${this.UrlSkill}`)
  }


  //HandleError

  private handleError(errorResponse: HttpErrorResponse){
    if(errorResponse.error instanceof ErrorEvent){
      console.error('Client Side Error: ', errorResponse.error.message);
    }else{
      console.error('Server Side Error: ', errorResponse);
    }

    return new Error('Problema acá');
  }



  private extractData(res: Response) {
    let body = res.json();
    // return just the response, or an empty array if there's no data
    return body || []; 
  }
}
