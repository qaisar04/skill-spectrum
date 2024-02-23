import {ChangeDetectionStrategy, Component} from '@angular/core'
import {RouterOutlet} from '@angular/router'
import {HeaderComponent} from './core/layout/header/header.component'
import {FooterComponent} from './core/layout/footer/footer.component'
import {TasksContainerComponent} from './task/tasks/tasks-container/tasks-container.component'
import {TaskCreateButtonComponent} from './task/task-create/task-create-button/task-create-button.component'
import {TaskDetailContainerComponent} from './task/task-detail/task-detail-container/task-detail-container.component'
import {InvitationContainerComponent} from './invitation/invitation-container/invitation-container.component'

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HeaderComponent,
    FooterComponent,
    TasksContainerComponent,
    TaskCreateButtonComponent,
    TaskDetailContainerComponent,
    InvitationContainerComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AppComponent {
  title = 'skill-spectrum'
}
