import { createActionGroup, emptyProps, props } from '@ngrx/store';

export const authActions = createActionGroup({
  source: 'Auth',
  events: {
    registerSuccess: emptyProps(),
    loginSuccess: emptyProps(),

    register: emptyProps(),
    login: emptyProps(),
    logout: emptyProps(),

    registerFailure: emptyProps(),
    loginFailure: emptyProps()
  }
});


