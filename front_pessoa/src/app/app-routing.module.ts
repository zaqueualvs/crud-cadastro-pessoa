import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: '', pathMatch: "full", redirectTo: 'pessoas'},
  { path: 'pessoas',
  loadChildren: ()=> import('./pessoa/pessoa.module').then(p => p.PessoaModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
