import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../common/todo';
import { TodoDataService } from '../service/data/todo-data.service';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todo: Todo = new Todo(0, '', '', false, '', new Date(), new Date());
  todos: Todo[];
  message: string;
  username: string;



  constructor(private todoService: TodoDataService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.refreshTodos();
    this.username = this.activatedRoute.snapshot.params['username'];
  }

  refreshTodos() {
    this.todoService.retrieveAllTodos(this.username).subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    );
  }

  updateTodo(id: number) {
    console.log(id);
    this.router.navigate(['todos', id]);
  }


  deleteTodo(id: number) {
    this.todoService.deleteTodo(this.username, id).subscribe(
      response => {
        console.log(response);
        this.message = 'Delete successful';
        this.refreshTodos();
      }
    );
  }

  addTodo() {
    this.router.navigate(['todos', -1]);
  }


}

