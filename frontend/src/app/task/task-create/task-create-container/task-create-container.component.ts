import {ChangeDetectionStrategy, Component, inject} from '@angular/core'
import {TaskCreateUiComponent} from '../task-create-ui/task-create-ui.component'
import {TaskFacade} from '../../data-access/task.facade'
import {CreateTask} from '../../data-access/models/tasks.model'

@Component({
  selector: 'app-task-create-container',
  standalone: true,
  imports: [TaskCreateUiComponent],
  templateUrl: './task-create-container.component.html',
  styleUrl: './task-create-container.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TaskCreateContainerComponent {
  private readonly taskFacade = inject(TaskFacade)

  onCreateTask(task: CreateTask) {
    this.taskFacade.createTask(task)
  }
}
