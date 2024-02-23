import {createActionGroup, emptyProps, props} from '@ngrx/store'
import {LoginPayload, RegisterPayload, Token} from '../models/sign.model'

export const authActions = createActionGroup({
  source: 'Auth',
  events: {
    authSuccess: props<{token: Token}>(),

    register: props<{req: RegisterPayload}>(),
    login: props<{req: LoginPayload}>(),
    logout: emptyProps(),

    registerFailure: emptyProps(),
    loginFailure: emptyProps(),
  },
})
