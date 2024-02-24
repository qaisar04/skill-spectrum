import {TaskState} from '../+state/task.reducer'
import {createSelector} from '@ngrx/store'

export const selectFeature = (state: {task: TaskState}) => state.task

export const selectTaskStatus = createSelector(
  selectFeature,
  (state: TaskState) => state.taskStatus,
)
export const selectTasks = createSelector(
  selectFeature,
  (state: TaskState) => state.taskList,
)
export const selectTask = createSelector(
  selectFeature,
  (state: TaskState) => state.task,
)
