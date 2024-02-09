import {ResolveFn} from '@angular/router';
import {PessoaService} from "../services/pessoa.service";
import {inject} from "@angular/core";
import {Pessoa} from "../model/Pessoa";
import {Observable, of} from "rxjs";

export const pessoaResolver: ResolveFn<Pessoa> =
  (route, state): Observable<Pessoa> => {
    if (route.params && route.params['id']) {
      return inject(PessoaService).getById(route.paramMap.get('id')!);
    }
    return of({id: '', nome: '', idade: ''});
  };
