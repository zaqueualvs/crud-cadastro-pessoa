import {Component, OnInit} from '@angular/core';
import {FormGroup, NonNullableFormBuilder, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {Pessoa} from "../model/Pessoa";
import {PessoaService} from "../services/pessoa.service";

@Component({
  selector: 'app-pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrl: './pessoa-form.component.scss'
})
export class PessoaFormComponent implements OnInit {
  form!: FormGroup;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location,
    private route: ActivatedRoute,
    private pessoaService: PessoaService
  ) {
  }

  ngOnInit() {
    const pessoa: Pessoa = this.route.snapshot.data['pessoa'];
    this.form = this.formBuilder.group({
      id:[pessoa.id],
      nome: [pessoa.nome, [Validators.required,
        Validators.minLength(4),
        Validators.pattern('[a-zA-Z]{3,20}')
      ]],
      idade: [pessoa.idade, [Validators.required, Validators.pattern('[0-9]{1,3}')]]
    });
  }

  onSave() {
    if (this.form.valid) {
      this.pessoaService.save(this.form.value)
        .subscribe(a => console.log(a)
        );
      this.onCancel();
    }
  }

  onCancel() {
    this.location.back();
  }
}
