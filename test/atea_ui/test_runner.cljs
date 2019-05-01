;; This test runner is intended to be run from the command line
(ns atea-ui.test-runner
  (:require
    ;; require all the namespaces that you want to test
   [atea-ui.all-tests]
   [clojure.spec.test.alpha :as st]
   [figwheel.main.testing :refer [run-tests-async]]))

(defn -main [& args]
  (st/instrument)
  (run-tests-async 5000))
