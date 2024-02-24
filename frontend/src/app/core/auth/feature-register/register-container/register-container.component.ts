import {Component, inject} from '@angular/core';
import {RegisterFormUiComponent} from "../register-form-ui/register-form-ui.component";
import {Router} from "@angular/router";
import {Store} from "@ngrx/store";
import {authActions} from "../../data-access/+state/auth.actions";
import {RegisterPayload} from "../../data-access/models/sign.model";

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
  private readonly store = inject(Store)

  onRedirectToSignIn() {
    this.router.navigate(['/login'])
  }
  onRegister(req: RegisterPayload) {
    console.log('works')
    this.store.dispatch(authActions.register({req}))
  }
}
