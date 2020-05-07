import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarSkillComponent } from './editar-skill.component';

describe('EditarSkillComponent', () => {
  let component: EditarSkillComponent;
  let fixture: ComponentFixture<EditarSkillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarSkillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarSkillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
