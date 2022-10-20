(ns exercism-clj.interest-is-interesting.interest-is-interesting)

(defn interest-rate
  "Returns an appropriate, discrete interest rate based on the value of balance in the account"
  [balance]
  (cond (< balance 0) -3.213
        (< balance 1000) 0.5
        (< balance 5000) 1.621
        :else 2.475)
  )

(defn annual-balance-update
  "Returns the new balance for the next account-year by applying the appropriate interest rate to the existing year's balance"
  [balance]
  (with-precision 30
    (+ (bigdec balance) (* (/ (bigdec (interest-rate balance)) 100M) (bigdec (abs balance))))))

(defn amount-to-donate
  "Returns double the tax-free allowance for positive balances"
  [balance tax-free-percentage]
  (if (> balance 0) (int (* (* balance (/ tax-free-percentage 100)) 2)) 0))
