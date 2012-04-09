
(ns leiningen.cljpc
  (:use [leiningen.core.eval :only [eval-in-project]]))
                                                                                                                                                                          
(defn- default-path
  "Returns the default include path for the project"
  [project]
  (format "src/%s/core.cljp"
          (:name project)))

(defn cljpc
  "Compile the specified path, or the default"
  [project & args]
  (let [path (first args)
        path (if (nil? path) (default-path project) path)]
    (eval-in-project (update-in project [:dependencies]
                                conj ['clj-php "0.0.6"])
       `(println (compile-cljp ~path)))))

