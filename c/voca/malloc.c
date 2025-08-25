#include <stdio.h>
#include <stdlib.h>

void print_each(int array[], int size) {
  for (int i = 0; i < size; i++) {
    printf("%i\n", array[i]); } }

int main() {
  int size = 3;
  int* arr;
  arr = malloc(sizeof(int) * size);
  for (int i = 0; i < size; i++) {
    arr[i] = i * 100; }
  print_each(arr, size);
  free(arr); }
