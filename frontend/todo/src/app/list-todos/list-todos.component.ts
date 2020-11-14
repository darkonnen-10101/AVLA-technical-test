import { Component, OnInit } from '@angular/core';
import { Todo } from '../common/todo';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos = [
    new Todo(1, 'todo1', false, new Date()),
    new Todo(2, 'todo2', false, new Date()),
    new Todo(3, 'todo3', false, new Date()),

    // { id: 1, description: 'todo1' },
    // { id: 2, description: 'todo2' },
    // { id: 3, description: 'todo3' },
  ];

  // todo = {id: 1, description: 'todo1'};


  constructor() { }

  ngOnInit(): void {
  }

}

