(ns svg-to-symbol
  (:require 
    [clojure.pprint :refer [pprint]]
    [clojure.string :as str]
    ["node-html-parser" :as html :refer [parse]]
    ["fs" :as fs]
    ["svgo$default" :refer [optimize]]))

(def file (str (fs/readFileSync (first *command-line-args*))))
(def symbol-id (second *command-line-args*))

(def transformed-svg (:data (js->clj (optimize file) :keywordize-keys true)))

(def path (str (.querySelector (parse transformed-svg) "path")))

(str "<symbol id=\"" symbol-id "\" viewbox=\"0 0 24 24\">" path "<symbol>")

(println "Transforming " file " ...")

(fs/writeFileSync (str symbol-id ".svg") transformed-svg)
