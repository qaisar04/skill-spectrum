import {TaskState} from "../+state/task.reducer";
import {createSelector} from "@ngrx/store";

export const selectFeature = (state: {task: TaskState}) => state.task

export const selectTasks = createSelector(
  selectFeature,
  (state: TaskState) => state.taskList
)
