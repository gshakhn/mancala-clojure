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

(def initial-game {:turn 0 :board initial-board})

(defn play-pit [board pit-number]
  (let [initial-seeds (nth board pit-number)
        board-with-empty-pit (assoc board pit-number 0)]
    (loop [seeds initial-seeds
           current-pit (inc pit-number)
           acc board-with-empty-pit]
      (if (zero? seeds)
        acc
        (let [updated-board (update-in acc [current-pit] inc)]
          (recur (dec seeds) (inc current-pit) updated-board))))))
