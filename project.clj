(defproject cljs-intro "0.2.0"
  :description "RenoJS ClojureScript Intro"
  :url "http://github.com/seberius/cljs-intro"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "cljs-intro"
              :source-paths ["src-cljs"]
              :compiler {
                :output-to "js/cljs_intro.js"
                :output-dir "js/out"
                :optimizations :whitespace
                :source-map "js/cljs_intro.js.map"}}]})
