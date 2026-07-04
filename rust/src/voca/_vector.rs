#[cfg(test)]
mod test_vector {
    #[test]
    fn basics() {
        let mut v = Vec::new();
        let n = 1 + 2;
        v.push(n);
        v.push(7);
        v.push(11);
        assert_eq!(vec![3, 7, 11], v);
        assert_eq!(7, v[1]);}

    // Q1: vec에서 마지막 원소를 제거하고 그 값을 얻으려면?
    #[test]
    fn q1_pop() {
        let mut v = vec![10, 20, 30];
        let last = v.pop();
        assert_eq!(Some(30), last);
        assert_eq!(vec![10, 20], v);}

    // Q2: vec의 길이와 비어있는지 확인
    #[test]
    fn q2_len_empty() {
        let v: Vec<i32> = vec![1, 2, 3];
        assert_eq!(3, v.len());
        assert_eq!(false, v.is_empty());}

    // Q3: 특정 인덱스에 원소 삽입
    #[test]
    fn q3_insert() {
        let mut v = vec![1, 3, 4];
        v.insert(1,2);
        assert_eq!(vec![1, 2, 3, 4], v);}

    // Q4: 특정 인덱스의 원소 제거
    #[test]
    fn q4_remove() {
        let mut v = vec![1, 99, 2, 3];
        let removed = v.remove(1);
        assert_eq!(99, removed);
        assert_eq!(vec![1, 2, 3], v);}

    // Q5: vec에 특정 값이 포함되어 있는지?
    #[test]
    fn q5_contains() {
        let v = vec!["apple", "banana", "cherry"];
        assert_eq!(true, v.contains(&"banana"));
        assert_eq!(false, v.contains(&"grape"));}

    // Q6: 두 vec을 합치기 (원본 소비 없이)
    #[test]
    fn q6_extend() {
        let mut a = vec![1, 2];
        let b = vec![3, 4];
        a.extend(&b);
        assert_eq!(vec![1, 2, 3, 4], a);
	assert_eq!(vec![3, 4], b);}
   
    // Q7: iter로 각 원소를 2배로 만든 새 vec
    #[test]
    fn q7_map() {
        let v = vec![1, 2, 3];
        let doubled: Vec<i32> = v.iter().map(|x| x * 2).collect();
        assert_eq!(vec![2, 4, 6], doubled);}

    // Q8: 짝수만 필터링
    #[test]
    fn q8_filter() {
        let v = vec![1, 2, 3, 4, 5, 6];
        let evens: Vec<&i32> = v.iter().filter(|x| *x % 2 == 0).collect();
        assert_eq!(vec![&2, &4, &6], evens);}}
