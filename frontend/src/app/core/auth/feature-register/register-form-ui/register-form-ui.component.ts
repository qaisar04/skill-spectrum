import {Component, EventEmitter, inject, Output} from '@angular/core';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {FormBuilder, FormControl, ReactiveFormsModule, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register-form-ui',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule
  ],
  templateUrl: './register-form-ui.component.html',
  styleUrl: './register-form-ui.component.scss'
})
export class RegisterFormUiComponent {
  public hide = true
  @Output() redirectToSignIn = new EventEmitter()

  public formGroup = new FormBuilder().group({
    name: new FormControl('', [Validators.required]),
    username: new FormControl('', [Validators.required]),
    email: new FormControl('', [
      Validators.required,
      Validators.email,
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.min(6),
    ]),
    confirmPassword: new FormControl('', [
      Validators.required,
      Validators.min(6),
    ]),
  })
  onRegister() {
    console.log(this.formGroup.getRawValue())
  }
  onRedirectToSignIn() {
    this.redirectToSignIn.emit()
  }
}
