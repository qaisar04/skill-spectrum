import {ChangeDetectionStrategy, Component} from '@angular/core'
import {RouterOutlet} from '@angular/router'

@Component({
  selector: 'app-unauthorized-user-layout',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './unauthorized-user-layout.component.html',
  styleUrl: './unauthorized-user-layout.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class UnauthorizedUserLayoutComponent {}
