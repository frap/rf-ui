(ns atea-ui.cards
 (:require
   [devcards.core]
   [clojure.spec.test.alpha :as st]
   [atea-ui.all-tests])
 )


(st/instrument)

(devcards.core/start-devcard-ui!)
