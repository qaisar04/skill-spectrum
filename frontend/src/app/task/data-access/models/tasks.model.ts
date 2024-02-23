export interface Task {
  id: number
  title: string
  description: string
  assignedDeveloperId: number
  deadline: Date
  createdAt: Date
  status: 'IN_PROGRESS' | 'DONE'
}

export interface TaskList extends Array<Task> {}

export interface CreateTask {
  title: string
  description: string
  assignedDeveloperId: number
  deadline: Date
  status: 'IN_PROGRESS' | 'DONE'
}
