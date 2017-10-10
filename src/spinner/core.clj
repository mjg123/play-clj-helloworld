(ns spinner.core
  (:require [play-clj.core :refer :all]
            [play-clj.g2d :refer :all]))

(defn do-spins [tm e]
  (-> e
      (assoc :angle (+ (:angle e) (:spin e)))
      (update :big-angle (partial + (* tm (:big-spd e))))
      (update :big-spd (partial + 0.0001))))

(defn calc-pos [e]
  (assoc e
         :x (+ 400 (* (Math/sin (:big-angle e)) (:radius e)))
         :y (+ 300 (* (Math/cos (:big-angle e)) (:radius e)))))

(defn tick [s es]
  (->> es
       (map (comp (partial do-spins (:delta-time s)) calc-pos))))

(def ctex (atom nil))

(defn create-e [x]
  (let [sz (+ 5 (rand-int 25))]
    (-> @ctex
        (assoc :radius (rand-int 300)
               :big-angle (* 2 Math/PI (rand))
               :big-spd (- (* 2 (rand)) 1)

               :spin (- (* 5 (rand)) 2.5)
               :angle 0
               :width sz
               :height sz)
        (calc-pos))))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (reset! ctex (texture "clojure.png"))
    (update! screen :renderer (stage))
    (map create-e (range 1000)))

  :on-render
  (fn [screen entities]
    (clear!)
    (println (/ 1.0 (:delta-time screen)))
    (render! screen entities)
    (tick screen entities)))

(defgame spinner
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
