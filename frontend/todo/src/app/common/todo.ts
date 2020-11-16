export class Todo {

    constructor(public id: number, public name: string, public description: string, public completed: boolean, public asignedUser: string, public createdAt: Date, public updatedAt: Date) { }

}