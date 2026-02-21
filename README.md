# Clojure

* [Clojure](https://clojure.org/)
* [API's](https://clojure.github.io/clojure/)
* [Core library](https://clojuredocs.org/core-library)

## Project

This repository contains small Clojure code snippets and exercises used for
learning the language and experimenting with core concepts. It is intended
for quick iteration: run examples, add tests, and try out ideas in a
lightweight project layout.

## Dependencies

* [Clojure fmt](https://github.com/weavejester/cljfmt)
* [Clojure](https://clojure.org/) (this project uses **1.12.4**)
* [eftest](https://github.com/weavejester/eftest) (via lein-eftest **0.6.0**
  plugin)
* [Java](https://www.java.com/en/download/)
* [Leiningen](https://leiningen.org/)

## Leiningen

### Create New Project

To create a new project using [Leiningen](https://leiningen.org/):

```bash
cd [project_parent_directory]
lein new app [project_name]
```

### Check Project Syntax

```bash
lein check
```

The repository includes a simple `Makefile` with convenience targets. Local
commands operate under the normal (dev) profile; only the GitHub/GitLab
pipelines should invoke the `cicd` profile. Targets prefixed with `cicd-` use
the cicd profile.

```bash
make clean           # lein clean (dev profile)
make fmt             # format sources with cljfmt
make check           # cljfmt check
make compile         # compile project
make test            # run tests (eftest, dev profile)
make show-profiles   # dump the :profiles map (dev + cicd)

# pipeline-specific commands (invoked by CI):
make cicd-clean      # lein with-profile cicd clean
make cicd-test       # run tests with cicd profile
```

## CI (GitHub / GitLab)

Both GitHub Actions and GitLab CI run the project using the `cicd`
profile. The pipelines invoke Leiningen with the `cicd` profile so CI can
use separate settings (local repo, environment variables, etc.). Example
commands used by CI:

```bash
lein with-profile cicd do clean, check, compile, eftest, run "foo" "bar"
```

On GitHub Actions the workflow runs similar steps (check/compile/eftest/run)
using `lein with-profile cicd`.

### Test Project with eftest

Using [eftest](https://github.com/weavejester/eftest):

```bash
lein eftest
```

### Build Über JAR

To build a standalone JAR:

```bash
lein uberjar
```

This will build 2 JARs:

```text
  28613 Aug 18 10:59 target/uberjar/scrapbook-0.1.0-SNAPSHOT.jar
4596184 Aug 18 10:59 target/uberjar/scrapbook-0.1.0-SNAPSHOT-standalone.jar
```

The über JAR can be called with:

```bash
java -jar target/uberjar/scrapbook-0.1.0-SNAPSHOT-standalone.jar
```

### Run

Run this projects `main` function:

```bash
lein run
```

### Start REPL

To start a command line REPL, call:

```bash
rlwrap lein repl
```

This will start a Clojure REPL server:

```text
nREPL server started on port 34169 on host 127.0.0.1 - nrepl://127.0.0.1:34169
```

Useful functions in REPL:

```clojure
    Docs: (doc function-name-here)
          (find-doc "part-of-name-here")
  Source: (source function-name-here)
 Javadoc: (javadoc java-object-or-class-here)
    Exit: Control+D or (exit) or (quit)
 Results: Stored in vars *1, *2, *3, an exception in *e
```

### Updating dependencies

Keep project dependency versions in `project.clj`. To update dependencies:

* Manually edit the version strings under the `:dependencies` or `:plugins` map
  in `project.clj`.
* Refresh dependencies and verify the build:

```bash
lein deps       # fetch updated deps
lein test       # run tests after updating versions
```

If you prefer an automated check for outdated dependencies, install the
`lein-ancient` plugin globally or add it to `:plugins`, then run:

```bash
lein ancient    # shows outdated dependencies
lein ancient upgrade  # (interactive) upgrade listed deps
```

**Note:** `lein-ancient` is a third-party plugin; review changes and run
`lein test` after upgrades.

## cljfmt

The project uses [cljfmt](https://github.com/weavejester/cljfmt) to format
source code. The plugin is added to the `:dev` profile in `project.clj`, so it
is not required for normal builds – it is purely a development tool. You can
also install it globally if you prefer.

Use the formatter from Leiningen:

```bash
lein cljfmt fix      # rewrites source files to the standard style
lein cljfmt check    # checks formatting without changing files
```

The `Makefile` provides convenient shortcuts:

```makefile
make fmt        # run cljfmt fix (dev profile)
make check      # run cljfmt check (dev profile)
```

## eftest

I've used [eftest](https://github.com/weavejester/eftest) as a Clojure test
runner.

Invoke with:

```bash
lein eftest
```

`eftest` is the default used by the `build` alias.

### Run a Specific Test

To run, for example, just the loop tests:

```bash
$ lein eftest :only test/scrapbook/loopstest.clj

2/2   100% [==================================================]  ETA: 00:00

Ran 2 tests in 0.019 seconds
2 assertions, 0 failures, 0 errors.
```

## IDE Plugins

### VS Code

You can connect VS Code to this server by specifying `host:port`. In this case
it is: `localhost:34169`.

### Vim

#### Fireplace Plugin

Connect to REPL in vim using [fireplace
plugin](https://github.com/tpope/vim-fireplace) using:

`:FireplaceConnect host:port`

Useful commands:

* `:Source`, `:Doc`, and `:FindDoc`, which map to the underlying `clojure.repl`
  macro (with tab complete, of course).
* `K` is mapped to look up the symbol under the cursor with doc.
* `[d` is mapped to look up the symbol under the cursor with source. *
  `[<C-D>` jumps to the definition of a symbol (even if it's inside a jar file). `<C-]>`
  does the same and uses the tag stack.
* `gf`, everybody's favourite "go to file" command, works on namespaces.

#### vim-cljfmt Plugin

Install [Cljfmt plugin](https://github.com/venantius/vim-cljfmt) to format
Clojure.

## Calva

[Calva](https://calva.io/) is a popular Clojure extension for VS Code. It
provides a rich set of features for Clojure development, including REPL
integration, code formatting, and debugging.

### Shortcuts

* focus REPL window `ctrl+alt+o o`
* evaluate current top level form: `alt+enter`

See also [Top 10 Calva Commands](https://calva.io/commands-top10/)

### Start REPL in VS Code

Ensure that `CLASSPATH` is not set before staring REPL.

See also [VSCode and Calva quick
start](https://practical.li/clojure/clojure-editors/editor-user-guides/vscode-calva.html)

Open a terminal in Code, start a leiningen repl. The port provided will be used
to connect Calva.

You can minimize the terminal. To re-open use command palette, `View: Toggle
Terminal`.

### Has Valid Character?

Use `clojure.string/replace-first`:

```clojure
(clojure.string/replace-first "abacde" "a" "")
"bacde"
```

### Parse String to Integer

```clojure
(Integer/parseInt "5")
5
```

### Random Numbers

This function will generate a random floating number from 0.0 to 1.0 (default):

```clojure
(rand)
```

To simulate a 6 sided dice:

```clojure
(take 11 (repeatedly #(inc (rand-int 6))))
(3 4 1 4 1 3 5 3 6 5 6)
```

### Check for a Valid Word

The `scrapbook.words/validWord?` function can be used to determine if a
candidate word can be formed from a given set of letters:

```clojure
(require '[scrapbook.words :refer [validWord?]])
(validWord? "scrap" "cars")   ;;=> true
(validWord? "scrap" "cats")   ;;=> false
```

## References

Contributions are welcome. Please open issues or PRs for fixes and features.
Include a short description, a test where appropriate, and ensure `lein test`
passes locally.

* [Calva](https://calva.io/)
* [cljrfmt](https://github.com/weavejester/cljfmt)
* [Clojure API](https://clojure.github.io/clojure/)
* [Clojure Documentation](https://clojure.org/documentation)
* [Clojure](https://clojure.org/)
* [ClojureDocs](https://clojuredocs.org/)
* [eftest](https://github.com/weavejester/eftest)
* [Leiningen](https://leiningen.org/)

## License

This project is licensed under the **MIT License** (see `LICENSE`).
