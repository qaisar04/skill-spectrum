import {createFeature, createReducer, on} from '@ngrx/store'
import {User} from '../models/user.model'
import {LoadingStatus} from '../../../core/data-access/loading-status.type'
import {profileActions} from './profile.actions'

export const profileFeatureKey = 'profile'

export interface ProfileState {
  userStatus: LoadingStatus
  user: User | null | undefined
}

export const profileInitialState: ProfileState = {
  userStatus: 'init',
  user: null,
}

export const profileFeature = createFeature({
  name: 'profile',
  reducer: createReducer(
    profileInitialState,
    on(profileActions.loadUserInfo, (state) => ({
      ...state,
      authStatus: 'loading' as const,
    })),
    on(profileActions.loadUserInfoSuccess, (state, action) => ({
      ...state,
      authStatus: 'loaded' as const,
      user: action.user,
    })),
    on(profileActions.loadUserInfoById, (state) => ({
      ...state,
      authStatus: 'loading' as const,
    })),
    on(profileActions.loadUserInfoByIdSuccess, (state, action) => ({
      ...state,
      authStatus: 'loaded' as const,
      user: action.user,
    })),
  ),
})
