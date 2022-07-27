(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds] (last birds))

(defn inc-bird [birds] 
   (def last-week (assoc birds 6
                         (-> birds today inc)))
  last-week)

(defn day-without-birds? [birds]
  (true? (some #(< % 1) birds)))

(defn n-days-count [birds n]
  (reduce #(+ %1 %2) (take n birds)))

(defn busy-days [birds]
  (count (filter #(>= % 5) birds)))

(defn odd-week? [birds]
  (= [1 0 1 0 1 0 1] birds))
