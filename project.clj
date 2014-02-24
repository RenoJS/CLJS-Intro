(defproject cljs-intro "0.2.2"
  :description "RenoJS ClojureScript Intro"
  :url "http://github.com/seberius/cljs-intro"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]
                 [prismatic/dommy "0.1.2"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "cljs-intro"
              :source-paths ["src-cljs"]
              :compiler {
                :output-to "resources/js/cljs_intro.js"
                :output-dir "resources/js/out"
                :optimizations :advanced}}

             {:id "cljs-intro-dev"
              :source-paths ["src-cljs"]
              :compiler {
                :output-to "resources/dev/js/cljs_intro.js"
                :output-dir "resources/dev/js/out"
                :optimizations :whitespace
                :source-map "resources/dev/js/cljs_intro.js.map"}}]})
