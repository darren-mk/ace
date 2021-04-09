(comment
  "There is a nice function that matches the whole string. It is called re-matches. The return is a little complex. If the whole string does not match, it returns nil, which is nice because nil is falsey."
  (defn re-matches
    "Returns the match, if any, of string to pattern, using
  java.util.regex.Matcher.matches().  Uses re-groups to return the
  groups."
    {:added "1.0"
     :static true}
    [^java.util.regex.Pattern re s]
    (let [m (re-matcher re s)]
      (when (. m (matches))
        (re-groups m)))))

(re-matches #"abc" "abc")
;; => "abc"

(re-matches #"abc" "zzzabcxxx")
;; => nil

(re-matches #"abc" "ab")
;; => nil

(re-matches #"abc(.*)" "abcxyz")
;; => ["abcxyz" "xyz"]
