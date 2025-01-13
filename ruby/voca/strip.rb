require 'minitest/autorun'

class Strip < Minitest::Test
  def t1
    result = "  abc ".strip
    puts result
    exp = "abc"
    puts exp
    assert_equal exp, result
  end
end

Strip.new(:t1).run
