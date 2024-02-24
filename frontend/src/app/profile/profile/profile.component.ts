import {ChangeDetectionStrategy, Component, inject, OnInit} from '@angular/core'
import {select, Store} from '@ngrx/store'
import {AsyncPipe, NgIf} from '@angular/common'
import {selectUser} from '../data-access/+state/profile.selectors'
import {profileActions} from '../data-access/+state/profile.actions'
import {LocalStorageJwtService} from '../../core/auth/data-access/services/local-storage-jwt.service'

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [AsyncPipe, NgIf],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileComponent implements OnInit {
  private readonly store = inject(Store)
  public user = this.store.pipe(select(selectUser))
  private readonly localJwtService = inject(LocalStorageJwtService)

  ngOnInit() {
    const token = this.localJwtService.getItem() as string
    this.store.dispatch(profileActions.loadUserInfo({token}))
  }
}
