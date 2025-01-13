require 'minitest/autorun'

class Person 
  attr_accessor :name, :email
  def initialize(name, email)
    @name = name
    @email = email 
  end
end

=begin 
class Author < Person
  def initialize(debut_year)
    @debut_year = debut_year    
  end
end

class Book
  def initialize(title, author)
    @title = title
    @author = author   
  end
end

class LearnClass < Minitest::Test

  def insertion
    nums_b = [1, 2, 3]
    nums_b << 4
    assert_equal [1, 2, 3, 4], numbs_b
  end

end

LearnClass.new(:extraction).run
LearnClass.new(:insertion).run
=end
