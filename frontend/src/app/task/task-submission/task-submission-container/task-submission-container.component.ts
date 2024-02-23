import {Component} from '@angular/core'
import {TaskSubmissionUiComponent} from '../task-submission-ui/task-submission-ui.component'

@Component({
  selector: 'app-task-submission-container',
  standalone: true,
  imports: [TaskSubmissionUiComponent],
  templateUrl: './task-submission-container.component.html',
  styleUrl: './task-submission-container.component.scss',
})
export class TaskSubmissionContainerComponent {
  onSubmit(link: string) {}
}
