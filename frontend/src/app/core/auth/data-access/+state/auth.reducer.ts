import {LoadingStatus} from '../../../data-access/loading-status.type'
import {createFeature, createReducer, on} from '@ngrx/store'
import {authActions} from './auth.actions'

export const authFeatureKey = 'auth'

export interface AuthState {
  authStatus: LoadingStatus
  error: string | null
  authToken: string
}

export const authInitialState: AuthState = {
  authStatus: 'init',
  error: null,
  authToken: '',
}

export const authFeature = createFeature({
  name: 'auth',
  reducer: createReducer(
    authInitialState,
    on(authActions.login, (state) => ({
      ...state,
      authStatus: 'loading' as const,
    })),
    on(authActions.register, (state) => ({
      ...state,
      authStatus: 'loading' as const,
    })),
    on(authActions.logout, (state) => ({
      ...state,
      ...authInitialState,
    })),

    on(authActions.authSuccess, (state, action) => ({
      ...state,
      authStatus: 'loaded' as const,
      authToken: action.token.token,
    })),
  ),
})
