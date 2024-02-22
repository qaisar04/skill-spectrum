import {inject, Injectable} from "@angular/core"
import {Actions, createEffect, ofType} from "@ngrx/effects"
import {ApiService} from "../../../core/http/api.service";
import {map, switchMap} from "rxjs";
import {taskActions} from "./task.actions";
import {TaskList} from "../models/tasks.model";

@Injectable({providedIn: 'root'})

export class AuthEffects {
  loadAllTasksEffect$ = createEffect(
    (api = inject(ApiService), actions$ = inject(Actions)) => actions$.pipe(
      ofType(taskActions.loadAllTasks),
      switchMap(() => api.get<TaskList[]>('/task/all')
        .pipe(
          map((tasks) => {
            return taskActions.loadAllTasksSuccess({ tasks })
          })
        ))
    ), {functional: true}
  )
}
