import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearAusenciaComponent } from './crear-ausencia.component';

describe('CrearAusenciaComponent', () => {
  let component: CrearAusenciaComponent;
  let fixture: ComponentFixture<CrearAusenciaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearAusenciaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearAusenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
