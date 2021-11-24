import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { TaskModel } from './task.model';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { BaseService } from '../core/service/baseService.service';
@Injectable()
export class TaskService extends BaseService {
  private readonly API_URL = this.base_url + '/orders/info';
  isTblLoading = true;
  dataChange: BehaviorSubject<TaskModel[]> = new BehaviorSubject<TaskModel[]>([]);
  // Temporarily stores data from dialogs
  dialogData: any;
  constructor(private http: HttpClient) { super(); }
  get data(): TaskModel[] {
    return this.dataChange.value;
  }
  getDialogData() {
    return this.dialogData;
  }
  /** CRUD METHODS */
  getAllTasks(): void {
    this.http.get<TaskModel[]>(this.API_URL).subscribe(
      (data) => {
        this.isTblLoading = false;
        this.dataChange.next(data);
      },
      (error: HttpErrorResponse) => {
        this.isTblLoading = false;
        console.log(error.name + ' ' + error.message);
      }
    );
  }
  addTask(task: TaskModel): void {

null;
  }
  updateTask(task: TaskModel): void {
    null;

    /* this.httpClient.put(this.API_URL + task.id, task).subscribe(data => {
      this.dialogData = task;
    },
    (err: HttpErrorResponse) => {
      // error code here
    }
  );*/
  }
  deleteTask(id: number): void {
    null;
  }
}
