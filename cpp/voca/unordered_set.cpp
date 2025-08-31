#include<unordered_set>
#include<cassert>
using namespace std;

int main() {
  // declaration
  unordered_set<int> us;
  // insertion
  us.insert(1);
  us.insert(3);
  us.insert(5);
  assert(3 == us.size());
  // equality
  assert((unordered_set<int> {1, 3, 5}) == us);
  // inclusion
  assert(us.find(3) != us.end());
  assert(us.find(7) == us.end());
}
