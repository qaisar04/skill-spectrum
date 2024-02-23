import {ChangeDetectionStrategy, Component, inject} from '@angular/core'
import {InvitationComponent} from '../invitation/invitation.component'
import {Store} from '@ngrx/store'
import {invitationActions} from '../data-access/+store/invitation.actions'

@Component({
  selector: 'app-invitation-container',
  standalone: true,
  imports: [InvitationComponent],
  templateUrl: './invitation-container.component.html',
  styleUrl: './invitation-container.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class InvitationContainerComponent {
  private readonly store = inject(Store)

  onGetInvitationCode(role: string) {
    this.store.dispatch(invitationActions.getInvitationCode({role}))
  }
}
