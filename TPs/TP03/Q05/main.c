#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 5 //fila circular
#define MAX_POKEMONS 801
#define MAX_ABILITIES 8
#define MAX_TYPES 2
#define CAMINHO_PC "/home/gabs/faculdade/AEDS_II/pokemon.csv"
#define CAMINHO_VERDE "/tmp/pokemon.csv"
#define null NULL;

typedef struct Pokemon
{
    int id;
    int generation;
    char *name;
    char *description;
    char **types;
    char **abilities;
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    char *captureDate;
} pokemon;

typedef pokemon *pokeref;


/**
 * Construtor padrao -> init (valor inicial)
 */
pokeref init()
{
    //printf("fiz");
    pokeref poke = malloc(1 * sizeof(pokemon));
    if(poke == NULL)
    {
        printf("FALHA AO ALOCAR MEMORIA PARA POKEMON");
        exit(1);
    }

    poke->id = 0;
    poke->generation = 0;
    poke->name = malloc(80 * sizeof(char)); strcpy(poke->name, "name");
    poke->description = malloc(80 * sizeof(char)); strcpy(poke->description, "description");

    poke->types = (char **)malloc(2 * sizeof(char *));  //2 posicoes no array com capacidade de 80 caracteres por posicao
    for(int i = 0; i < 2; i++)
    {
        poke->types[i] = (char *)malloc(80 * sizeof(char));
        if(poke->types[i] == NULL) printf("ERRO AO ALOCAR MEMORIA PARA TIPOS");
    }

    poke->abilities = (char **)malloc(MAX_ABILITIES * sizeof(char *));  //8 posicoes no array com capacidade de 80 caracteres por posicao
    for(int i = 0; i < MAX_ABILITIES; i++)
    {
        poke->abilities[i] = (char *)malloc(80 * sizeof(char));
        if(poke->abilities[i] == NULL) printf("ERRO AO ALOCAR MEMORIA PARA HABILIDADES");
    }

    poke->weight = 0.0;
    poke->height = 0.0;
    poke->captureRate = 0;
    poke->isLegendary = 0;
    poke->captureDate = (char *)malloc(80 * sizeof(char)); strcpy(poke->captureDate, "00/00/0000");

    //printf("\nfiz e retornei\n");
    return poke;
}

/**
 * Destrutor 
 */
void destrutor (pokeref poke)
{
    if(poke == NULL) return;

    if (poke->types != NULL)
    {
        for (int i = 0; i < 2; i++)
        {
            free(poke->types[i]);
        }
        free(poke->types); 
    }

    if (poke->abilities != NULL) 
    {
        for (int i = 0; i < 8; i++) 
        {
            free(poke->abilities[i]); 
        }
        free(poke->abilities); 
    }

    free(poke->name);
    free(poke->description);
    free(poke->captureDate);

    free(poke);
}

int getId(pokeref poke) {return poke->id;}

int getGeneration(pokeref poke) {return poke->generation;}

char* getName(pokeref poke) {return poke->name;}

char* getDescription(pokeref poke) {return poke->description;}

char* getType(pokeref poke, int index) {if (index >= 0 && index < 5) {return poke->types[index];} return NULL;}

char* getAbility(pokeref poke, int index){if (index >= 0 && index < 5) {return poke->abilities[index];} return NULL;}

double getWeight(pokeref poke) {return poke->weight;}

double getHeight(pokeref poke) {return poke->height;}

int getCaptureRate(pokeref poke) {return poke->captureRate;}

bool isLegendary(pokeref poke) {return poke->isLegendary;}

char* getCaptureDate(pokeref poke) {return poke->captureDate;}

/* gets 🖢 ============================================ sets 🖣*/

void setId(pokeref poke, int id) {poke->id = id;}

void setGeneration(pokeref poke, int generation) {poke->generation = generation;}

void setName(pokeref poke, const char *name) {strcpy(poke->name, name);}

void setDescription(pokeref poke, const char *description) {strcpy(poke->description, description);}

void setType(pokeref poke, const char *type, int index) {if (index >= 0 && index < 5) {strcpy(poke->types[index], type);}}

void setAbility(pokeref poke, const char *ability, int index) {if (index >= 0 && index < 5) {strcpy(poke->abilities[index], ability);}}

void setWeight(pokeref poke, double weight) {poke->weight = weight;}

void setHeight(pokeref poke, double height) {poke->height = height;}

void setCaptureRate(pokeref poke, int captureRate) {poke->captureRate = captureRate;}

void setIsLegendary(pokeref poke, bool isLegendary) {poke->isLegendary = isLegendary;}

void setCaptureDate(pokeref poke, const char *captureDate) {strcpy(poke->captureDate, captureDate);}


/**
 * Funcao auxiliar para concatenar array de habilidades para printar
 * @param referencia para objeto
 * @return string concatenada
 */
char* printAbilities(pokeref p)
{
    char* str = malloc(10000 * sizeof(char));
    if (str == NULL)
    {
        printf("Erro ao alocar memória para printAbilities\n");
        exit(1);
    }
    str[0] = '\0';


    int first = 1;

    for (int i = 0; i < MAX_ABILITIES; i++)
    {

        if (p->abilities[i] != NULL && strlen(p->abilities[i]) > 0)
        {
            if (!first) 
            {
                strcat(str, ",");
            }
            strcat(str, p->abilities[i]);
            first = 0; 
        }
    }

    return str;
}

/**
 * Funcao auxiliar para concatenar array de tipos para printar
 * @param referencia para objeto 
 * @return string concatenada 
 */
char* printTypes(pokeref p)
{
    char* str = malloc(1000 * sizeof(char));
    if (str == NULL)
    {
        printf("Erro ao alocar memoria para printTypes\n");
        exit(1);
    }
    str[0] = '\0'; 

    int first = 1;

    for (int i = 0; i < MAX_TYPES; i++) 
    {
        if (p->types[i] != NULL && strlen(p->types[i]) > 0)
        {
            if (!first) 
            {
                strcat(str, ", ");
            }

            strcat(str, "'");
            strcat(str, p->types[i]);
            strcat(str, "'");

            first = 0; 
        }
    }

    return str;
}

/**
 * Metodo para formatar saida
 */
void toString(pokeref p, char *result)
{
    char* abilities = printAbilities(p);
    char* types = printTypes(p);
    sprintf(result, "[#%d -> %s: %s - [%s] - [%s] - %.1fkg - %.1fm - %d%c - %s - %d gen] - %s",
            p->id, 
            p->name, 
            p->description, 
            types,
            abilities,
            p->weight, 
            p->height, 
            p->captureRate,
            '%', 
            p->isLegendary ? "true" : "false", 
            p->generation,
            p->captureDate);


    strcat(result, "\n");
}

void printPokemon(pokeref p)
{
    char* abilities = printAbilities(p);
    char* types = printTypes(p);
    printf("[#%d -> %s: %s - [%s] - [%s] - %.1fkg - %.1fm - %d%c - %s - %d gen] - %s\n",
            p->id, 
            p->name, 
            p->description, 
            types,
            abilities,
            p->weight, 
            p->height, 
            p->captureRate,
            '%', 
            p->isLegendary ? "true" : "false", 
            p->generation,
            p->captureDate);
}

void formatAndSetAbilities(char *abilitiesStr, pokeref p)
{
    char* start = strchr(abilitiesStr, '[');  
    char* end = strrchr(abilitiesStr, ']');   

    if (start != NULL && end != NULL && end > start)
    {
        start++;
        *end = '\0';
    }

    int i = 0;
    char* token = strtok(start, ",");
    while (token != NULL)
    {
        strcpy(p->abilities[i], token);   
        token = strtok(NULL, ",");
        i++;
    }
}

void ignoreAbilities(char* line, char* strabilities)
{
    int i = 0;
    int j = 0;
    int start = -1;
    int end = -1;

    for (i = 0; i < strlen(line); i++)
    {
        if (line[i] == '[')
        {
            start = i;
        }
        else if (line[i] == ']')
        {
            end = i;
            i = strlen(line);
        }
    }

    if (start != -1 && end != -1)
    {
  
        strncpy(strabilities, &line[start], end - start + 1);
        strabilities[end - start + 1] = '\0';  

        for (j = start; line[end + 1] != '\0'; j++, end++)
        {
            line[j] = line[end + 1];
        }
        line[j] = '\0'; 
    }
    else
    {
        strabilities[0] = '\0';
    }
}

void setRemainingAttributes(char* str, pokeref p)
{
    char *token = strsep(&str, ",");

    p->weight = atof(token);        //weight

    token = strsep(&str, ",");
    p->height = atof(token);        //height

    token = strsep(&str, ",");
    p->captureRate = atoi(token);   //captureRate

    token = strsep(&str, ",");
    p->isLegendary = atoi(token);   //isLegendary

    token = strsep(&str, ",");
    strcpy(p->captureDate, token);  //captureDate
}

// Funcao para ler o CSV e atribuir os atributos
void readCsv (char* fileName, pokeref* p)
{

    FILE *arquivo = fopen(fileName, "r");
    if (arquivo == NULL){printf("ERRO ao abrir arquivo\n");return;}

    char line[1024];
    char strabilities[512];
    int count = 0;
    int i = 0;

    fgets(line, sizeof(line), arquivo);

    while (fgets(line, sizeof(line), arquivo) && count < MAX_POKEMONS)
    {
        i = 0;
        line[strcspn(line, "\n")] = 0; 


        ignoreAbilities(line, strabilities);

        char *line_ptr = line;
        char *token = strsep(&line_ptr, ",");

    
        if (p[count] == NULL){printf("Pokémon %d não foi inicializado corretamente.\n", count);}


        p[count]->id = atoi(token);               //id

        token = strsep(&line_ptr, ",");
        p[count]->generation = atoi(token);       //generation

        token = strsep(&line_ptr, ",");
        strcpy(p[count]->name, token);            //name

        token = strsep(&line_ptr, ",");
        strcpy(p[count]->description, token);     //description

        token = strsep(&line_ptr, ",");
        strcpy(p[count]->types[0], token);        //type1

        token = strsep(&line_ptr, ",");
        if (token != NULL && strlen(token) > 0)
        {
            strcpy(p[count]->types[1], token);    //type2 value == empty set ""
        }
        else
        {
            strcpy(p[count]->types[1], ""); 
        }

        char *firstQuote, *secondQuote;
        char result[256]; 

        firstQuote = strchr(line_ptr, '"');
        
        if (firstQuote != NULL)
        {
            secondQuote = strchr(firstQuote + 1, '"');
            
            if (secondQuote != NULL)
            {
                strcpy(result, secondQuote + 2);

            }
        } 

        formatAndSetAbilities(strabilities, p[count]);

        setRemainingAttributes(result, p[count]);

        count++;
    }
    fclose(arquivo);
}

int n = 0;

typedef struct Node
{
    pokeref data;
    struct Node* next;
}Node;

Node* newNode(pokeref pokemon)
{
    Node* new = (Node*)malloc(sizeof(Node));
    new->data = pokemon;
    new->next = null;
    return new;
}

Node* first;
Node* last;

void start(pokeref pokemon)
{
    first = newNode(pokemon);
    last = first;
}

int tamanho() 
{
    int tamanho = 0;
    Node* i;
    for(i = first; i != last; i = i->next, tamanho++);
    return tamanho;
}

void inserirInicio (pokeref pokemon)
{
    Node* tmp = newNode(pokemon);
    tmp->next = first;
    first = tmp;
}

void inserirFim(pokeref pokemon)
{
    Node* tmp = newNode(pokemon); 
    if(first == NULL)
    {
        first = tmp;
    }

    last->next = tmp;
    last = last->next;
}

void inserir(pokeref pokemon, int pos) 
{
    pos--;
    int tam = tamanho();

    if(pos<0 || pos>tam)
    {
        printf("ERRO");
    }
    else if(pos == 0)
    {
        inserirInicio(pokemon);
    }
    else if(pos == tam)
    {
        inserirFim(pokemon);
    }
    else
    {
        int j;
        Node* i = first;
        for(j = 0; j < pos; j++, i = i->next);

        Node* tmp = newNode(pokemon);
        tmp->next = i->next;
        i->next = tmp;
        tmp = i = NULL;
    }
}

pokeref removerInicio()
{
    if (first == last) 
    { 
        printf("ERRO: Lista vazia!\n");
    }

    Node* tmp = first;
    pokeref resp = first->data;
    first = first->next;
    tmp->next = NULL;
    tmp = null;
    free(tmp); 
    // printf("(R) %s\n", resp->name);
    return resp;
}

pokeref removerFim() 
{
    if (first == last)
    {  
        printf("ERRO: Lista vazia!\n");
    }

    Node* i;
    for(i = first; i->next != last; i = i->next);

    pokeref resp = last->data;
    last = i;
    free(last->next);
    i = last->next = null;
    // printf("(R) %s\n", resp->name);
    return resp;
}

pokeref remover(int pos)
{
    pos--;
    pokeref resp;

    int tam = tamanho();

    if(first == last)
    {
        printf("ERRO");
    }
    else if(pos < 0 || pos >= tam)
    {
        printf("ERRO");
    }
    else if(pos == 0)
    {
        resp = removerInicio();
    }
    else if(pos == tam - 1)
    {
        resp = removerFim();
    }
    else
    {
        Node* i = first;
        int j;
        for(j = 0; j < pos; j++, i = i->next);

        Node* tmp = i->next;
        resp = tmp->data;
        i->next = tmp->next;
        tmp->next = null;
        free(tmp);
        i = tmp = null;
    }
    return resp;
}

int main (int argc, char** argv)
{
    pokeref* pokemons = malloc(MAX_POKEMONS * sizeof(pokeref));
    pokeref* array = malloc(MAX_POKEMONS * sizeof(pokeref));

    for (int i = 0; i < MAX_POKEMONS; i++)
    {
        pokemons[i] = init();
    }

    // readCsv(CAMINHO_PC, pokemons);
    readCsv(CAMINHO_VERDE, pokemons);


    char* buffer = malloc(80 * sizeof(char));
    scanf("%s", buffer);

    do 
    {
        int x = atoi(buffer);
        array[n] = pokemons[x-1];
        scanf("%s", buffer);
        n++;
    }while (strcmp(buffer, "FIM") != 0);

    start(pokemons[777]);

    for(int i = 0; i < n; i++)
    {
        inserirFim(array[i]);
    }

    int y = 0;
    scanf("%d", &y);
    getchar();

    removerInicio();

    char action[1024];
    pokeref tmp;
    for (int i = 0; i < y; i++)
    {
        scanf(" %[^\n]", action);
        char* args[3];
        args[0] = strtok(action, " ");
        args[1] = strtok(NULL, " ");
        args[2] = strtok(NULL, " ");

        if (strcmp(args[0], "I") == 0)
        {
            tmp = pokemons[atoi(args[1]) - 1];
            inserirFim(tmp);
        } 
        else if(strcmp(args[0], "R") == 0)
        {
            printf("(R) %s\n", removerFim()->name);
        }
    }

    Node* i = first;

    int j = 0;
    while (i != NULL)
    {
        printf("[%d] ", j);
        printPokemon(i->data);
        i = i->next;
        j++;
    }

    for (int i = 0; i < MAX_POKEMONS; i++)
    {
        destrutor(pokemons[i]);
    }

    return 0;
}

