#include <string>
#include <cassert>
using namespace std;

int main() {
  // declaration
  string s = "Hello";
  // pull char
  assert('H' == s[0]);
  assert('e' == s[1]);
  // replace char
  s[0] = 'h';
  assert('h' == s[0]);
  // add char
  s[5] = '!';
  assert("hello" == s);
}
