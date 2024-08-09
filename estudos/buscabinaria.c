#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/**
 * Gabriel Xavier Borges
 * Apenas para estudo
 * Busca binaria
 */

int main ( void )
{
	int array [56] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56
};
	int n = 56;
	int esquerda = 0, direita = n - 1, meio, diferenca;
	int x = 0;
	scanf("%d", &x);
	bool resp = false;

	while(esquerda <= direita)
	{
		meio = (esquerda + direita) / 2;
		diferenca = x - array[meio];
		if(diferenca == 0) // testar se X == valor do meio
		{
			esquerda = direita + 1; // sair do loop
			resp = true; 
		}
		else if(diferenca > 0)
		{
			esquerda = meio + 1;
		}
		else
		{
			direita = meio - 1;
		}
	}

	if(true)
	{
		printf("numero encontrado\n");
	}
	else
	{
		printf("numero nao encontrado.\n");
	}
	return 0;
}
