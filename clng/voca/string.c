#include <stdio.h>

int main() {
  // declare a string var
  char greeting[] = "Hello world!";
  // like regular array, var is address of the first item
  printf("%p\n", greeting);
  printf("%p\n", &greeting[0]);
  // string has a way to print the whole
  printf("%s\n", greeting);
  // access a char of string
  printf("%c\n", greeting[2]);
  // char is actually int
  printf("%i\n", greeting[2]);
  // char array is actually same as int array
  char test[] = {78, 98, 108};
  printf("%s\n", test);
  // char array can be an array of characters
  char hello[] = {'h', 'e', 'l', 'l', 'o'};
  printf("%s\n", hello);
}
