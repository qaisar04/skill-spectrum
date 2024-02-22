export interface Task {
  title: string;
  description: string;
  assignedDeveloperId: number;
  deadline: Date;
  status: 'NEW' | 'IN_PROGRESS' | 'DONE';
}

export interface TaskList {
  tasks: Task[];
}
