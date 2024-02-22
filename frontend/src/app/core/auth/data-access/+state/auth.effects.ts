import {inject, Injectable} from "@angular/core";
import {ApiService} from "../../../http/api.service";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {authActions} from "./auth.actions";
import {catchError, map, of, switchMap} from "rxjs";
import {RegisterPayload} from "../models/sign.model";

@Injectable({providedIn: 'root'})

export class AuthEffects {
  registerEffect$ = createEffect(
    (api = inject(ApiService), actions$ = inject(Actions)) => actions$.pipe(
      ofType(authActions.register),
      switchMap(({ req }) => {
        return api.post<any, RegisterPayload>('/api/auth/register', req)
          .pipe(
            map(() => {
              console.log('register successful')
              return authActions.registerSuccess()
            }),
            catchError((errorRes) => {
              console.log('register failure')
              return of(authActions.registerFailure())
            })
          )
      })
    ), {functional: true, dispatch: true}
  )
}
