#ifndef SYM_TAB_H
#define SYM_TAB_H

#define CHAR 1
#define INT 2
#define FLOAT 3
#define DOUBLE 4

typedef struct symbol
{
    char* name;
    int size;
    int type;
    char* val;
    int line;
    int scope;
    struct symbol* next;
} symbol;

typedef struct table
{
    symbol* head;
} table;

static table* t;

// ✅ proper function declarations
table* allocate_space_for_table();

symbol* allocate_space_for_table_entry(char* name, int size, int type, int lineno, int scope);

void insert_into_table(symbol* s);

void insert_value_to_name(char* name, char* value);

int check_symbol_table(char* name);

void display_symbol_table();

#endif