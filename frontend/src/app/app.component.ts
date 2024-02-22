import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from "./core/layout/header/header.component";
import {FooterComponent} from "./core/layout/footer/footer.component";
import {TasksContainerComponent} from "./task/tasks/tasks-container/tasks-container.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FooterComponent, TasksContainerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'skill-spectrum';
}
