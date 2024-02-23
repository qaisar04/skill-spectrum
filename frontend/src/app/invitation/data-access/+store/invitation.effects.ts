import {inject, Injectable} from '@angular/core'
import {Actions, createEffect, ofType} from '@ngrx/effects'
import {ApiService} from '../../../core/http/api.service'
import {map, switchMap} from 'rxjs'
import {invitationActions} from './invitation.actions'

@Injectable({providedIn: 'root'})
export class InvitationEffects {
  getInvitationCodeEffect$ = createEffect(
    (api = inject(ApiService), actions$ = inject(Actions)) =>
      actions$.pipe(
        ofType(invitationActions.getInvitationCode),
        switchMap((req) =>
          api.get<string>('/invite-code/' + req.role).pipe(
            map((code) => {
              console.log(code)
              return invitationActions.getInvitationCodeSuccess()
            }),
          ),
        ),
      ),
    {functional: true},
  )
}
