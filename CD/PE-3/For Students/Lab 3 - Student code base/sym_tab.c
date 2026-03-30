#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "sym_tab.h"

table* t;

table* allocate_space_for_table()
{
    table* t1 = (table*)malloc(sizeof(table));
    t1->head = NULL;
    return t1;
}

symbol* create_symbol(
    char* name,
    char* kind,
    char* type,
    char* storage,
    int size,
    int line,
    int column,
    char* file,
    int scope)
{
    symbol* s = (symbol*)malloc(sizeof(symbol));

    s->name = strdup(name);
    s->kind = strdup(kind);
    s->type = strdup(type);
    s->storage = strdup(storage);
    s->size = size;
    s->value = NULL;
    s->line = line;
    s->column = column;
    s->file = strdup(file);
    s->scope = scope;
    s->next = NULL;

    return s;
}

void insert_symbol(symbol* s)
{
    if (t->head == NULL)
    {
        t->head = s;
        return;
    }

    symbol* temp = t->head;
    while (temp->next)
        temp = temp->next;

    temp->next = s;
}

int lookup(char* name)
{
    symbol* temp = t->head;
    while (temp)
    {
        if (strcmp(temp->name, name) == 0)
            return 1;
        temp = temp->next;
    }
    return 0;
}

void update_value(char* name, char* value)
{
    symbol* temp = t->head;
    while (temp)
    {
        if (strcmp(temp->name, name) == 0)
        {
            temp->value = strdup(value);
            return;
        }
        temp = temp->next;
    }
}

void display_symbol_table()
{
    symbol* temp = t->head;

    printf("\n%-10s %-10s %-10s %-10s %-5s %-6s %-6s %-6s %-10s %-10s\n",
           "Name","Kind","Type","Storage","Size","Scope","Line","Col","File","Value");

    while (temp)
    {
        printf("%-10s %-10s %-10s %-10s %-5d %-6d %-6d %-6d %-10s %-10s\n",
               temp->name,
               temp->kind,
               temp->type,
               temp->storage,
               temp->size,
               temp->scope,
               temp->line,
               temp->column,
               temp->file,
               temp->value ? temp->value : "NULL");

        temp = temp->next;
    }
}