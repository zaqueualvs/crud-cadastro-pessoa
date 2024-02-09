import {Injectable} from '@angular/core';
import {Pessoa} from "../model/Pessoa";
import {HttpClient} from "@angular/common/http";
import {first, Observable, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PessoaService {
  private apiUrl = '/api/pessoas'

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>(this.apiUrl)
      .pipe(
        first(),
        tap(pessoas => console.log(pessoas))
      )
  }

  getById(id: string) {
    return this.http.get<Pessoa>(`${this.apiUrl}/${id}`);
  }

  save(pessoa: Partial<Pessoa>) {
    console.log(pessoa)
    if (pessoa.id) {
      return this.update(pessoa);
    }
    return this.create(pessoa);
  }

  private update(pessoa: Partial<Pessoa>) {
    console.log(pessoa)
    return this.http.put<Pessoa>(this.apiUrl, pessoa)
  }

  private create(pessoa: Partial<Pessoa>) {
    return this.http.post<Pessoa>(this.apiUrl, pessoa)
  }

  deleteById(id: string) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
