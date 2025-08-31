#include <cassert>
#include <utility>
#include <vector>
#include <tuple>
#include <unordered_map>
using namespace std;

class Solution {
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> seen;
    for (int i = 0; i < int(nums.size()); i++) {
      int x = nums[i];
      int need = target - x;
      auto it = seen.find(need);
      if (it != seen.end()) {
        return {it->second, i};
      } else {
        seen[x] = i;
      }
    }
    return {0,0};
  }
};

using Input = vector<int>;
using Target = int;
using Answer = vector<int>;
using TestCase = tuple<Input, Target, Answer>;

std::vector<TestCase> testCases = {
  {{2, 7, 11, 15}, 9, {0, 1}},
  {{3, 2, 4}, 6, {1, 2}},
  {{3, 3}, 6, {0, 1}}};

int main() {
  Solution solution = Solution();
  for (auto tc : testCases) {
    assert(get<2>(tc) == solution.twoSum(get<0>(tc), get<1>(tc)));  
  }
  return 0;
}
