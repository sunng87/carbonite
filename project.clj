(defproject info.sunng/carbonite "0.2.2"
  :source-path "src/clj"
  :java-source-path "src/jvm"
  :description "Write Clojure data to and from bytes using Kryo."
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [com.googlecode/kryo "1.04"]]
  :dev-dependencies [[lein-multi "1.1.0-SNAPSHOT"]]
  :multi-deps {"1.2" [[org.clojure/clojure "1.2.1"]
                      [com.googlecode/kryo "1.04"]]
               "1.4" [[org.clojure/clojure "1.4.0-alpha5"]
                      [com.googlecode/kryo "1.04"]]}
  :warn-on-reflection true)
