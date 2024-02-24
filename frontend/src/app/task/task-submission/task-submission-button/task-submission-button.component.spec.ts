import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskSubmissionButtonComponent } from './task-submission-button.component';

describe('TaskSubmissionButtonComponent', () => {
  let component: TaskSubmissionButtonComponent;
  let fixture: ComponentFixture<TaskSubmissionButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskSubmissionButtonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskSubmissionButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
