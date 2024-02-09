import {Component} from '@angular/core';
import {PessoaService} from "../services/pessoa.service";
import {Pessoa} from "../model/Pessoa";
import {Observable} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-pessoas',
  templateUrl: './pessoas.component.html',
  styleUrl: './pessoas.component.scss'
})
export class PessoasComponent {
  pessoas$: Observable<Pessoa[]> | null = null;

  constructor(
    private pessoaService: PessoaService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.refresh();
  }

  refresh() {
    this.pessoas$ = this.pessoaService.getAll()
  }

  onRemove(pessoa: Pessoa) {
    this.pessoaService.deleteById(pessoa.id).subscribe(
      () => {
        this.refresh();
      }
    );
  }

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route});
    this.refresh();
  }

  onEdit(pessoa: Pessoa) {
    this.router.navigate(['edit', pessoa.id], {relativeTo: this.route})
    this.refresh();
  }
}
