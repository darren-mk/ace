(defmulti encounter
  (fn [x y] [(:breed x) (:breed y)]))
;; => nil

(defmethod encounter [:lion :lion] [x y] "fight!")
;; => #multifn[encounter 0x4519efff]

(defmethod encounter [:lion :rabbit] [x y] "eat!")
;; => #multifn[encounter 0x4519efff]

(defmethod encounter [:rabbit :lion] [x y] "run!")
;; => #multifn[encounter 0x4519efff]

(defmethod encounter [:rabbit :rabbit] [x y] "play!")
;; => #multifn[encounter 0x4519efff]


(encounter {:breed :lion :age 2} {:breed :lion :age 2})
;; => "fight!"

(encounter {:breed :lion :age 2} {:breed :rabbit :age 1})
;; => "eat!"

(encounter {:breed :rabbit :age 2} {:breed :lion :age 3})
;; => "run!"

(encounter {:breed :rabbit :age 1} {:breed :rabbit :age 1})
;; => "play!"
