(ns svg-to-symbol 
  (:require [clojure.string :as str]
            ["node-html-parser" :as html :refer [parse]]
            ["fs" :as fs]
            ["svgo$default" :refer [optimize]]))

(def file-name (first *command-line-args*))
(def symbol-id (second *command-line-args*))

(defn svg->symbol [file-name id] 
  (let [file (str (fs/readFileSync file-name))
        optimized-svg (:data (js->clj (optimize file) :keywordize-keys true))  
        path-tag (str (.querySelector (parse optimized-svg) "path"))]
    (str "<symbol id=\"" id "\" viewbox=\"0 0 24 24\">" path-tag "</symbol>")))

(println (svg->symbol file-name symbol-id))
