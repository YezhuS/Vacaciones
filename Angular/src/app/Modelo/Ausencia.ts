import { Empleado } from './Empleado';

export class Ausencia{
    id:number;
    type:String;
    description:String;
    starDate:Date;
    endDate:Date;
    Empleado:Empleado;
}