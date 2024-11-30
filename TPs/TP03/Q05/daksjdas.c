
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

void inserirInicio (pokeref pokemon)
{
    Node* tmp = newNode(pokemon);
    tmp->next = first->next;
    first->next = tmp;
    if(first == last)
    {
        last = tmp;
    }
    tmp = null;
}

void inserirFim (pokeref pokemon)
{
    last->next = newNode(pokemon);
    last = last->next;
}

int tamanho ()
{
    int tamanho = 0;
    Node* i;
    for(i = first; i != last; i = i->next, tamanho++);
    return tamanho;
}

void inserir (pokeref pokemon, int pos)
{
    int tam = tamanho();
    
    if(pos < 0 || pos > tam)
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
        tmp = i = null;
    }
}

pokeref removerInicio ()
{
    if(first == last)
    {
        printf("ERRO");
    }
    else
    {
        Node* tmp = first;
        first = first->next;
        pokeref resp = first->data;
        tmp->next = null;
        free(tmp);
        tmp = null;
        return resp;
    }
}

pokeref removerFim ()
{
    if(first == last)
    {
        printf("ERRO");
    }
    else
    {
        Node* i;
        for(i = first; i->next != last; i = i->next);

        pokeref resp = last->data;
        last = i;
        free(last->next);
        i = last->next = null;

        return resp;
    }
}

pokeref remover (int pos)
{
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
        i->next = tmp->data;
        tmp->next = null;
        free(tmp);
        i = tmp = null;
    }
    return resp;
}
