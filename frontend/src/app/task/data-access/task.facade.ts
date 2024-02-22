import {inject, Injectable} from "@angular/core";
import {select, Store} from "@ngrx/store";
import {selectTasks} from "./+state/task.selectors";
import {taskActions} from "./+state/task.actions";

@Injectable({providedIn: 'root'})
export class TaskFacade {
  private readonly store = inject(Store)
  public tasks$ = this.store.pipe(select(selectTasks))

  loadTasks() {
    this.store.dispatch(taskActions.loadAllTasks())
  }
}
