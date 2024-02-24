import {inject, Injectable} from '@angular/core'
import {ApiService} from '../../../http/api.service'
import {Actions, createEffect, ofType} from '@ngrx/effects'
import {authActions} from './auth.actions'
import {catchError, map, of, switchMap, tap} from 'rxjs'
import {LoginPayload, RegisterPayload, Token} from '../models/sign.model'
import {LocalStorageJwtService} from '../services/local-storage-jwt.service'
import {Router} from '@angular/router'

@Injectable({providedIn: 'root'})
export class AuthEffects {
  registerEffect$ = createEffect(
    (api = inject(ApiService), actions$ = inject(Actions)) =>
      actions$.pipe(
        ofType(authActions.register),
        switchMap(({req}) => {
          return api.post<Token, RegisterPayload>('/auth/register', req).pipe(
            map((token) => {
              console.log('register successful')
              return authActions.authSuccess({token})
            }),
            catchError((errorRes) => {
              console.log('register failure')
              console.log(errorRes)
              return of(authActions.registerFailure())
            }),
          )
        }),
      ),
    {functional: true},
  )
  loginEffect$ = createEffect(
    (api = inject(ApiService), actions$ = inject(Actions)) =>
      actions$.pipe(
        ofType(authActions.login),
        switchMap(({req}) => {
          return api.post<Token, LoginPayload>('/auth/authenticate', req).pipe(
            map((token) => {
              console.log('login successful')
              return authActions.authSuccess({token})
            }),
            catchError((errorRes) => {
              console.log('login failure')
              console.log(errorRes)
              return of(authActions.loginFailure())
            }),
          )
        }),
      ),
    {functional: true},
  )
  authSuccessEffect$ = createEffect(
    (
      localStorageJWTService = inject(LocalStorageJwtService),
      router = inject(Router),
      actions$ = inject(Actions),
    ) => {
      return actions$.pipe(
        ofType(authActions.authSuccess),
        tap((action) => {
          console.log(action.token)
          localStorageJWTService.setItem(action.token.token)
          router.navigateByUrl('/tasks')
        }),
      )
    },
    {functional: true, dispatch: false},
  )
  logoutEffect$ = createEffect(
    (
      actions$ = inject(Actions),
      jwtService = inject(LocalStorageJwtService),
      router = inject(Router),
    ) =>
      actions$.pipe(
        ofType(authActions.logout),
        tap(() => {
          jwtService.removeItem()
          router.navigate(['/login'])
        }),
      ),
    {functional: true, dispatch: false},
  )
}
