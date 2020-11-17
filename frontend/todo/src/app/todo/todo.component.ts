import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../common/todo';
import { TodoDataService } from '../service/data/todo-data.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id: number;
  todo: Todo = new Todo(0, '', '', false, '', new Date(), new Date());
  username: string;
  users: string[] = ["user1", "user2", "user3"];

  constructor(private todoService: TodoDataService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.username = this.activatedRoute.snapshot.params['username'];
    this.todo = new Todo(this.id, '', '', false, '', new Date(), new Date());
    if (this.id != -1) {
      // console.log(`${this.username} | ${this.id}`);
      this.todoService.retrieveTodo(this.username, this.id).subscribe(
        data => this.todo = data
      );

    }
  }

  saveTodo() {

    if (this.id == -1) {
      // console.log('create todo');

      this.todoService.createTodo(this.username, this.todo).subscribe(
        data => {
          this.router.navigate(['todos']);
        }
      );

    } else {
      // console.log('update todo');

      this.todoService.updateTodo(this.username, this.id, this.todo).subscribe(
        data => {
          this.router.navigate(['todos']);
        }
      );

    }

  }




}
