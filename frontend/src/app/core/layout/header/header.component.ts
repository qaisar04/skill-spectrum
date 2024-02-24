import {ChangeDetectionStrategy, Component, inject} from '@angular/core'
import {RouterLink} from '@angular/router'
import {AuthFacade} from '../../auth/data-access/auth.facade'
import {MatButton} from '@angular/material/button'
import {PushPipe} from '@ngrx/component'
import {NgIf} from '@angular/common'

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, MatButton, PushPipe, NgIf],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class HeaderComponent {
  private readonly authFacade = inject(AuthFacade)
  public readonly isAuthenticated$ = this.authFacade.isAuthenticated$

  logout() {
    this.authFacade.logout()
  }
}
