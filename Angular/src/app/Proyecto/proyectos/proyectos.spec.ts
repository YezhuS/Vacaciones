import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProyectoComponent } from './proyectos.component';

describe('ProyectoComponent', () => {
  let component: ProyectoComponent;
  let fixture: ComponentFixture<ProyectoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProyectoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProyectoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
