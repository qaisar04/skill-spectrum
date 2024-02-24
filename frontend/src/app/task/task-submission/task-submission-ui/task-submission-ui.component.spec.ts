import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskSubmissionUiComponent } from './task-submission-ui.component';

describe('TaskSubmissionUiComponent', () => {
  let component: TaskSubmissionUiComponent;
  let fixture: ComponentFixture<TaskSubmissionUiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskSubmissionUiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskSubmissionUiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
