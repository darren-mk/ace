#include <stdio.h>

int main() {
  // declare an array
  int myNums[] = {1, 2, 3, 4, 5};
  // array var is a pointer to the first element
  printf("%p\n", myNums);
  // get an element from an array
  printf("%i\n", myNums[0]);
  // get the address of the first element
  // which is the same as the address of var
  printf("%p\n", &myNums[0]);
  // get the address of second item
  // which is 4 (4 bits or 1 byte) higher than the first
  printf("%p\n", &myNums[1]);
  // change an item from array
  myNums[2] = 100;
  printf("%i\n", myNums[2]);
  // print all items using loop
  int i;
  for (i = 0; i < 5; i++) {
    printf("%i, ", myNums[i]);
  };
}
