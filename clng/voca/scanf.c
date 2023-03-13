#include <stdio.h>

int main() {
  char userInput[20];
  printf("type: ");
  scanf("%[^\n]%*c", userInput);
  printf("you entered %s.\n", userInput);
  return 0;
}
