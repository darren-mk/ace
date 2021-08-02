;; https://www.geeksforgeeks.org/selection-sort/

;; The selection sort algorithm sorts an array
;; by repeatedly finding the minimum element
;; (considering ascending order) from unsorted part
;; and putting it at the beginning.
;; The algorithm maintains two subarrays in a given array.
;; 1 The subarray which is already sorted. 
;; 2 Remaining subarray which is unsorted.
;; In every iteration of selection sort,
;; the minimum element (considering ascending order)
;; from the unsorted subarray is picked and moved to the sorted subarray. 
;; Following example explains the above steps: 
;; arr[] = 64 25 12 22 11
;; // Find the minimum element in arr[0...4]
;; // and place it at beginning
;; 11 25 12 22 64
;; // Find the minimum element in arr[1...4]
;; // and place it at beginning of arr[1...4]
;; 11 12 25 22 64
;; // Find the minimum element in arr[2...4]
;; // and place it at beginning of arr[2...4]
;; 11 12 22 25 64
;; // Find the minimum element in arr[3...4]
;; // and place it at beginning of arr[3...4]
;; 11 12 22 25 64
;; Time Complexity: O(n2) as there are two nested loops.

;; leon i am not sure about below ->>

;; Auxiliary Space: O(1) 
;; The good thing about selection sort is
;; it never makes more than O(n) swaps and can be useful
;; when memory write is a costly operation. 

;; 1
(defn f1 [l]
  (if (empty? l)
    nil
    (let [smallest (apply min l)]
      (cons (apply min l)
            (f1 (filter #(not= % smallest) l))))))
(f1 '(3 2 4 1))
;; => (1 2 3 4)
(f1 '(9 7 6 8))
;; => (6 7 8 9)
