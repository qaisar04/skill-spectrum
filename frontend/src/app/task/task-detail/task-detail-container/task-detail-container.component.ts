import {ChangeDetectionStrategy, Component, inject, OnInit} from '@angular/core'
import {TaskDetailComponent} from '../task-detail/task-detail.component'
import {ActivatedRoute, Router} from '@angular/router'
import {TaskFacade} from '../../data-access/task.facade'
import {TaskCreateButtonComponent} from '../../task-create/task-create-button/task-create-button.component'
import {TasksComponent} from '../../tasks/tasks/tasks.component'
import {TaskSubmissionButtonComponent} from '../../task-submission/task-submission-button/task-submission-button.component'

@Component({
  selector: 'app-task-detail-container',
  standalone: true,
  imports: [
    TaskDetailComponent,
    TaskCreateButtonComponent,
    TasksComponent,
    TaskSubmissionButtonComponent,
  ],
  templateUrl: './task-detail-container.component.html',
  styleUrl: './task-detail-container.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TaskDetailContainerComponent implements OnInit {
  taskId!: string
  private readonly route = inject(ActivatedRoute)
  private readonly router = inject(Router)

  private readonly taskFacade = inject(TaskFacade)
  public task = this.taskFacade.task$

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.taskId = params['id']
      this.taskFacade.loadTaskDetail(parseInt(this.taskId))
    })
  }

  back() {
    this.router.navigate(['/tasks'])
  }
}
