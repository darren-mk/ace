require 'minitest/autorun'

class Upcase < Minitest::Test
  def t1
    assert_equal 'ABC', 'abc'.upcase
  end
end

Upcase.new(:t1).run
