#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ast.h"

/* extern file pointer from parser */
extern FILE *outfile;

Node* createNode(char *val, Node *l, Node *r) {
    Node *node = (Node*)malloc(sizeof(Node));
    node->value = strdup(val);
    node->left = l;
    node->right = r;
    return node;
}

void postorder(Node *root) {
    if (root == NULL) return;

    postorder(root->left);
    postorder(root->right);
    fprintf(outfile, "%s ", root->value);  // ✅ write to file
}

void freeTree(Node *root) {
    if (root == NULL) return;

    freeTree(root->left);
    freeTree(root->right);
    free(root->value);
    free(root);
}
