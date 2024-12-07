import groovy.transform.Immutable

@Immutable class FixedBook {
    String title
}

def b1 = new FixedBook('Hug')
def b2 = new FixedBook(title: 'Act')

assert b1.title == 'Hug'
assert b2.title == 'Act'

try {
    b1.title = "Oop"
    assert false, "should not reach here"
} catch (ReadOnlyPropertyException expected) {
    println "expected error: '$expected.message'" 
}
