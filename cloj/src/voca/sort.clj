(comment
  (defn sort
    "Returns a sorted sequence of the items in coll. If no comparator is
  supplied, uses compare.  comparator must implement
  java.util.Comparator.  Guaranteed to be stable: equal elements will
  not be reordered.  If coll is a Java array, it will be modified.  To
  avoid this, sort a copy of the array."
    {:added "1.0"
     :static true}
    ([coll]
     (sort compare coll))
    ([^java.util.Comparator comp coll]
     (if (seq coll)
       (let [a (to-array coll)]
         (. java.util.Arrays (sort a comp))
         (with-meta (seq a) (meta coll)))
       ()))))

(sort compare [3 2 1])
;; => (1 2 3)

(sort [3 2 1])
;; => (1 2 3)
