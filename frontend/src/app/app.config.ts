import {ApplicationConfig, isDevMode} from '@angular/core'
import {provideRouter} from '@angular/router'

import {routes} from './app.routes'
import {provideStore} from '@ngrx/store'
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async'
import {environment} from '../environments/environment.development'
import {API_URL} from './core/http/api-url.token'
import {provideEffects} from '@ngrx/effects'
import {AuthEffects} from './core/auth/data-access/+state/auth.effects'
import {provideStoreDevtools} from '@ngrx/store-devtools'
import {authFeature} from './core/auth/data-access/+state/auth.reducer'
import {provideHttpClient, withInterceptors} from '@angular/common/http'
import {taskFeature} from './task/data-access/+state/task.reducer'
import {TaskEffects} from './task/data-access/+state/task.effects'
import {provideNativeDateAdapter} from '@angular/material/core'
import {tokenInterceptor} from './core/auth/data-access/services/token.interceptor'
import {invitationFeature} from './invitation/data-access/+store/invitation.reducer'
import {InvitationEffects} from './invitation/data-access/+store/invitation.effects'
import {profileFeature} from './profile/data-access/+state/profile.reducer'
import {ProfileEffects} from './profile/data-access/+state/profile.effects'

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideStore({
      [authFeature.name]: authFeature.reducer,
      [taskFeature.name]: taskFeature.reducer,
      [invitationFeature.name]: invitationFeature.reducer,
      [profileFeature.name]: profileFeature.reducer,
    }),
    provideHttpClient(withInterceptors([tokenInterceptor])),
    provideStoreDevtools({
      maxAge: 25,
      logOnly: !isDevMode(),
      autoPause: true,
      trace: false,
      traceLimit: 75, // maximum stack trace frames to be stored (in case trace option was provided as true)
    }),
    provideAnimationsAsync(),
    {
      provide: API_URL,
      useValue: environment.api_url,
    },
    provideEffects(AuthEffects, TaskEffects, InvitationEffects, ProfileEffects),
    provideNativeDateAdapter(),
  ],
}
