import {inject, Injectable} from '@angular/core'
import {select, Store} from '@ngrx/store'
import {
  selectTask,
  selectTasks,
  selectTaskStatus,
} from './+state/task.selectors'
import {taskActions} from './+state/task.actions'
import {CreateTask, TaskList} from './models/tasks.model'
import {filter, Observable} from 'rxjs'

@Injectable({providedIn: 'root'})
export class TaskFacade {
  private readonly store = inject(Store)
  public tasks$ = this.store.pipe(select(selectTasks))
  public taskStatus$ = this.store.pipe(select(selectTaskStatus))
  public task$ = this.store.pipe(select(selectTask))

  loadTasks() {
    this.store.dispatch(taskActions.loadAllTasks())
  }

  loadTaskDetail(id: number) {
    this.store.dispatch(taskActions.loadTaskDetail({id}))
  }

  createTask(task: CreateTask) {
    this.store.dispatch(taskActions.createTask({task}))
  }

  getTasksAfterLoad(): Observable<TaskList | null | undefined> {
    return this.tasks$.pipe(filter((tasks) => !!tasks))
  }
}
