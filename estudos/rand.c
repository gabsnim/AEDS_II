#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

int main (int argc, char* argv[])
{
    int* x = NULL;
    x = malloc(1 * sizeof(int));
    int i = 0;
    bool is = false;

    // while (!is)
    // {
    //     printf("%d\n", x[i]);
    //     if(x == 0)
    //     {
    //         is = true;
    //     }
    //     i++;
    // }
    
    for(int i = 0; i < 10; i++)
    {
        printf("%d\n", x[i]);
    }
    
    //printf("%d\n", x[6]); 
}