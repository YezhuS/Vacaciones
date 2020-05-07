import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearProyectoComponent } from './crearProyectos.component';

describe('ProyectoComponent', () => {
  let component: CrearProyectoComponent;
  let fixture: ComponentFixture<CrearProyectoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearProyectoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearProyectoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
