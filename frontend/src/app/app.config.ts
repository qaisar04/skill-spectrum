import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideStore } from '@ngrx/store';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {environment} from "../environments/environment.development";
import {API_URL} from "./core/http/api-url.token";

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideStore(),
    provideAnimationsAsync(),
    {
      provide: API_URL,
      useValue: environment.api_url,
    },
  ]
};
