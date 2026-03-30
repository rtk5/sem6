#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "sym_tab.h"

table* allocate_space_for_table()
{
    table* t1 = (table*)malloc(sizeof(table));
    t1->head = NULL;
    return t1;
}

symbol* allocate_space_for_table_entry(char* name, int size, int type, int lineno, int scope)
{
    symbol* s = (symbol*)malloc(sizeof(symbol));

    s->name = strdup(name);
    s->size = size;
    s->type = type;
    s->val = NULL;
    s->line = lineno;
    s->scope = scope;
    s->next = NULL;

    return s;
}

void insert_into_table(symbol* s)
{
    if (t->head == NULL)
    {
        t->head = s;
        return;
    }

    symbol* temp = t->head;
    while (temp->next != NULL)
        temp = temp->next;

    temp->next = s;
}

int check_symbol_table(char* name)
{
    if (t->head == NULL)
        return 0;

    symbol* temp = t->head;

    while (temp != NULL)
    {
        if (strcmp(temp->name, name) == 0)
            return 1;
        temp = temp->next;
    }
    return 0;
}

void insert_value_to_name(char* name, char* value)
{
    symbol* temp = t->head;

    while (temp != NULL)
    {
        if (strcmp(temp->name, name) == 0)
        {
            temp->val = strdup(value);
            return;
        }
        temp = temp->next;
    }
}

void display_symbol_table()
{
    symbol* temp = t->head;

    printf("\nSymbol Table:\n");
    printf("Name\tSize\tType\tLine\tScope\tValue\n");

    while (temp != NULL)
    {
        printf("%s\t%d\t%d\t%d\t%d\t%s\n",
               temp->name,
               temp->size,
               temp->type,
               temp->line,
               temp->scope,
               temp->val ? temp->val : "NULL");

        temp = temp->next;
    }
}