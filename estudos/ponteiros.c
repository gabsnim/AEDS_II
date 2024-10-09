#include <stdio.h>
#include <stdlib.h>

typedef struct teste
{
    int *w;
};


int main (int argc, char** argv)
{
    int y = 5;
    int *x = NULL;
    x = malloc(1 * sizeof(int));
    x[0] = 3;
    printf("\n%d %d", y, x[0]);
}