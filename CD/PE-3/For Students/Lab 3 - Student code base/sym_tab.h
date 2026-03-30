#ifndef SYM_TAB_H
#define SYM_TAB_H

typedef struct symbol
{
    char* name;
    char* kind;
    char* type;
    char* storage;
    int size;
    char* value;

    int line;
    int column;
    char* file;

    int scope;

    struct symbol* next;
} symbol;

typedef struct table
{
    symbol* head;
} table;

extern table* t;

table* allocate_space_for_table();

symbol* create_symbol(
    char* name,
    char* kind,
    char* type,
    char* storage,
    int size,
    int line,
    int column,
    char* file,
    int scope
);

void insert_symbol(symbol* s);
int lookup(char* name);
void update_value(char* name, char* value);
void display_symbol_table();

#endif