import {createSelector} from '@ngrx/store'
import {ProfileState} from './profile.reducer'

export const selectFeature = (state: {profile: ProfileState}) => state.profile

export const selectUser = createSelector(
  selectFeature,
  (state: ProfileState) => state.user,
)
