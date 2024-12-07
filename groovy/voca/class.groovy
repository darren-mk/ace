class Book {
    private String title
    Book (String givenTitle) {
        title = givenTitle
    }
    String getTitle() {
        return title
    }
}

String myFirstBookTitle = "How to Have Fun?"
Book myFirstBook = new Book(myFirstBookTitle)
assert myFirstBook.getTitle() == myFirstBookTitle
