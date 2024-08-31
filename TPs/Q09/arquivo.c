/**
 * Gabriel Xavier Borges - 805347 - Q09
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

/**
 * Metodo para escrever numeros no arquivo binario
 * @param string (nome do arquivo)
 * @param int n
 */
void writeFile(char *filename, int n)
{
    FILE *arquivo = fopen(filename, "wb");
    double x = 0.0;
    if (arquivo != NULL)
    {
        for (int i = 0; i < n; i++)
        {
            scanf("%lf", &x);
            fwrite(&x, sizeof(double), 1, arquivo);
        }
    }
    fclose(arquivo);
}

/**
 * Metodo para printar os numeros no formato adequado ignorando os digitos inuteis
 * @param double x
 */
void print(double x)
{
    char *str = (char *)(malloc(100 * sizeof(char)));

    sprintf(str, "%.10lf", x);

    char* decimalp = strchr(str, '.');

    if (decimalp != NULL) {
        
        char* end = str + strlen(str) - 1;
        while (end > decimalp && *end == '0')
        {
            *end = '\0';
            end--;
        }

        if (*end == '.')
        {
            *end = '\0';
        }
    }

    printf("%s\n", str);
    free(str);
}

/**
 * Metodo para ler numeros do arquivo binario
 * @param string (nome do arquivo)
 * @param int n
 */
void readFile(char *filename, int n)
{
    FILE *arquivo = fopen(filename, "rb");
    double x = 0.0;

    if (arquivo != NULL)
    {
        for (int i = 0; i < n; i++)
        {
            fseek(arquivo, (n - i - 1) * sizeof(double), SEEK_SET);
            fread(&x, sizeof(double), 1, arquivo);
            print(x);
        }
    }
    fclose(arquivo);
}

/**
 * Funcao principal
 * @param int agrc
 * @param char* argv[]
 */
int main(int agrc, char *argv[])
{
    int n = 0;
    scanf("%d", &n);

    writeFile("saida.txt", n);

    readFile("saida.txt", n);

    return 0;
}