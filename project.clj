(defproject scrapbook "0.1.0-SNAPSHOT"
  :description "Clojure Code Scraps"
  :url "https://gitlab.com/frankhjung1/clojure-scrapbook"
  :license {:name "MIT License"
            :url "https://spdx.org/licenses/MIT.html"}
  :dependencies [[org.clojure/clojure "1.12.4"]]
  :plugins [[lein-eftest "0.6.0"]
            [lein-ancient "0.7.0"]]
  :test-paths ["test"]
  :main ^:skip-aot scrapbook.main
  :target-path "target/%s"
  :profiles {:dev {:aliases {"build" ["do" "check," "eftest," "run"]}
                   :plugins [[lein-cljfmt "0.6.8"]]}
             :cicd {:local-repo ".m2/repository"}}
  :clean-targets [:target-path]
  :aliases {"build" ["do" "check," "eftest," "run"]})
