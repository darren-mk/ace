require 'minitest/autorun'

class LearnHash < Minitest::Test

  def extraction
    hash_a = { 1 => "you", 2 => "me" }
    assert_equal "you", hash_a[1]
  end

end

Minitest.run
