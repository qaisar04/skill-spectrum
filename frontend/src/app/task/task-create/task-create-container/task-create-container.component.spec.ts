import {ComponentFixture, TestBed} from '@angular/core/testing'

import {TaskCreateContainerComponent} from './task-create-container.component'

describe('TaskCreateContainerComponent', () => {
  let component: TaskCreateContainerComponent
  let fixture: ComponentFixture<TaskCreateContainerComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskCreateContainerComponent],
    }).compileComponents()

    fixture = TestBed.createComponent(TaskCreateContainerComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})
