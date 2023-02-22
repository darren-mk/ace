#include <stdio.h>

int main() {
  char c;
  printf("enter character: ");
  c = getc(stdin);
  printf("a character entered: ");
  putc(c, stdout);
  return 0;
}
