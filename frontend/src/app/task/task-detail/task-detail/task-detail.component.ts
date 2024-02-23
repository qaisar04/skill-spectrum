import {ChangeDetectionStrategy, Component, Input} from '@angular/core'
import {Task} from '../../data-access/models/tasks.model'
import {Observable} from 'rxjs'
import {AsyncPipe, NgIf} from '@angular/common'

@Component({
  selector: 'app-task-detail',
  standalone: true,
  imports: [NgIf, AsyncPipe],
  templateUrl: './task-detail.component.html',
  styleUrl: './task-detail.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TaskDetailComponent {
  @Input() task$!: Observable<Task | undefined | null>
}
