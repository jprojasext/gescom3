import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IprEditPageComponent } from './ipr-edit-page.component';

const routes: Routes = [{
  path: '',
  component: IprEditPageComponent,
  title: 'pages.campaign.ipr',
  data: { },
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ResultadosRoutingModule {
}
