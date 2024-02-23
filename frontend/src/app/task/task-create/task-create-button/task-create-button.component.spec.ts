import {ComponentFixture, TestBed} from '@angular/core/testing'

import {TaskCreateButtonComponent} from './task-create-button.component'

describe('TaskCreateButtonComponent', () => {
  let component: TaskCreateButtonComponent
  let fixture: ComponentFixture<TaskCreateButtonComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskCreateButtonComponent],
    }).compileComponents()

    fixture = TestBed.createComponent(TaskCreateButtonComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})
