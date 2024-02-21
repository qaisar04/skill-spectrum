import {Component, inject} from '@angular/core';
import {LoginFormUiComponent} from "../login-form-ui/login-form-ui.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-container',
  standalone: true,
  imports: [
    LoginFormUiComponent
  ],
  templateUrl: './login-container.component.html',
  styleUrl: './login-container.component.scss'
})
export class LoginContainerComponent {
  private readonly router = inject(Router)

  onRedirectToSignUp() {
    this.router.navigate(['/register'])
  }
}
