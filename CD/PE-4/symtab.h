#ifndef SYMTAB_H
#define SYMTAB_H

#include <stdio.h>
#include <string.h>

#define MAX 100

typedef struct {
    char name[50];
    int value;
    int initialized;
} symbol;

symbol table[MAX];
int count = 0;

int lookup(char *name) {
    for(int i = 0; i < count; i++) {
        if(strcmp(table[i].name, name) == 0)
            return i;
    }
    return -1;
}

int insert(char *name) {
    strcpy(table[count].name, name);
    table[count].initialized = 0;
    return count++;
}

void update(char *name, int val) {
    int idx = lookup(name);
    if(idx == -1)
        idx = insert(name);

    table[idx].value = val;
    table[idx].initialized = 1;
}

int getval(char *name) {
    int idx = lookup(name);
    if(idx == -1 || table[idx].initialized == 0) {
        printf("Error: Variable '%s' not declared or initialized\n", name);
        return 0;
    }
    return table[idx].value;
}

#endif
