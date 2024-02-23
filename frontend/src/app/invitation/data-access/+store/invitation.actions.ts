import {createActionGroup, emptyProps, props} from '@ngrx/store'

export const invitationActions = createActionGroup({
  source: 'Invitation',
  events: {
    getInvitationCode: props<{role: string}>(),
    getInvitationCodeSuccess: emptyProps(),
  },
})
