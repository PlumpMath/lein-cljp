# lein-cljp

A Leiningen 2 plugin for compiling ClojurePHP.

*NB:* Only works with Leiningen 2.0

## Usage

Just add the plugin to your *~/.lein/profiles.clj* file.

```clojure
{:user
  { :plugins [[lein-cljp "0.0.1"]] }
}
```

Then run using the lein command.

```bash
lein2 cljpc
```

This will default to compiling *src/your_project/core.cljp*, if you need to compile something different then just specify the path as the first argument.
