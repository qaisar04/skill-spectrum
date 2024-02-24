import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  inject,
  Output,
} from '@angular/core'
import {MatButtonModule} from '@angular/material/button'
import {MatFormFieldModule} from '@angular/material/form-field'
import {MatIcon} from '@angular/material/icon'
import {
  FormBuilder,
  FormControl,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms'
import {MatInputModule} from '@angular/material/input'
import {MatOption, MatSelect} from '@angular/material/select'
import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerToggle,
} from '@angular/material/datepicker'
import {DateAdapter} from '@angular/material/core'

@Component({
  selector: 'app-task-create-ui',
  standalone: true,
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatIcon,
    MatInputModule,
    ReactiveFormsModule,
    MatSelect,
    MatOption,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatDatepicker,
  ],
  templateUrl: './task-create-ui.component.html',
  styleUrl: './task-create-ui.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TaskCreateUiComponent {
  minDate: Date
  maxDate: Date
  @Output() createTask = new EventEmitter()

  public formGroup = new FormBuilder().group({
    title: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    assignedDeveloperId: new FormControl('', [Validators.required]),
    deadline: new FormControl('', [Validators.required]),
    status: new FormControl('IN_PROGRESS', [Validators.required]),
  })
  private dateAdapter = inject(DateAdapter)

  constructor() {
    this.minDate = this.dateAdapter.today()
    this.maxDate = new Date(this.minDate.getFullYear(), 11, 31)
  }

  onCreateTask() {
    const data = {
      title: this.formGroup.value.title,
      description: this.formGroup.value.description,
      assignedDeveloperId: this.formGroup.value.assignedDeveloperId,
      deadline: this.formGroup.value.deadline,
      status: this.formGroup.value.status,
    }
    this.createTask.emit(data)
  }
}
