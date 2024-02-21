import {ApplicationConfig, isDevMode} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideStore } from '@ngrx/store';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {environment} from "../environments/environment.development";
import {API_URL} from "./core/http/api-url.token";
import { provideEffects } from '@ngrx/effects';
import {AuthEffects} from "./core/auth/data-access/+state/auth.effects";
import {provideStoreDevtools} from "@ngrx/store-devtools";
import {authFeature} from "./core/auth/data-access/+state/auth.reducer";
import {provideHttpClient} from "@angular/common/http";

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideStore({
        [authFeature.name]: authFeature.reducer
      }
    ),
    provideHttpClient(),
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
    provideEffects(AuthEffects)
]
};
