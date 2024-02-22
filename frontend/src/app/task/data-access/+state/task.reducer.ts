import {LoadingStatus} from "../../../core/data-access/loading-status.type";
import {TaskList} from "../models/tasks.model";
import {createFeature, createReducer, on} from "@ngrx/store";
import {taskActions} from "./task.actions";

export const taskFeatureKey = 'task';

export interface TaskState {
  taskStatus: LoadingStatus
  error: string | null
  taskList: TaskList[] | undefined | null
}

export const taskInitialState: TaskState = {
  taskStatus: 'init',
  error: null,
  taskList: null
}

export const taskFeature = createFeature({
  name: 'task',
  reducer: createReducer(
    taskInitialState,
    on(taskActions.loadAllTasks, (state) => ({
      ...state,
      taskStatus: 'loading' as const
    }))
  )
})
