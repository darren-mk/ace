(comment
  "re-matches matches the whole string. But often, we want to find a match within a string. re-find returns the first match within the string. The return values are similar to re-matches.")

(re-find #"sss" "Loch Ness")
;; => nil

(re-find #"s+" "dress")
;; => "ss"

(re-find #"Ne+" "Loch Ness")
;; => "Ne"

(re-find #"Nes+" "Loch Ness")
;; => "Ness"

(re-find #"s+(.*)(s+)" "success")
;; => ["success" "ucces" "s"]
