#include <stdio.h>

int main() {
  // declare a 2d array
  int matrix[2][3] = {{1, 2, 3},{4, 5, 6}};
  // array var is address of first item
  printf("%p\n", matrix);
  // get an item from 2d array
  printf("%i\n", matrix[1][1]);
  // get every item by loop
  int i, j;
  for (i = 0; i < 2; i++) {
    for (j = 0; j < 3; j++) {
      printf("%i,", matrix[i][j]);
    }
  };
}
