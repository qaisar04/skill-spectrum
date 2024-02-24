import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Output,
} from '@angular/core'
import {
  FormBuilder,
  FormControl,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms'
import {MatInputModule} from '@angular/material/input'
import {MatIconModule} from '@angular/material/icon'
import {MatFormFieldModule} from '@angular/material/form-field'
import {MatButtonModule} from '@angular/material/button'

@Component({
  selector: 'app-login-form-ui',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
  ],
  templateUrl: './login-form-ui.component.html',
  styleUrl: './login-form-ui.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class LoginFormUiComponent {
  public hide = true
  @Output() redirectToSignUp = new EventEmitter()
  @Output() login = new EventEmitter()

  public formGroup = new FormBuilder().group({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.min(6)]),
  })

  onLogin() {
    const userData = {
      username: this.formGroup.value.username,
      password: this.formGroup.value.password,
    }
    this.login.emit(userData)
  }

  onRedirectToSignUp() {
    this.redirectToSignUp.emit()
  }
}
