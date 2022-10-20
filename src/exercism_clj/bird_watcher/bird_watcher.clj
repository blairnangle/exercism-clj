(ns exercism-clj.bird-watcher.bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds] (last birds))

(defn inc-bird [birds] (assoc birds (- (count birds) 1) (inc (today birds))))

(defn day-without-birds? [birds] (contains? (set birds) 0))

(defn n-days-count [birds n] (reduce + (take n birds)))

(defn busy-days [birds] (count (filter #(<= 5 %) birds)))

(defn odd-week? [birds] (contains? {[1 0 1 0 1 0 1], [0 1 0 1 0 1 0]} birds))
