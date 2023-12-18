import {Routes} from '@angular/router';
import { USER_PAGE_ROUTES } from './user/routes';
import {APPROACH_PAGE_ROUTES} from "@base/pages/approach/routes";
import { CAMPAIGN_PAGE_ROUTES } from './campaign/routes';


export const dashboardRoutes: Routes = [
  {
    path: 'inicio',
    loadChildren: () => import('./home-page/home-page.module').then(m => m.HomePageModule),
  },
  {
    path: 'usuarios',
    data: {
      //requireAccess: 'RUser'
    },
    children: USER_PAGE_ROUTES,
  },
  {
    path: 'campanas',
    data: {
      //requireAccess: 'RUser'
    },
    children: CAMPAIGN_PAGE_ROUTES,
  },
  {
    path: 'propuestas',
    data: {
      //requireAccess: 'RUser'
    },
    children: APPROACH_PAGE_ROUTES,
  }
];
