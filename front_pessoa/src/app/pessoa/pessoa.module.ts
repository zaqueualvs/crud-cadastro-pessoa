import {NgModule} from "@angular/core";
import {PessoaListComponent} from "./pessoa-list/pessoa-list.component";
import {PessoasComponent} from "./pessoas/pessoas.component";
import {PessoaFormComponent} from "./pessoa-form/pessoa-form.component";
import {PessoaRoutingModule} from "./pessoa-routing.module";
import {MatIconModule} from "@angular/material/icon";
import {MatTableModule} from "@angular/material/table";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatCardModule} from "@angular/material/card";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatButtonModule} from "@angular/material/button";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations :[
    PessoaListComponent,
    PessoasComponent,
    PessoaFormComponent
  ],
  imports: [
    PessoaRoutingModule,
    MatIconModule,
    MatTableModule,
    MatToolbarModule,
    MatCardModule,
    AsyncPipe,
    NgIf,
    MatButtonModule,
    MatProgressSpinnerModule,
    MatInputModule,
    ReactiveFormsModule
  ]
})
export class PessoaModule{

}
