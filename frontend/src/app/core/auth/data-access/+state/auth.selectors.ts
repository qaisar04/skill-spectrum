import {AuthState} from './auth.reducer'
import {LoadingStatus} from '../../../data-access/loading-status.type'
import {createSelector} from '@ngrx/store'

export const selectFeature = (state: {auth: AuthState}) => state.auth

export const selectAuthStatus = createSelector(
  selectFeature,
  (state: AuthState) => state.authStatus,
)
export const selectIsAuthenticated = createSelector(
  selectAuthStatus,
  (loadingStatus: LoadingStatus) => loadingStatus === 'loaded',
)
