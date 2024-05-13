(defstruct animal
  (height 0 :type real)
  (weight 0 :type real))

(defstruct (human (:include animal))
  (name "unnamed" :type string))

(defvar my-dog (make-animal :height 25
			    :weight 40))

(defvar me (make-human :height 171
		       :weight 68
		       :name "darren"))

#|
CL-USER> me
#S(HUMAN :HEIGHT 171 :WEIGHT 68 :NAME "darren")
CL-USER> my-dog
#S(ANIMAL :HEIGHT 25 :WEIGHT 40)
|#
