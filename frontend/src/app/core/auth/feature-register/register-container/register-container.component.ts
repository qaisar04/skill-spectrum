import {Component, inject} from '@angular/core';
import {RegisterFormUiComponent} from "../register-form-ui/register-form-ui.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register-container',
  standalone: true,
  imports: [
    RegisterFormUiComponent
  ],
  templateUrl: './register-container.component.html',
  styleUrl: './register-container.component.scss'
})
export class RegisterContainerComponent {
  private readonly router = inject(Router)

  onRedirectToSignIn() {
    this.router.navigate(['/login'])
  }
}
