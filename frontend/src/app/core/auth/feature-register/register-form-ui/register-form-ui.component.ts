import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Output,
} from '@angular/core'
import {MatFormFieldModule} from '@angular/material/form-field'
import {MatButtonModule} from '@angular/material/button'
import {MatIconModule} from '@angular/material/icon'
import {MatInputModule} from '@angular/material/input'
import {
  FormBuilder,
  FormControl,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms'
import {RegisterPayload} from '../../data-access/models/sign.model'

@Component({
  selector: 'app-register-form-ui',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
  ],
  templateUrl: './register-form-ui.component.html',
  styleUrl: './register-form-ui.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class RegisterFormUiComponent {
  public hide = true
  @Output() redirectToSignIn = new EventEmitter()
  @Output() register = new EventEmitter()

  public formGroup = new FormBuilder().group({
    name: new FormControl('', [Validators.required]),
    username: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    inviteCode: new FormControl(''),
    password: new FormControl('', [Validators.required, Validators.min(6)]),
    confirmPassword: new FormControl('', [
      Validators.required,
      Validators.min(6),
    ]),
  })

  onRegister() {
    const userData: RegisterPayload = {
      name: this.formGroup.value.name as string,
      username: this.formGroup.value.username as string,
      password: this.formGroup.value.password as string,
      confirmPassword: this.formGroup.value.confirmPassword as string,
      inviteCode: this.formGroup.value.inviteCode as string,
      email: this.formGroup.value.email as string,
    }
    this.register.emit(userData)
  }

  onRedirectToSignIn() {
    this.redirectToSignIn.emit()
  }
}
