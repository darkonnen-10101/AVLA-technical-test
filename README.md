# AVLA technical test for Spring Boot backend jr.

## I tried my best at this challenge. 

For this project, first I created a basic frontend with some views, because i'd never worked this much with `Angular` or any other frontend framework. After generating some components, then I created almost all of the backend esentials in less than an hour.

---

## My assumptions were as follows:

1. There was no need for an User entity for this `CRUD` webapp. Only login functionality (and logout to destroy current session), without registry. **JWT and Spring Security** needed no User entity to achieve this.


2. The static list of users were only a `select` option in the frontend that sets the corresponding "string" attribute on the Todo entity. It makes sense to do it like this instead of making a **@ManyToMany relationship** with another entity or something like that. Database normalization was not an issue or concern for this technical test.


3. So, all things considered, in order to succesfully complete all requirements for this challenge, I'd to come up with a simple and clever implementation of an algorithm to select the **less overloaded "asigned_user"** attribute for the task. My way around this was to execute a native query ONLY when needed (when creating a new Todo without an user). I almost got it wrong by parsing all objects and sorting (yes, sorting) a `Entry hashmap` using something like a divide and conquer strategy. **BAD IDEA.**

---

## Final words

I find it very easy to create all `CRUD` functionality in a monolithic application, using `Thymeleaf` or `JSP`. Even creating an `API` to expose some endpoints, it's fun and requires little effort to do the basics of it. The difficult part for me was the frontend. Typescript is elegant and I like it, but has its own ways to do certain this, like working with `http.headers` and receiving `data`. 

What else can I say, my main problems for this challenge was `CORS`. I got many CORS exceptions for different reasons in the frontend and backend, but I worked out my way around it.


## Goodbye

I enjoyed this challenge. **Thank you** for showing interest in my professional profile. 


