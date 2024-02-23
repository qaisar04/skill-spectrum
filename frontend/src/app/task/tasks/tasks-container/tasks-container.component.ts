import {ChangeDetectionStrategy, Component, inject, OnInit} from '@angular/core'
import {TasksComponent} from '../tasks/tasks.component'
import {TaskFacade} from '../../data-access/task.facade'
import {AsyncPipe, NgIf} from '@angular/common'
import {TaskCreateButtonComponent} from '../../task-create/task-create-button/task-create-button.component'
import {Observable} from 'rxjs'
import {TaskList} from '../../data-access/models/tasks.model'

@Component({
  selector: 'app-tasks-container',
  standalone: true,
  imports: [TasksComponent, AsyncPipe, TaskCreateButtonComponent, NgIf],
  templateUrl: './tasks-container.component.html',
  styleUrl: './tasks-container.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TasksContainerComponent implements OnInit {
  private readonly taskFacade = inject(TaskFacade)
  public tasks$?: Observable<TaskList | null | undefined> =
    this.taskFacade.tasks$

  ngOnInit() {
    this.taskFacade.loadTasks()
  }
}
