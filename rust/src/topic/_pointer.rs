#[cfg(test)]
mod test_pointer {
    #[test]
    fn basics() {
        let x: i32 = 42;
        let r: &i32 = &x;
        assert_eq!(*r, 42);}

    // Q1: create a reference with &
     #[test]
     fn q1_make_ref() {
         let x: i32 = 10;
         let r: &i32 = &x;
         assert_eq!(r, &10);}

    // Q2: dereference with *
    #[test]
    fn q2_deref() {
        let x = 7;
        let r = &x;
        let val: i32 = *r;
        assert_eq!(val, 7);}

    // Q3: a ref sees the same value as the original
    #[test]
    fn q3_same_value() {
        let x = 42;
        let r = &x;
        assert_eq!(*r == x, true); }

    // Q4: what is the type of a reference?
    #[test]
    fn q4_ref_type() {
        let x: i32 = 5;
        let r: &i32 = &x;
        assert_eq!(*r, 5); }

    // Q5: does this compile? if not, why?
    #[test]
    fn q5_mut_while_borrowed() {
        let x: i32;
        x = 20;
        let r: &i32 = &x;
        assert_eq!(*r, 20); }

    // Q6: comparing refs
    #[test]
    fn q6_compare_refs() {
        let a = 3;
        let b = 3;
        let ra = &a;
        let rb = &b;
        assert_eq!(ra, rb);}

    // Q6b: == compares values, std::ptr::eq compares addresses
    #[test]
    fn q6b_ptr_eq() {
        let a = 3;
        let b = 3;
        let r1 = &a;
        let r2 = &a;
        let r3 = &b;
        assert_eq!(r1, r3);
        assert_eq!(std::ptr::eq(r1, r2), true);
        assert_eq!(std::ptr::eq(r1, r3), false);}

    // --- intermediate ---

    // Q7: mutate through a mutable reference
    #[test]
    fn q7_mut_ref() {
        let mut x: i32 = 10;
        let r: &mut i32 = &mut x;
        *r = 20;
        assert_eq!(x, 20);}

    // Q8: double reference
    #[test]
    fn q8_double_ref() {
        let x = 5;
        let r1 = &x;
        let r2 = &r1;
        assert_eq!(**r2, 5);}

    // Q9: pass a reference to a function (borrowing)
    #[test]
    fn q9_fn_borrow() {
        fn add_ten(n: &i32) -> i32 { *n + 10 }
        let x = 5;
        assert_eq!(add_ten(&x), 15);
        assert_eq!(x, 5);}

    // Q10: pass a mutable reference to a function
    #[test]
    fn q10_fn_mut_borrow() {
        fn double(n: &mut i32) { *n = *n * 2 }
        let mut x = 7;
        double(&mut x);
        assert_eq!(x, 14);}

    // Q11: slices are references too
    #[test]
    fn q11_slice_is_ref() {
        let v = vec![1, 2, 3, 4, 5];
        let s: &[i32] = &v[1..4]; // slice of v, index 1 to 3
        assert_eq!(s, &[2, 3, 4]);
        assert_eq!(s.len(), 3);}}
