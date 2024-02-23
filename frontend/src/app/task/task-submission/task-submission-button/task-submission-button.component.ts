import {Component, inject} from '@angular/core'
import {MatFabButton} from '@angular/material/button'
import {MatIcon} from '@angular/material/icon'
import {Router} from '@angular/router'

@Component({
  selector: 'app-task-submission-button',
  standalone: true,
  imports: [MatFabButton, MatIcon],
  templateUrl: './task-submission-button.component.html',
  styleUrl: './task-submission-button.component.scss',
})
export class TaskSubmissionButtonComponent {
  private readonly router = inject(Router)

  open() {
    this.router.navigate(['/task'])
  }
}
