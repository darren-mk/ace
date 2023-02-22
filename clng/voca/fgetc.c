// https://www.tutorialspoint.com/
// c_standard_library/c_function_fgetc.htm

#include <stdio.h>
#include <string.h>

int main() {
  FILE *fp;
  int c;
  fp = fopen("file.txt", "r");
  if (fp == NULL) {
    perror("error in opening file");
    return(-1);
  } do {
    c = fgetc(fp);
    if (feof(fp)) {
      break;
    }
    printf("%c", c);
  } while(1);
  fclose(fp);
  return 0;
}
