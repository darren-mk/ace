(defvar a 1)
;; a

a
;; 1

(defmacro dfv (sym content)
  `(defvar ,sym ,content))

(dfv a 1)
;; a

a
;; 1
