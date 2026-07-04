#[cfg(test)]
mod test_collection {

    // ===== LEVEL 1: array basics =====

    // Q1: create an array of 3 integers
    #[test]
    fn q01_array_literal() {
        let a: [i32;3] = [1,2,3];
        assert_eq!(a, [1, 2, 3]);}

    // Q2: access array elements by index
    #[test]
    fn q02_array_index() {
        let a: [i32;4] = [10, 20, 30, 40];
        assert_eq!(a[0], 10); 
        assert_eq!(a[3], 40); }

    // Q3: array length
    #[test]
    fn q03_array_len() {
        let a = [5, 10, 15];
        assert_eq!(a.len(), 3);}

    // Q4: create an array with repeated values
    #[test]
    fn q04_array_repeat() {
        let a = [0;5]; // array of five 0s
        assert_eq!(a, [0, 0, 0, 0, 0]);}

    // Q5: array type annotation
    #[test]
    fn q05_array_type() {
        let a: [i32; 3] = [1, 2, 3]; // fill in the type
        assert_eq!(a.len(), 3);}

    // Q6: iterate over an array
    #[test]
    fn q06_array_iter() {
        let a: [i32; 3] = [1, 2, 3];
        let mut sum: i32 = 0;
        for v in a { // fill in the pattern
            sum += v;}
        assert_eq!(sum, 6);}

    // Q7: mutable array - change an element
    #[test]
    fn q07_array_mut() {
        let mut a = [1, 2, 3];
        a[1] = 20; // change the second element to 20
        assert_eq!(a, [1, 20, 3]);}

    // Q8: array of strings
    #[test]
    fn q08_array_str() {
        let a = ["hello", "world"];
        assert_eq!(a[0].len(), 5);
        assert_eq!(a[1].to_uppercase(), "WORLD");}

    // ===== LEVEL 2: vec basics =====

    // Q9: create a vec with vec! macro
    #[test]
    fn q09_vec_macro() {
        let v: Vec<i32> = vec![1,2,3];
        assert_eq!(v, vec![1, 2, 3]);}

    // Q10: create an empty vec and push
    #[test]
    fn q10_vec_push() {
        let mut v: Vec<i32> = vec![]; // empty vec
        v.push(10);
	v.push(20);
        assert_eq!(v, vec![10, 20]);}

    // Q11: vec from a range
    #[test]
    fn q11_vec_from_range() {
        let v: Vec<i32> = (1..6).collect();
        assert_eq!(v, vec![1, 2, 3, 4, 5]);}

    // Q12: vec length and capacity
    #[test]
    fn q12_vec_len_cap() {
        let mut v = Vec::with_capacity(10);
        v.push(1);
        v.push(2);
        assert_eq!(v.len(), 2);
        assert_eq!(v.capacity() >= 10, true);}

    // Q13: vec pop returns Option
    #[test]
    fn q13_vec_pop() {
        let mut v: Vec<i32> = vec![1, 2, 3];
        assert_eq!(v.pop(), Some(3)); 
        assert_eq!(v.pop(), Some(2));
        assert_eq!(v.pop(), Some(1));
        assert_eq!(v.pop(), None);}

    // Q14: safe access with .get()
    #[test]
    fn q14_vec_get() {
        let v = vec![10, 20, 30];
        assert_eq!(v.get(1), Some(&20)); 
        assert_eq!(v.get(99), None); }

    // Q15: vec of strings
    #[test]
    fn q15_vec_string() {
        let v = vec!["a".to_string(), "b".to_string()];
        assert_eq!(v[0], "a");
        assert_eq!(v.len(), 2);}

    // ===== LEVEL 3: slicing =====

    // Q16: slice from array
    #[test]
    fn q16_slice_from_array() {
        let a: [i32;5] = [10, 20, 30, 40, 50];
        let s: &[i32] = &a[1..4]; // slice of index 1 to 3
        assert_eq!(s, &[20, 30, 40]);}

    // Q17: slice from vec
    #[test]
    fn q17_slice_from_vec() {
        let v: Vec<i32> = vec![1, 2, 3, 4, 5];
        let s: &[i32] = &v[..3]; // first 3 elements
        assert_eq!(s, &[1, 2, 3]);}

    // Q18: slice from beginning
    #[test]
    fn q18_slice_start() {
        let a = [1, 2, 3, 4, 5];
        let s = &a[..2]; // first 2 elements, shorthand
        assert_eq!(s, &[1, 2]);}

    // Q19: slice to the end
    #[test]
    fn q19_slice_end() {
        let a = [1, 2, 3, 4, 5];
        let s = &a[3..]; // from index 3 to the end
        assert_eq!(s, &[4, 5]);}

    // Q20: full slice
    #[test]
    fn q20_slice_full() {
        let a = [1, 2, 3];
        let s: &[i32] = &a[..]; // slice of entire array
        assert_eq!(s, &[1, 2, 3]);
        assert_eq!(s.len(), a.len());}

    // Q21: slice length and is_empty
    #[test]
    fn q21_slice_len() {
        let v = vec![10, 20, 30, 40];
        let s = &v[2..2]; // empty slice
        assert_eq!(s.len(), 0);
        assert_eq!(s.is_empty(), true);}

    // Q22: slice first and last
    #[test]
    fn q22_slice_first_last() {
        let a = [5, 10, 15, 20];
        let s = &a[..];
        assert_eq!(s.first(), Some(&5));
        assert_eq!(s.last(), Some(&20));}

    // Q23: function that takes a slice (works with both array and vec)
    #[test]
    fn q23_fn_takes_slice() {
        fn sum(s: &[i32]) -> i32 { s.iter().sum() }
        let arr = [1, 2, 3];
        let vec = vec![4, 5, 6];
        assert_eq!(sum(&arr), 6);
        assert_eq!(sum(&vec), 15);}

    // ===== LEVEL 4: converting between types =====

    // Q24: array to vec
    #[test]
    fn q24_array_to_vec() {
        let a = [1, 2, 3];
        let v: Vec<i32> = a.to_vec(); // convert array to vec
        assert_eq!(v, vec![1, 2, 3]);}

    // Q25: vec to slice (borrow)
    #[test]
    fn q25_vec_to_slice() {
        let v = vec![10, 20, 30];
        let s: &[i32] = &v[..]; // borrow vec as slice
        assert_eq!(s, &[10, 20, 30]);}

    // Q26: slice to vec (clone)
    #[test]
    fn q26_slice_to_vec() {
        let a = [1, 2, 3, 4, 5];
        let s = &a[1..4];
        let v: Vec<i32> = s.to_vec(); // convert slice to vec
        assert_eq!(v, vec![2, 3, 4]);}

    // Q27: &str is a string slice
    #[test]
    fn q27_str_slice() {
        let s = String::from("hello world");
        let word: &str = &s[..5]; // first 5 chars
        assert_eq!(word, "hello");}

    // ===== LEVEL 5: iteration patterns =====

    // Q28: iter and sum
    #[test]
    fn q28_iter_sum() {
        let v = vec![1, 2, 3, 4, 5];
        let total: i32 = v.iter().sum(); // sum using iter
        assert_eq!(total, 15);}

    // Q29: iter and count
    #[test]
    fn q29_iter_count() {
        let v: Vec<i32> = vec![1, 2, 3, 4, 5];
        let n: usize = v.iter().count(); // count elements using iter
        assert_eq!(n, 5);}

    // Q30: iter map collect
    #[test]
    fn q30_iter_map() {
        let v = vec![1, 2, 3];
        let squared: Vec<i32> = v.iter().map(|x| x * x ).collect(); // square each element
        assert_eq!(squared, vec![1, 4, 9]);}

    // Q31: iter filter collect
    #[test]
    fn q31_iter_filter() {
        let v = vec![1, 2, 3, 4, 5, 6, 7, 8];
	// keep odd numbers only
        let odds: Vec<&i32> = v.iter().filter(|x| (*x % 2) == 1).collect(); 
        assert_eq!(odds, vec![&1, &3, &5, &7]);}

    // Q32: iter enumerate
    #[test]
    fn q32_iter_enumerate() {
        let v = vec!["a", "b", "c"];
        let mut pairs: Vec<(usize, &&str)> = vec![];
        for (i, s) in v.iter().enumerate() {
            pairs.push((i, s)); }
        assert_eq!(pairs, vec![(0, &"a"), (1, &"b"), (2, &"c")]);}

    // Q33: iter any and all
    #[test]
    fn q33_iter_any_all() {
        let v = vec![2, 4, 6, 8];
        assert_eq!(v.iter().all(|x| x % 2 == 0), true);
        assert_eq!(v.iter().any(|x| *x > 5), true);
        assert_eq!(v.iter().any(|x| *x > 10), false);}

    // Q34: iter find
    #[test]
    fn q34_iter_find() {
        let v = vec![1, 3, 5, 8, 10];
	// find first even
        let first_even = v.iter().find(|x| (*x % 2) == 0);
        assert_eq!(first_even, Some(&8));}

    // Q35: iter position
    #[test]
    fn q35_iter_position() {
        let v = vec!["cat", "dog", "bird"];
	// find "dog"
        let pos: Option<usize> = v.iter().position(|x| *x == "dog");
        assert_eq!(pos, Some(1));}

    // Q36: iter fold (reduce with initial value)
    #[test]
    fn q36_iter_fold() {
        let v = vec![1, 2, 3, 4];
        let product = v.iter().fold(1, |acc, x| acc * *x); // multiply all
        assert_eq!(product, 24);}

    // Q37: iter zip
    #[test]
    fn q37_iter_zip() {
        let names = vec!["alice", "bob"];
        let ages = vec![30, 25];
        let pairs: Vec<(&&str, &i32)> = names.iter().zip(ages.iter()).collect();
        assert_eq!(pairs[0], (&"alice", &30));
        assert_eq!(pairs[1], (&"bob", &25));}

    // Q38: iter chain
    #[test]
    fn q38_iter_chain() {
        let a = vec![1, 2];
        let b = vec![3, 4];
        let combined: Vec<&i32> = a.iter().chain(b.iter()).collect(); // chain a and b iters
        assert_eq!(combined, vec![&1, &2, &3, &4]);}

    // ===== LEVEL 6: mutating collections =====

    // Q39: vec retain (keep elements matching predicate)
    #[test]
    fn q39_vec_retain() {
        let mut v = vec![1, 2, 3, 4, 5, 6];
        v.retain(|x| *x % 2 == 0); // keep even numbers
        assert_eq!(v, vec![2, 4, 6]);}

    // Q40: vec dedup (remove consecutive duplicates)
    #[test]
    fn q40_vec_dedup() {
        let mut v = vec![1, 1, 2, 3, 3, 3, 4];
        v.dedup(); // remove consecutive duplicates
        assert_eq!(v, vec![1, 2, 3, 4]);}

    // Q41: vec sort
    #[test]
    fn q41_vec_sort() {
        let mut v = vec![3, 1, 4, 1, 5];
        v.sort(); // sort ascending
        assert_eq!(v, vec![1, 1, 3, 4, 5]);}

    // Q42: vec sort descending
    #[test]
    fn q42_vec_sort_desc() {
        let mut v = vec![3, 1, 4, 1, 5];
        v.sort_by(|a, b| b.cmp(a));
        assert_eq!(v, vec![5, 4, 3, 1, 1]);}

    // Q43: vec reverse
    #[test]
    fn q43_vec_reverse() {
        let mut v = vec![1, 2, 3];
        v.reverse();
        assert_eq!(v, vec![3, 2, 1]);}

    // Q44: vec truncate
    #[test]
    fn q44_vec_truncate() {
        let mut v = vec![1, 2, 3, 4, 5];
        v.truncate(3); // keep only first 3 elements
        assert_eq!(v, vec![1, 2, 3]);}

    // Q45: vec split_off
    #[test]
    fn q45_vec_split_off() {
        let mut a = vec![1, 2, 3, 4, 5];
        let b = a.split_off(3); // split off from index 3
        assert_eq!(a, vec![1, 2, 3]);
        assert_eq!(b, vec![4, 5]);}

    // Q46: vec swap
    #[test]
    fn q46_vec_swap() {
        let mut v = vec![1, 2, 3];
        v.swap(0,2); // swap index 0 and 2
        assert_eq!(v, vec![3, 2, 1]);}

    // ===== LEVEL 7: slice operations =====

    // Q47: slice contains
    #[test]
    fn q47_slice_contains() {
        let s: &[i32] = &[1, 2, 3, 4, 5];
        assert_eq!(s.contains(&3), true);
        assert_eq!(s.contains(&9), false);}

    // Q48: slice windows (sliding window)
    #[test]
    fn q48_slice_windows() {
        let v = vec![1, 2, 3, 4];
        let wins: Vec<&[i32]> = v.windows(2).collect();
        assert_eq!(wins, vec![&[1,2], &[2,3], &[3,4]]);}

    // Q49: slice chunks
    #[test]
    fn q49_slice_chunks() {
        let v = vec![1, 2, 3, 4, 5, 6];
        let chunks: Vec<&[i32]> = v.chunks(2).collect();
        assert_eq!(chunks, vec![&[1,2], &[3,4], &[5,6]]);}

    // Q50: slice split_at
    #[test]
    fn q50_slice_split_at() {
        let a = [1, 2, 3, 4, 5];
        let (left, right) = a.split_at(3);
        assert_eq!(left, [1,2,3]);
        assert_eq!(right, [4,5]);}

    // Q51: slice iter rev
    #[test]
    fn q51_slice_rev() {
        let a = [1, 2, 3];
        let reversed: Vec<&i32> = a.iter().rev().collect();
        assert_eq!(reversed, vec![&3,&2,&1]);}

    // Q52: slice binary_search (sorted slice)
    #[test]
    fn q52_binary_search() {
        let a = [1, 3, 5, 7, 9];
        assert_eq!(a.binary_search(&5), Ok(2)); 
        assert_eq!(a.binary_search(&4).is_err(), true); }

    // ===== LEVEL 7b: borrow lifecycle with collections =====

    // Q52a: borrow ends after last use, then mutate
    #[test]
    fn q52a_borrow_then_mutate() {
        let mut v = vec![1, 2, 3];
	v.push(4); // can compile
        let s = &v[..];     
        let len = s.len();
        // v.push(5); // can't compile
        assert_eq!(len, 4);
        assert_eq!(v, vec![1,2,3,4]);}

    // Q52b: borrow still alive — can't mutate
    #[test]
    fn q52b_borrow_still_alive() {
        let mut v = vec![1, 2, 3];
	v.push(4);
        let s = &v[..];
	// v.push(5); 
	assert_eq!(s.len(), 4);}

    // Q52c: slice borrow scope
    #[test]
    fn q52c_slice_scope() {
        let mut v = vec![10, 20, 30];
        let first = v[0];      // copy the value (i32 is Copy)
        v.push(40);
        assert_eq!(first, 10);
        assert_eq!(v.len(), 4);}

    // Q52d: multiple immutable borrows are fine
    #[test]
    fn q52d_multi_immut_borrow() {
        let v = vec![1, 2, 3, 4];
        let s1 = &v[..2];
        let s2 = &v[2..];
        // both alive at the same time — does this compile? (true/false)
        assert_eq!(s1, &vec![1,2]);
        assert_eq!(s2, &vec![3,4]);}

    // Q52e: reborrow after borrow ends
    #[test]
    fn q52e_reborrow() {
        let mut v = vec![1, 2, 3];
        let s1 = &v[..];
        assert_eq!(s1.len(), 3); // s1 last use — borrow ends
        v.push(4); // mutate OK
        let s2 = &v[..]; // new borrow
        assert_eq!(s2.len(), 4);}

    // Q52f: function borrows then returns — original usable after
    #[test]
    fn q52f_fn_borrow_return() {
        fn first(s: &[i32]) -> i32 { s[0] }
        let mut v: Vec<i32> = vec![10, 20, 30];
        let f: i32 = first(&v); // borrow starts and ends inside first()
        v.push(40); // mutate OK — borrow is over
        assert_eq!(f, 10);
        assert_eq!(v.len(), 4);}

    // Q52g: mutable borrow via slice
    #[test]
    fn q52g_mut_slice() {
        let mut v: Vec<i32> = vec![1, 2, 3];
        let s: &mut [i32] = &mut v[..]; // mutable slice
        s[0] = 10;
        s[2] = 30;
        // s last use above — borrow ends
        assert_eq!(v, vec![10, 2, 30]);}

    // Q52h: can't have immut and mut borrow at the same time
    // this test intentionally does NOT compile.
    // uncomment, read the error, then re-comment.
    #[test]
    fn q52h_immut_and_mut() {
        let mut v: Vec<i32> = vec![1, 2, 3];
        // let s: &[i32] = &v[..]; // immutable borrow
        let ms = &mut v[..]; // mutable borrow — conflict!
	assert_eq!(ms, &vec![1,2,3]);}

    // Q52i: loop borrows and mutates in turns
    #[test]
    fn q52i_loop_borrow() {
        let mut v: Vec<i32> = vec![1, 2, 3];
        for _ in 0..3 {
	    // borrows (via &self), ends immediately
            let len: usize = v.len();
	    // mutate OK
            v.push(len as i32);}
        assert_eq!(v, vec![1,2,3,3,4,5]);}

    // Q52j: get returns Option<&T> — borrow lasts until Option is dropped
    #[test]
    fn q52j_get_borrow() {
        let mut v: Vec<i32> = vec![1, 2, 3];
	// .copied() extracts the value, ending the borrow
        let second: Option<i32> = v.get(1).copied();
        v.push(4);
        assert_eq!(second, Some(2));
        assert_eq!(v.len(), 4);}

    // Q52k: without .copied(), the borrow lives longer
    // this test intentionally does NOT compile.
    // uncomment, read the error, then re-comment.
    #[test]
    fn q52k_get_borrow_alive() {
        let mut v: Vec<i32> = vec![1, 2, 3];
	// second is Option<&i32> — borrow alive
        let second: Option<&i32> = v.get(1);  
	// mutate while borrow alive — error!
	assert_eq!(second, Some(&2));
	v.push(4);              
	assert_eq!(v.len(), 4);}

    // ===== LEVEL 8: ownership and borrowing with collections =====

    // Q53: moving vs borrowing a vec
    #[test]
    fn q53_borrow_vec() {
        fn sum(v: &Vec<i32>) -> i32 { (*v).iter().sum() }
        let v: Vec<i32> = vec![1, 2, 3];
        let s: i32 = sum(&v);
        assert_eq!(s, 6);
	// v is still usable
        assert_eq!(v.len(), 3);}

    // Q54: prefer slice over &Vec
    #[test]
    fn q54_prefer_slice() {
        fn sum(s: &[i32]) -> i32 { s.iter().sum() }
        let arr: [i32; 3] = [1, 2, 3];
        let vec: Vec<i32> = vec![4, 5, 6];
        assert_eq!(sum(&arr), 6);
        assert_eq!(sum(&vec), 15);}

    // Q55: into_iter consumes the vec
    #[test]
    fn q55_into_iter() {
        let v = vec![1, 2, 3];
        let mut sum = 0;
        for x in v.into_iter() { sum += x; }
        assert_eq!(sum, 6);
        // v is no longer usable here
    }

    // Q56: iter vs into_iter vs iter_mut
    #[test]
    fn q56_iter_kinds() {
        let mut v: Vec<i32> = vec![1, 2, 3];
        // iter: borrows each element as &T
        let sum: i32 = v.iter().sum();
        assert_eq!(sum, 6);
        // iter_mut: borrows each element as &mut T
        for x in v.iter_mut() { *x *= 10; }
        assert_eq!(v, vec![10, 20, 30]);
        // into_iter: takes ownership of each element
        let doubled: Vec<i32> = v.into_iter().map(|x| x * 2).collect();
        assert_eq!(doubled, vec![20, 40, 60]);}

    // ===== LEVEL 9: advanced patterns =====

    // Q57: flatten nested vecs
    #[test]
    fn q57_flatten() {
        let nested: Vec<Vec<i32>> = vec![vec![1, 2], vec![3], vec![4, 5]];
        let flat: Vec<&i32> = nested.iter().flat_map(|v: &Vec<i32>| v.iter()).collect();
        assert_eq!(flat, vec![&1,&2,&3,&4,&5]);}

    // Q58: collect into a string
    #[test]
    fn q58_collect_string() {
        let chars: Vec<char> = vec!['h', 'e', 'l', 'l', 'o'];
        let s: String = chars.iter().collect(); // collect chars into a String
        assert_eq!(s, "hello");}

    // Q59: partition
    #[test]
    fn q59_partition() {
        let v: Vec<i32> = vec![1, 2, 3, 4, 5, 6];
        let (evens, odds): (Vec<i32>, Vec<i32>) =
            v.into_iter().partition(|x| *x % 2 == 0);
        assert_eq!(evens, vec![2, 4, 6]);
        assert_eq!(odds, vec![1, 3, 5]);}

    // Q60: unzip
    #[test]
    fn q60_unzip() {
        let pairs: Vec<(i32, &str)> = vec![(1, "a"), (2, "b"), (3, "c")];
        let (nums, letters): (Vec<i32>, Vec<&str>) = pairs.into_iter().unzip();
        assert_eq!(nums, vec![1,2,3]);
        assert_eq!(letters, vec!["a","b","c"]);}

    // Q61: take and skip with iterators
    #[test]
    fn q61_take_skip() {
        let v: Vec<i32> = vec![1, 2, 3, 4, 5];
        let first3: Vec<&i32> = v.iter().take(3).collect();
        let after2: Vec<&i32> = v.iter().skip(2).collect();
        assert_eq!(first3, vec![&1,&2,&3]);
        assert_eq!(after2, vec![&3,&4,&5]);}

    // Q62: min and max
    #[test]
    fn q62_min_max() {
        let v = vec![3, 1, 4, 1, 5, 9];
        assert_eq!(v.iter().min(), Some(&1));
        assert_eq!(v.iter().max(), Some(&9));}}
