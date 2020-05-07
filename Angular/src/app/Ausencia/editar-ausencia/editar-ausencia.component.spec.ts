import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarAusenciaComponent } from './editar-ausencia.component';

describe('EditarAusenciaComponent', () => {
  let component: EditarAusenciaComponent;
  let fixture: ComponentFixture<EditarAusenciaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarAusenciaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarAusenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
