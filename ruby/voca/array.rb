require 'minitest/autorun'

class LearnArray < Minitest::Test

  def extraction
    nums = [1, 2, 3]
    assert_equal 1, nums[0]
    assert_equal 2, nums[1]
  end

  def insertion
    nums_b = [1, 2, 3]
    nums_b << 4
    assert_equal [1, 2, 3, 4], numbs_b
  end

end

LearnArray.new(:extraction).run
LearnArray.new(:insertion).run
