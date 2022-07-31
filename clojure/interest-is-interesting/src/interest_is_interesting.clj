(ns interest-is-interesting)

(defn interest-rate
  "receives the account balace and returns a calculated rateing"
  [balance]
  (cond (< balance 0) -3.213
        (< balance 1000) 0.5
        (< balance 5000) 1.621
        :else 2.475))

(defn annual-balance-update
  "calculates the balance with the interest-rate"
  [balance]
  (+ balance (* balance (bigdec (Math/abs (/ (interest-rate balance) 100))))))

(defn amount-to-donate
  "calculate money to be donated"
  [balance tax-free-percentage]
  (let [amount-to-donate (* balance (* (/ tax-free-percentage 100) 2))]
    (if (neg? balance) 
      0
      (int (Math/floor amount-to-donate)))))