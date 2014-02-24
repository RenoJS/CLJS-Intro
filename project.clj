(defproject cljs-intro "1.0.0"
  :description "RenoJS ClojureScript Intro"
  :url "http://github.com/seberius/cljs-intro"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]
                 [compojure "1.1.6"]
                 [selmer "0.5.9"]
                 [prismatic/dommy "0.1.2"]]

  :plugins [[lein-ring "0.8.10"]
            [lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :ring {:handler cljs-intro.app/app}
  :profiles {
    :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                         [ring-mock "0.1.5"]]}}

  :cljsbuild {
    :builds [{:id "cljs-intro"
              :source-paths ["src-cljs"]
              :compiler {
                :output-to "resources/public/js/cljs_intro.js"
                :output-dir "resources/public/js/out"
                :optimizations :advanced}}

             {:id "cljs-intro-dev"
              :source-paths ["src-cljs"]
              :compiler {
                :output-to "resources/dev/js/cljs_intro.js"
                :output-dir "resources/dev/js/out"
                :optimizations :whitespace
                :source-map "resources/dev/js/cljs_intro.js.map"}}]})

