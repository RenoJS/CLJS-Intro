(defproject cljs-intro "0.1.0-SNAPSHOT"
  :description "RenoJS ClojureScript Intro"
  :url "http://github.com/seberius/cljs-intro"

  :dependencies [[org.clojure/clojure "1.5.1"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "cljs-intro"
              :source-paths ["src-cljs"]
              :compiler {
                :output-to "js/cljs_intro.js"
                :output-dir "out"
                :optimizations :whitespace
                :source-map true}}]})
