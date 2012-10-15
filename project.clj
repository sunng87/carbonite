(defproject info.sunng/carbonite "0.2.3"
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"]
  :description "Write Clojure data to and from bytes using Kryo."
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [com.googlecode/kryo "1.04"]]
  :warn-on-reflection true)
