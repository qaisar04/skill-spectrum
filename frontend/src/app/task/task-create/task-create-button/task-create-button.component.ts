import {ChangeDetectionStrategy, Component} from '@angular/core';

@Component({
  selector: 'app-task-create-button',
  standalone: true,
  imports: [],
  templateUrl: './task-create-button.component.html',
  styleUrl: './task-create-button.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TaskCreateButtonComponent {

}
