import {ChangeDetectionStrategy, Component} from '@angular/core';

@Component({
  selector: 'app-task-create-container',
  standalone: true,
  imports: [],
  templateUrl: './task-create-container.component.html',
  styleUrl: './task-create-container.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TaskCreateContainerComponent {

}
