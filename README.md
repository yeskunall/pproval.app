<a href="https://talos.now.sh/" target="_blank" rel="noopener
noreferrer"><img width="900" src=".github/banner@2x.png"
alt="talos-banner--inverted" /></a>

> 📑 Submit. 🧐 Review. ✅ _Approve_.

## Getting Started

### Clone the repo

```shell
git clone https://github.com/pproval-org/app.git
```

### Prerequisites

The instructions that follow assume that you at least have Java version 11 installed. Development is done on [IntelliJ IDEA](https://www.jetbrains.com/idea/), so it is expected that you have it installed. The following steps also assume that you have the project opened (not imported) in IntelliJ, and that you have all Maven projects imported already.

### Notes

* The project uses [Lombok](https://projectlombok.org/) to avoid writing duplicate boilerplate code. For an example, see [here](https://projectlombok.org/features/GetterSetter).

* This project uses `spring-boot-devtools` for hot swapping and [LiveReload](http://livereload.com/) for hot reloading. With the LiveReload script injected into the app, in IntelliJ, do <kbd>⌘ F9</kbd> to build the app and trigger a live reload in the browser.

## Running the app

If you imported the project correctly, you should see a configuration called “run”—run it. It essentially starts the Spring Boot server.

### Code Style

This project follows the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

## Deployment

The app is deployed to Heroku: the `master` branch is automatically deployed to Heroku once the CI tests pass.

## Authors

* **Kunall Banerjee** [`#100978717`]
* **Pragya Jolly Singh**
* **Robyn Van Gool**
* **Ryan Ribeiro**


