require 'minitest/autorun'

class Size < Minitest::Test
  def t1
    assert_equal 3, 'abc'.size
  end
end

Size.new(:t1).run
