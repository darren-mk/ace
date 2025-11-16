# https://www.geeksforgeeks.org/python/comprehensions-in-python/

def test_list():
    nums = [1,2,3,4,5]
    assert [ num for num in nums ] == nums    
    assert [ num * 10 for num in nums ] == [10,20,30,40,50]
    assert [ num for num in nums if num < 3 ] == [1,2]
    assert [[0 for _ in range(3)] for _ in range(3)] == [[0,0,0], [0,0,0], [0,0,0]]
    
def test_dict():
    nums = [1,2,3,4,5]
    assert { num: "ye" for num in nums } == {1: "ye", 2: "ye", 3: "ye", 4: "ye", 5: "ye"}
    assert { num: num for num in nums } == {1:1, 2:2, 3:3, 4:4, 5:5}
    assert { num: num * 10 for num in nums } == {1:10, 2:20, 3:30, 4:40, 5:50}
    
def test_set():
    nums = [1,2,3,4,5]
    assert { num for num in nums } == {1,2,3,4,5}
    assert { num * 10 for num in nums } == {10,20,30,40,50}

