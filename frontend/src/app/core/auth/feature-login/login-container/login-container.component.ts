import {ChangeDetectionStrategy, Component, inject} from '@angular/core'
import {LoginFormUiComponent} from '../login-form-ui/login-form-ui.component'
import {Router} from '@angular/router'
import {AuthFacade} from '../../data-access/auth.facade'
import {LoginPayload} from '../../data-access/models/sign.model'

@Component({
  selector: 'app-login-container',
  standalone: true,
  imports: [LoginFormUiComponent],
  templateUrl: './login-container.component.html',
  styleUrl: './login-container.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class LoginContainerComponent {
  private readonly router = inject(Router)
  private readonly authFacade = inject(AuthFacade)

  onRedirectToSignUp() {
    this.router.navigate(['/register'])
  }

  onLogin(req: LoginPayload) {
    this.authFacade.onLogin(req)
  }
}
