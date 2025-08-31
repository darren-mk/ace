#include <cassert>
#include <set>
#include <iostream>
using namespace std;

int main() {

  // declaration
  set<int> s;
  assert(0 == s.size());

  // insertion
  // would not work if declared const
  s.insert(1);
  s.insert(2);
  s.insert(3);
  assert(3 == s.size());

  // insertion repeating
  // no error, but no duplication
  s.insert(2);
  assert(3 == s.size());

  // inclusion
  auto it = s.find(2);
  assert(it != s.end());
  assert(*it == 2);
  auto none = s.find(10);
  assert(none == s.end());

  // accessing by order
  auto first_elem = s.begin();
  assert(*first_elem == 1);
  auto third_elem = next(first_elem, 2);
  assert(*third_elem == 3);

}
