(ns cars-assemble)

(def capacity 221)
(def capacity-90 (* capacity 0.9M))
(def capacity-80 (* capacity 0.9))
(def capacity-77 (* capacity 0.7))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (cond
    (= speed 0) 0
    (<= speed 4) (* speed capacity)
    (<= speed 8) (* speed capacity-90)
    (<= speed 9) (* speed capacity-80)
    (<= speed 10) (* speed capacity-77)
    :else -1))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (let [minutes (* speed 60)]
    (/ (production-rate speed) 60)))
