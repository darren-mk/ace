require 'minitest/autorun'

class StringInterpolation < Minitest::Test
  def t1
    age = 20
    name = "David"
    result = "Hello #{name}, you're #{age} years old!".strip
    puts result
    exp = "Hello David, you're 20 years old!".strip
    puts exp
    assert_equal exp, result
  end
end

StringInterpolation.new(:t1).run
