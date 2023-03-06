(ns svg-to-symbol.core-test
  (:require [clojure.test :as test]
            [svg-to-symbol.core :refer [svg->symbol]]))

(def original-svg "<?xml version=\"1.0\" ?>\n\r<!-- Uploaded to: SVG Repo, www.svgrepo.com, Generator: SVG Repo Mixer Tools -->\n<svg width=\"800px\" height=\"800px\" viewBox=\"0 0 24 24\" version=\"1.1\" xml:space=\"preserve\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n\r<style type=\"text/css\">\r\n\t.st0{opacity:0.2;fill:none;stroke:#000000;stroke-width:5.000000e-02;stroke-miterlimit:10;}\r\n</style>\n\r<g id=\"Layer_Grid\"/>\n\r<g id=\"Layer_2\">\n\r<path d=\"M7,19c2.8,0,5-2.2,5-5c0,2.8,2.2,5,5,5s5-2.2,5-5v-2c0,0,0-0.1,0-0.1c0-0.1,0-0.1,0-0.2c0-0.1-0.1-0.1-0.1-0.2   c0,0,0-0.1-0.1-0.1l-5-6C16.5,5,16,4.9,15.6,5.1l-2,1c-0.5,0.2-0.7,0.8-0.4,1.3s0.8,0.7,1.3,0.4l1.3-0.6l3.1,3.8H14h-1h-2h-1H5.1   l3.1-3.8l1.3,0.6c0.5,0.2,1.1,0,1.3-0.4c0.2-0.5,0-1.1-0.4-1.3l-2-1C8,4.9,7.5,5,7.2,5.4l-5,6c0,0,0,0.1-0.1,0.1   c0,0.1-0.1,0.1-0.1,0.2c0,0.1,0,0.1,0,0.2c0,0,0,0.1,0,0.1v2C2,16.8,4.2,19,7,19z M14,13h6v1c0,1.7-1.3,3-3,3s-3-1.3-3-3V13z M4,13   h6v1c0,1.7-1.3,3-3,3s-3-1.3-3-3V13z\"/>\n\r</g>\n\r</svg>")

(test/deftest transforms-svg
  (test/is (= (svg->symbol original-svg "glasses")
              "<symbol id=\"glasses\" viewBox=\"0 0 24 24\"><path id=\"Layer_2\" d=\"M7 19c2.8 0 5-2.2 5-5 0 2.8 2.2 5 5 5s5-2.2 5-5V11.7c0-.1-.1-.1-.1-.2 0 0 0-.1-.1-.1l-5-6c-.3-.4-.8-.5-1.2-.3l-2 1c-.5.2-.7.8-.4 1.3s.8.7 1.3.4l1.3-.6 3.1 3.8H5.1l3.1-3.8 1.3.6c.5.2 1.1 0 1.3-.4.2-.5 0-1.1-.4-1.3l-2-1c-.4-.2-.9-.1-1.2.3l-5 6s0 .1-.1.1c0 .1-.1.1-.1.2V14c0 2.8 2.2 5 5 5zm7-6h6v1c0 1.7-1.3 3-3 3s-3-1.3-3-3v-1zM4 13h6v1c0 1.7-1.3 3-3 3s-3-1.3-3-3v-1z\"/></symbol>")))

(comment
  (test/run-tests))
