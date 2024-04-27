(import datetime [datetime])
(import pydantic [BaseModel PositiveInt])

(defn add [(annotate x int)]
  (+ x 1))

(print (add 2.18))
