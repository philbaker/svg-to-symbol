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
(when
  (nil? file-name)
  (println "svg-to-symbol expects an svg file name as the first argument")
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
(defn svg->symbol 
  ([file]
   (:data (js->clj (optimize file) :keywordize-keys true)))
  ([file id] 
   (let [view-box (.getAttribute (.querySelector (parse file) "svg") "viewBox")
         optimized-svg (:data (js->clj (optimize file) :keywordize-keys true))
         path (str (.querySelector (parse optimized-svg) "path"))]
     (str "<symbol id=\"" id "\" viewBox=\"" view-box "\">" path "</symbol>"))))

; Output
(def file-contents (str (fs/readFileSync file-name)))
(if (= (count cmd-line-args) 1)
  (println (svg->symbol file-contents))
  (println (svg->symbol file-contents symbol-id)))

(comment
  (def file (str (fs/readFileSync "glasses.svg")))
  (def view-box (.getAttribute (.querySelector (parse file) "svg") "viewBox"))
  (def optimized-svg (:data (js->clj (optimize file) :keywordize-keys true)))
  (def path (str (.querySelector (parse optimized-svg) "path")))
  )
