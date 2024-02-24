import {ChangeDetectionStrategy, Component, inject} from '@angular/core'
import {RegisterFormUiComponent} from '../register-form-ui/register-form-ui.component'
import {Router} from '@angular/router'
import {RegisterPayload} from '../../data-access/models/sign.model'
import {AuthFacade} from '../../data-access/auth.facade'

@Component({
  selector: 'app-register-container',
  standalone: true,
  imports: [RegisterFormUiComponent],
  templateUrl: './register-container.component.html',
  styleUrl: './register-container.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class RegisterContainerComponent {
  private readonly router = inject(Router)
  private readonly authFacade = inject(AuthFacade)

  onRedirectToSignIn() {
    this.router.navigate(['/login'])
  }

  onRegister(req: RegisterPayload) {
    this.authFacade.onRegister(req)
  }
}
