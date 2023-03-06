(ns svg-to-symbol.core
  (:require [clojure.string :as str]
            ["node-html-parser" :as html :refer [parse]]
            ["fs" :as fs]
            ["path" :as path]
            ["svgo$default" :refer [optimize]]))

; Command line arguments
(def cmd-line-args (js->clj (.slice js/process.argv 2)))
(def file-name (first cmd-line-args))
(def symbol-id (second cmd-line-args))

; Error handling
(when-not
  (= 2 (count cmd-line-args))
  (println "svg-to-symbol expects two arguments: file-name and symbol-id")
  (js/process.exit 1))

(when-not
  (fs/existsSync file-name)
  (println file-name "does not exist")
  (js/process.exit 1))

(when-not
  (= (path/extname file-name) ".svg")
  (println "file must have the extension .svg")
  (js/process.exit 1))

; SVG transformation
(def file-contents (str (fs/readFileSync file-name)))

(defn svg->symbol [file id] 
  (let [view-box (.getAttribute (.querySelector (parse file) "svg") "viewBox")
        optimized-svg (:data (js->clj (optimize file) :keywordize-keys true))  
        path-tag (str (.querySelector (parse optimized-svg) "path"))
        path-tag-self-close (clojure.string/replace path-tag #"></path>" "/>")]
    (str "<symbol id=\"" id "\" viewBox=\"" view-box "\">" path-tag-self-close "</symbol>")))

; Output
(println (svg->symbol file-contents symbol-id))
