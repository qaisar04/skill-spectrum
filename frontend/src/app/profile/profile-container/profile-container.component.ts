import {ChangeDetectionStrategy, Component} from '@angular/core'
import {ProfileComponent} from '../profile/profile.component'

@Component({
  selector: 'app-profile-container',
  standalone: true,
  imports: [ProfileComponent],
  templateUrl: './profile-container.component.html',
  styleUrl: './profile-container.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileContainerComponent {}
