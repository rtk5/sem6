#ifndef AST_H
#define AST_H

typedef struct Node {
    char *value;
    struct Node *left;
    struct Node *right;
} Node;

Node* createNode(char *val, Node *l, Node *r);
void postorder(Node *root);
void freeTree(Node *root);

#endif
