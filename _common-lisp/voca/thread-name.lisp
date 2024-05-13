(let* ((curr-thread sb-thread:*current-thread*)
       (curr-thread-name (sb-thread:thread-name curr-thread)))
  curr-thread-name)
;; "sly-channel-1-mrepl-remote-1" 
