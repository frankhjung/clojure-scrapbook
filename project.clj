;; https://github.com/technomancy/leiningen/blob/stable/sample.project.clj
(defproject scrapbook "0.1.0-SNAPSHOT"
  :description "Clojure Code Scraps"
  :url "https://gitlab.com/frankhjung1/clojure-scrapbook"
  :license {:name "GNU General Public License (GPLv3)"
            :url "https://www.gnu.org/licenses/gpl-3.0.txt"}
  :pedantic? :abort
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :plugins [[lein-pprint "1.1.1"]
            [lein-eftest "0.5.9"]]
  :aot [scrapbook.core]    ;; aot - ahead-of-time compilation
  :main scrapbook.core
  :target-path "target/%s"
  :profiles {:dev {:aliases {"build" ["do" "check," "test," "run"]}}
             :cicd {:local-repo ".m2/repository"}}
  :clean-targets [:target-path]
  :aliases {"build" ["do" "check," "eftest," "run"]})
