#include <cassert>
#include <iostream>
using namespace std;

int main() {
  const std::vector<int>& arr = {4, 5, 6};
  assert(3 == arr.size());
  assert(4 == arr[0]);
  assert(0 == arr[10]);
  return 0;
}
