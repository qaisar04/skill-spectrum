import { createActionGroup, emptyProps, props } from '@ngrx/store';
import {RegisterPayload} from "../models/sign.model";

export const authActions = createActionGroup({
  source: 'Auth',
  events: {
    registerSuccess: emptyProps(),
    loginSuccess: emptyProps(),

    register: props<{req: RegisterPayload}>(),
    login: emptyProps(),
    logout: emptyProps(),

    registerFailure: emptyProps(),
    loginFailure: emptyProps()
  }
});


