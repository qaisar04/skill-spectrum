import {inject, Injectable} from '@angular/core'
import {select, Store} from '@ngrx/store'
import {authActions} from './+state/auth.actions'
import {LoginPayload, RegisterPayload} from './models/sign.model'
import {selectIsAuthenticated} from './+state/auth.selectors'

@Injectable({providedIn: 'root'})
export class AuthFacade {
  private readonly store = inject(Store)
  public isAuthenticated$ = this.store.pipe(select(selectIsAuthenticated))

  public onRegister(req: RegisterPayload) {
    this.store.dispatch(authActions.register({req}))
  }

  public onLogin(req: LoginPayload) {
    this.store.dispatch(authActions.login({req}))
  }

  public logout() {
    this.store.dispatch(authActions.logout())
  }
}
