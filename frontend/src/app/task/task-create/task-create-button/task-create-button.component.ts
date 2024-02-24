import {ChangeDetectionStrategy, Component, inject} from '@angular/core'
import {MatIcon} from '@angular/material/icon'
import {Router} from '@angular/router'
import {MatFabButton, MatIconButton} from '@angular/material/button'

@Component({
  selector: 'app-task-create-button',
  standalone: true,
  imports: [MatIcon, MatIconButton, MatFabButton],
  templateUrl: './task-create-button.component.html',
  styleUrl: './task-create-button.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TaskCreateButtonComponent {
  private readonly router = inject(Router)

  openCreateTask(): void {
    this.router.navigate(['/task-editor'], {
      queryParams: {mode: 'create'},
    })
  }
}
