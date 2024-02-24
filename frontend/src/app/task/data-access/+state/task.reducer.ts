import {LoadingStatus} from '../../../core/data-access/loading-status.type'
import {Task, TaskList} from '../models/tasks.model'
import {createFeature, createReducer, on} from '@ngrx/store'
import {taskActions} from './task.actions'

export const taskFeatureKey = 'task'

export interface TaskState {
  taskStatus: LoadingStatus
  error: string | null
  taskList: TaskList | undefined | null
  task: Task | undefined | null
}

export const taskInitialState: TaskState = {
  taskStatus: 'init',
  error: null,
  taskList: null,
  task: null,
}

export const taskFeature = createFeature({
  name: 'task',
  reducer: createReducer(
    taskInitialState,
    on(taskActions.loadAllTasks, (state) => ({
      ...state,
      taskStatus: 'loading' as const,
    })),
    on(taskActions.loadAllTasksSuccess, (state, action) => ({
      ...state,
      taskStatus: 'loaded' as const,
      taskList: action.tasks,
    })),

    on(taskActions.createTask, (state) => ({
      ...state,
      taskStatus: 'loading' as const,
    })),
    on(taskActions.createTaskSuccess, (state, action) => ({
      ...state,
      taskStatus: 'loaded' as const,
    })),

    on(taskActions.loadTaskDetail, (state) => ({
      ...state,
      taskStatus: 'loading' as const,
    })),
    on(taskActions.loadTaskDetailSuccess, (state, action) => ({
      ...state,
      taskStatus: 'loaded' as const,
      task: action.task,
    })),
  ),
})
