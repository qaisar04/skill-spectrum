import {Component, EventEmitter, Output} from '@angular/core'
import {MatButton} from '@angular/material/button'
import {MatDatepicker, MatDatepickerInput} from '@angular/material/datepicker'
import {
  FormBuilder,
  FormControl,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms'
import {MatFormField} from '@angular/material/form-field'
import {MatOption, MatSelect} from '@angular/material/select'

@Component({
  selector: 'app-task-submission-ui',
  standalone: true,
  imports: [
    MatButton,
    MatDatepicker,
    ReactiveFormsModule,
    MatFormField,
    MatSelect,
    MatOption,
    MatDatepickerInput,
  ],
  templateUrl: './task-submission-ui.component.html',
  styleUrl: './task-submission-ui.component.scss',
})
export class TaskSubmissionUiComponent {
  @Output() submit = new EventEmitter()
  public formGroup = new FormBuilder().group({
    link: new FormControl('', [Validators.required]),
  })

  onCreateSubmission() {
    this.submit.emit(this.formGroup.value.link)
  }
}
