
(ns leiningen.cljpc
  (:use clj-php.core
        add-classpath.core))

(defn- default-path
  [project]
  (format "src/%s/core.cljp"
          (:name project)))

(defn- to-classpaths
  [project [name version]]
  (format "lib/%s-%s.jar"
          name
          version))

(defn cljpc
  "Compile the specified path, or the default"
  [project & args]
  (let [path (first args)
        path (if (nil? path) (default-path project) path)]
    (doseq [clspath (map (partial to-classpaths project) (:dependencies project))]
      (add-classpath clspath))
    (println (compile-cljp path))))

