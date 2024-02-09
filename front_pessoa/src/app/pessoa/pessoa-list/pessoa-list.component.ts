import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Pessoa} from "../model/Pessoa";
import {PessoaService} from "../services/pessoa.service";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrl: './pessoa-list.component.scss'
})
export class PessoaListComponent {
  @Input() pessoas: Pessoa[] = [];
  @Output() delete = new EventEmitter(false);
  @Output() add = new EventEmitter(false);
  @Output() filtro = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  displayedColumns: string[] = ['id', 'nome', 'idade', 'actions'];

  constructor() {
  }

  onDelete(pessoa: Pessoa) {
    this.delete.emit(pessoa);
  }

  onAdd() {
    this.add.emit(true);
  }

  onEdit(pessoa:Pessoa){
    this.edit.emit(pessoa);
  }

}
