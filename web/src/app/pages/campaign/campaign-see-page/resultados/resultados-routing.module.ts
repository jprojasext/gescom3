import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResultadosComponent } from './resultados.component';

const routes: Routes = [{
  path: '',
  component: ResultadosComponent,
  title: 'pages.user.add',
  data: {breadcrumb: 'pages.results.title'}
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ResultadosRoutingModule {
}
