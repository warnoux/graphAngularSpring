import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GraphService {

  private baseUrl = "http://localhost:8080/api/elements";

  constructor(private http: HttpClient) { }

  getElements():Observable<Element[]>{
    return this.http.get<Element[]>(this.baseUrl);
  }


}
