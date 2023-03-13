#include <stdio.h>
#include <stdlib.h>

char * buffer;

void getUserEntry() {
  buffer = malloc(sizeof(char) * 5);
  printf("enter: ");
  fgets(buffer, 15, stdin);
}

int main () {
  getUserEntry();
  printf("your entry: %s\n", buffer);
  return 0;
}
