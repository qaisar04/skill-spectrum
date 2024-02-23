import {inject, Injectable} from '@angular/core'
import {Actions, createEffect, ofType} from '@ngrx/effects'
import {ApiService} from '../../../core/http/api.service'
import {profileActions} from './profile.actions'
import {map, switchMap} from 'rxjs'
import {CurrentUser, User} from '../models/user.model'
import {Token} from '../../../core/auth/data-access/models/sign.model'

@Injectable({providedIn: 'root'})
export class ProfileEffects {
  getUserInfoEffect$ = createEffect(
    (api = inject(ApiService), actions$ = inject(Actions)) => {
      return actions$.pipe(
        ofType(profileActions.loadUserInfo),
        switchMap(({token}) =>
          api.post<CurrentUser, Token>('/auth/info', {token}).pipe(
            map((user) => {
              console.log(user)
              return profileActions.loadUserInfoSuccess({user})
            }),
          ),
        ),
      )
    },
    {functional: true},
  )
  getUserInfoByIdEffect$ = createEffect(
    (api = inject(ApiService), actions$ = inject(Actions)) => {
      return actions$.pipe(
        ofType(profileActions.loadUserInfoById),
        switchMap(({id}) =>
          api.get<User>('/dev/' + id.toString()).pipe(
            map((user) => {
              console.log(user)
              return profileActions.loadUserInfoByIdSuccess({user})
            }),
          ),
        ),
      )
    },
    {functional: true},
  )
}
