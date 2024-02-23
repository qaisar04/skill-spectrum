import {LoadingStatus} from '../../../core/data-access/loading-status.type'
import {createFeature, createReducer, on} from '@ngrx/store'
import {invitationActions} from './invitation.actions'

export const invitationFeatureKey = 'invitation'

export interface InvitationState {
  invStatus: LoadingStatus
}

export const invitationInitialState: InvitationState = {
  invStatus: 'init',
}

export const invitationFeature = createFeature({
  name: 'invitation',
  reducer: createReducer(
    invitationInitialState,
    on(invitationActions.getInvitationCode, (state) => ({
      ...state,
      taskStatus: 'loading' as const,
    })),
    on(invitationActions.getInvitationCodeSuccess, (state) => ({
      ...state,
      taskStatus: 'loaded' as const,
    })),
  ),
})
