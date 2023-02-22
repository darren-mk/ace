#include <stdio.h>

int main () {
   FILE *file;
   int size = 60;
   char str[size];
   /* opening file for reading */
   file = fopen("file.txt" , "r");
   if(file == NULL) {
      perror("Error opening file");
      return(-1);
   }
   char * result = fgets(str, size, file);
   if(result != NULL) {
      puts(str);
   }
   fclose(file);
   return(0);
}
