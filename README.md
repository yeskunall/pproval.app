<a href="https://pproval.herokuapp.com" target="_blank" rel="noopener noreferrer"><img width="900" src=".github/banner@2x.png" alt="pproval-app--banner--inverted" /></a>

> 📑 Submit. 🧐 Review. ✅ _Approve_.

[![Build Status](https://travis-ci.com/yeskunall/pproval.app.svg?branch=master)](https://travis-ci.com/yeskunall/pproval.app)

## Features

- [ ] Submit an article for review

- [ ] Assign an article to a reviewer

- [ ] Give the reviewer a deadline to hand in their review*
    - [ ] Get notified of overdue reviews

- [ ] Submit a review of an article

- [ ] Accept or reject an article based on the submitted review*

- [ ] Be notified of review status (“accepted”, “in review”, “rejected”, “submitted“) updates to your of submitted article

- [ ] List all submitted articles, filter & sort them by assigned status, deadline, and status

\* _These features are only available to you if you are logged in as an editor_

---

## Getting Started

### Clone the repo

```shell
$ git clone https://github.com/pproval-org/app.git
$ cd app
```

### Prerequisites

The instructions that follow assume that you at least have Java version 11 installed. Development is done on [IntelliJ IDEA](https://www.jetbrains.com/idea/), so it is expected that you have it installed. The following steps also assume that you have the project opened (not imported) in IntelliJ, and that you have all Maven projects imported already

### Running the app

#### Clean install

```shell
$ ./mvnw clean -e install
```

#### Initialize the Tomcat server on port `8080`

```shell
$ ./mvnw spring-boot:run
```

#### Launch

Visit [`http://localhost:8080`](http://localhost:8080) in your browser to launch the app

---

## Notes

* The project uses [Lombok](https://projectlombok.org/) to avoid writing duplicate boilerplate code. For an example, see [here](https://projectlombok.org/features/GetterSetter)

* This project uses `spring-boot-devtools` for hot swapping and [LiveReload](http://livereload.com/) for hot reloading. With the LiveReload script injected into the app, in IntelliJ, do <kbd>⌘ F9</kbd> to build the app and trigger a live reload in the browser

* This repository (_not_ the project) has a moot dependency on [NodeJS](https://nodejs.org/en/). The __pproval.app__ team uses Node along with `husky`, `lint-staged`, and `google-code-format` for in-house maintenance. See the [Code Style](#code-style) section for more

## Code Style

This project follows the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html). A `git` hook is setup using [`husky`](https://github.com/typicode/husky) and [`lint-staged`](https://github.com/okonet/lint-staged) that runs [`google-java-format`](https://github.com/google/google-java-format) against all `*.java` files automatically

## Deployment

The app is deployed to Heroku: the `master` branch is automatically deployed to Heroku once the CI tests pass. Visit the latest version of pproval.app [here](https://pproval.herokuapp.com)

## Upcoming (March 6<sup>th</sup> - March 20<sup>th</sup>)

- Finish tasks from previous milestone (_if any remaining_)
- *__TODO__: Fill the rest*

## License

[MIT](./LICENSE)


