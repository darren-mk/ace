#include <cassert>
#include <unordered_map>
#include <string>
using namespace std;

int main() {
  // declaration
  unordered_map<string, int> um;
  // insertion
  um["Alice"] = 90;
  um["Jane"] = 37;
  // size
  assert(2 == um.size());
  // pull
  assert(90 == um["Alice"]);
  // returns default constructor of the type
  // when the key isn't included
  assert(0 == um["Molly"]);
  // inclusion check
  assert(um.find("Alice") != um.end());
  assert(um.find("Nadia") == um.end());
}
