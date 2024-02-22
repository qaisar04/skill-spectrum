import { createActionGroup, emptyProps, props } from '@ngrx/store';
import {TaskList} from "../models/tasks.model";

export const taskActions = createActionGroup({
  source: 'Task',
  events: {
    loadAllTasks: emptyProps(),
    loadAllTasksSuccess: props<{tasks: TaskList[]}>()
  }
});


