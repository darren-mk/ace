(System/nanoTime)
;; => 15666991227120

(java.lang.System/nanoTime)
;; => 15675172117884

(let [start (System/nanoTime)
      _ (Thread/sleep 3000)
      end (System/nanoTime)]
  (- end start))
;; takes 3 seconds and then
;; => 3000329745
