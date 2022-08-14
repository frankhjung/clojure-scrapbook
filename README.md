# Clojure

## Command Line

### Leiningen

To create a new project:

```bash
cd [project_parent_directory]
lein new app [project_name]
```

### Start REPL on Commandline

To start a command line REPL, call:

```bash
rlwrap lein repl
```

This will start a Clojure REPL server -

```text
nREPL server started on port 34169 on host 127.0.0.1 - nrepl://127.0.0.1:34169
```

You can connect VS Code to this server by specifying `host:port`.
In this case it is: `localhost:34169`.

## Calva

### Shortcuts

- evaluate current top level form: `<alt-enter>`

See also [Top 10 Calva Commands](https://calva.io/commands-top10/)

### Start REPL in VSCode

Ensure that `CLASSPATH` is not set before staring REPL.

See also [VSCode and Calva quick
start](https://practical.li/clojure/clojure-editors/editor-user-guides/vscode-calva.html)

Open a terminal in Code, start a leiningen repl. The port provided will be used to connect Calva.

You can mimimise the terminal. To re-open use command palette, `View: Toggle Terminal`.
