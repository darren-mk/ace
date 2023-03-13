#include <stdio.h>
#include <stdlib.h>

/*

int main() {
  char * buffer = 0;
  long length = 0;
  FILE * fp = fopen ("file.txt", "rb");

  if (fp) {
    fseek (fp, 0, SEEK_END);
    length = ftell (fp);
    fseek (fp, 0, SEEK_SET);
    buffer = malloc (length);
    if (buffer) {
      fread (buffer, 1, length, fp);
    }
    fclose (fp);
  }

  printf("%li", length);
}
*/

int main() {
  char * buffer = 0;
  int length = 0;
  FILE * fp = fopen ("file.txt", "rb");
  fseek(fp, SEEK_SET, SEEK_END);
  length = ftell(fp);
  printf("%i", length);
}
