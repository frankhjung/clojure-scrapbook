# Clojure

* [Clojure](https://clojure.org/)
* [API's](https://clojure.github.io/clojure/)
* [Core library](https://clojuredocs.org/core-library)

## Leiningen

To create a new project using [Leiningen](https://leiningen.org/):

```bash
cd [project_parent_directory]
lein new app [project_name]
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

## eftest

I've used [eftest](https://github.com/weavejester/eftest) as a Clojure test
runner.

Invoke with:

```bash
lein eftest
```

`eftest` is the default used by the `build` alias.

### Run a specific test suite

To run, for example, just loop tests:

```bash
$ lein eftest :only test/scrapbook/loops_test.clj

2/2   100% [==================================================]  ETA: 00:00

Ran 2 tests in 0.019 seconds
2 assertions, 0 failures, 0 errors.
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

You can connect VS Code to this server by specifying `host:port`.
In this case it is: `localhost:34169`.

## Calva

### Shortcuts

* focus REPL window `ctrl+alt+o o`
* evaluate current top level form: `alt+enter`

See also [Top 10 Calva Commands](https://calva.io/commands-top10/)

### Start REPL in VSCode

Ensure that `CLASSPATH` is not set before staring REPL.

See also [VSCode and Calva quick
start](https://practical.li/clojure/clojure-editors/editor-user-guides/vscode-calva.html)

Open a terminal in Code, start a leiningen repl. The port provided will be used
to connect Calva.

You can minimize the terminal. To re-open use command palette, `View: Toggle
Terminal`.

## Word Puzzle

### Dictionary

Get valid dictionary words from British dictionary:

```bash
cat dictionary | gawk '/^[a-z]{3,9}$/ {print $0}' | head -10 > words
```

Where, dictionary is a link to `/usr/share/dict/british-english-huge`.

### Is a valid character?

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

### Random numbers

This function will generate a random floating number from 0.0 to 1.0

```clojure
(rand)
```

To simulate a 6 sided dice:

```clojure
(take 11 (repeatedly #(inc (rand-int 6))))
(3 4 1 4 1 3 5 3 6 5 6)
```
