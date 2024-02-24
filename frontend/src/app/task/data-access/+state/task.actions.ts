import {createActionGroup, emptyProps, props} from '@ngrx/store'
import {CreateTask, Task, TaskList} from '../models/tasks.model'

export const taskActions = createActionGroup({
  source: 'Task',
  events: {
    loadAllTasks: emptyProps(),
    loadAllTasksSuccess: props<{tasks: TaskList}>(),

    loadTaskDetail: props<{id: number}>(),
    loadTaskDetailSuccess: props<{task: Task}>(),

    createTask: props<{task: CreateTask}>(),
    createTaskSuccess: emptyProps(),
  },
})
