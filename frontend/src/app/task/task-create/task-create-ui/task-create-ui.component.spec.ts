import {ComponentFixture, TestBed} from '@angular/core/testing'

import {TaskCreateUiComponent} from './task-create-ui.component'

describe('TaskCreateUiComponent', () => {
  let component: TaskCreateUiComponent
  let fixture: ComponentFixture<TaskCreateUiComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskCreateUiComponent],
    }).compileComponents()

    fixture = TestBed.createComponent(TaskCreateUiComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})
