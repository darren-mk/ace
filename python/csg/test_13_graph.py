class Person:
    def __init__(self, name):
        self.name = name 
        self.friends = []
    def add_friend(self, friend):
        self.friends.append(friend)

def test_person_initiation():
    mary = Person("Mary")
    peter = Person("Peter")
    mary.add_friend(peter)
    peter.add_friend(mary)
    assert mary.friends == [ peter ]