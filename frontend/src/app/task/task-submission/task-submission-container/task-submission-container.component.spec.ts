import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskSubmissionContainerComponent } from './task-submission-container.component';

describe('TaskSubmissionContainerComponent', () => {
  let component: TaskSubmissionContainerComponent;
  let fixture: ComponentFixture<TaskSubmissionContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskSubmissionContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskSubmissionContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
