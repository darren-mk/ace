#include <stdio.h>

int main() {
  // get address of regular var
  int myAge = 43;
  printf("%i\n", myAge);
  printf("%p\n", &myAge);
  // store address in var
  int yourAge = 33;
  int * pointerYourAge = &yourAge;
  printf("%i\n", yourAge);
  printf("%p\n", &yourAge);
  printf("%p\n", pointerYourAge);
  // dereference
  int hisAge = 40;
  int * pointerHisAge = &hisAge;
  printf("%i\n", hisAge);
  printf("%p\n", pointerHisAge);
  printf("%i\n", *pointerHisAge);
}
