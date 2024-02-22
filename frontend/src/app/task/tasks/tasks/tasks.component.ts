import {AfterViewInit, ChangeDetectionStrategy, Component, Input, ViewChild} from '@angular/core';
import {MatTableDataSource, MatTableModule} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {TaskList} from "../../data-access/models/tasks.model";

@Component({
  selector: 'app-tasks',
  standalone: true,
  imports: [
    MatTableModule,
    MatPaginator,
  ],
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TasksComponent implements AfterViewInit {
  @Input() tasks: TaskList[] | undefined | null
  displayedColumns: string[] = ['title', 'description', 'assigned developer', 'deadline', 'status'];
  dataSource = new MatTableDataSource<TaskList>

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.data = this.tasks || [];
    this.dataSource.paginator = this.paginator;
  }
}

