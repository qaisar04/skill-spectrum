import {createActionGroup, props} from '@ngrx/store'
import {CurrentUser, User} from '../models/user.model'

export const profileActions = createActionGroup({
  source: 'Profile',
  events: {
    loadUserInfo: props<{token: string}>(),
    loadUserInfoSuccess: props<{user: CurrentUser}>(),

    loadUserInfoById: props<{id: number}>(),
    loadUserInfoByIdSuccess: props<{user: User}>(),
  },
})
