import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'login', loadComponent: () => import('./core/auth/feature-login/login-container/login-container.component').then((c) => c.LoginContainerComponent)},
  { path: 'register', loadComponent: () => import('./core/auth/feature-register/register-container/register-container.component').then((c) => c.RegisterContainerComponent)},
];
