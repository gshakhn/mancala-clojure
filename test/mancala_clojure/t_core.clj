(ns mancala_clojure.t-core
  (:use midje.sweet)
  (:use [mancala_clojure.core]))

(facts "about `first-element`"
  (fact "it normally returns the first element"
    (first-element [1 2 3] :default) => 1
    (first-element '(1 2 3) :default) => 1)

  ;; I'm a little unsure how Clojure types map onto the Lisp I'm used to.
  (fact "default value is returned for empty sequences"
    (first-element [] :default) => :default
    (first-element '() :default) => :default
    (first-element nil :default) => :default
    (first-element (filter even? [1 3 5]) :default) => :default))


(facts "about the initial board"
  (fact "it should have 4 seeds in each pit"
     (nth initial-board 0) => 4
     (nth initial-board 1) => 4
     (nth initial-board 2) => 4
     (nth initial-board 3) => 4
     (nth initial-board 4) => 4
     (nth initial-board 5) => 4
     (nth initial-board 7) => 4
     (nth initial-board 8) => 4
     (nth initial-board 9) => 4
     (nth initial-board 10) => 4
     (nth initial-board 11) => 4
     (nth initial-board 12) => 4))

  (fact "it should have 0 seeds in each store"
     (nth initial-board 6) => 0
     (nth initial-board 13) => 0)

(facts "about the initial game"
  (fact "it should be the first player's turn"
     (:turn initial-game) => 0)

  (fact "it should have the initial board"
     (:board initial-game) => initial-board))

(facts "about playing a pit"
  (fact "it should go to zero and increment the next pits"
        (play-pit [1 0 0 0 0 0 0 0 0 0 0 0 0 0 0] 0) => [0 1 0 0 0 0 0 0 0 0 0 0 0 0 0]
        (play-pit [0 1 0 0 0 0 0 0 0 0 0 0 0 0 0] 1) => [0 0 1 0 0 0 0 0 0 0 0 0 0 0 0]
        (play-pit [2 0 0 0 0 0 0 0 0 0 0 0 0 0 0] 0) => [0 1 1 0 0 0 0 0 0 0 0 0 0 0 0]))
