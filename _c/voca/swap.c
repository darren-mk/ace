#include <stdio.h>

void swap(int* a, int* b) {
  int temp;
  temp = *a;
  *a = *b;
  *b = temp;
}

int main() {
  int x = 2;
  int y = 3;
  swap(&x, &y);
  printf("x: %i\n", x);
  printf("y: %i\n", y);
}
