import { Persona } from './Persona';
import { Skill } from './Skill';
import { Proyecto } from './Proyecto';

export class Empleado{
    id:number;
    hireDate:Date;
    Persona:Persona;
    Skill:Skill;
    Proyecto:Proyecto;
}