import {Component, inject, OnInit} from '@angular/core';
import {TasksComponent} from "../tasks/tasks.component";
import {TaskFacade} from "../../data-access/task.facade";
import {Store} from "@ngrx/store";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-tasks-container',
  standalone: true,
  imports: [
    TasksComponent,
    AsyncPipe
  ],
  templateUrl: './tasks-container.component.html',
  styleUrl: './tasks-container.component.scss'
})
export class TasksContainerComponent implements OnInit {
  private readonly taskFacade = inject(TaskFacade)
  public tasks$ = this.taskFacade.tasks$
  ngOnInit() {
    this.taskFacade.loadTasks()
  }
}
