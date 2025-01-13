require 'minitest/autorun'

class LearnEach < Minitest::Test

  def on_array
    sum = 0
    [1, 2, 3, 4, 5].each { | n |
      puts n
      sum = sum + n }
    assert_equal 15, sum
  end

  def on_hash
    sum = 0
    {1 => 2, 3 => 4}.each {|k, v|
      sum = sum + (k * v)}
    assert_equal 14, sum    
  end

end

def run
  LearnEach.runnable_methods.each do |method|
  LearnEach.new(method).run
  end
end




