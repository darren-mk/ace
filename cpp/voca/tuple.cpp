#include <cassert>
#include <tuple>
#include <string>
using namespace std;

int main() {
  // declaration
  tuple<int, double, string> t1(42, 3.14, "hello");
  // get
  assert(42 == get<0>(t1));
  assert(3.14 == get<1>(t1));
  assert("hello" == get<2>(t1));
}
