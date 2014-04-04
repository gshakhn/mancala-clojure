(ns mancala_clojure.core)

;;; This is an incorrect implementation, such as might be written by
;;; someone who was used to a Lisp in which an empty list is equal to
;;; nil.
(defn first-element [sequence default]
  (if (nil? (seq sequence))
    default
    (first sequence)))

(def initial-board
  (let [pits-for-player (seq (repeat 6 4))]
    (concat pits-for-player [0] pits-for-player [0])))
