require 'minitest/autorun'

class Chars < Minitest::Test
  def t1
    result = "abc".chars
    puts result
    exp = ["a", "b", "c"]
    puts exp 
    assert_equal exp, result
  end
end

Chars.new(:t1).run
