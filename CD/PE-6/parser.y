%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

extern int yylex();
extern FILE *yyin;
void yyerror(const char *s);

FILE *outfile;

/* Temporary counter */
int temp_count = 1;

/* Function to generate new temporaries */
char* newTemp() {
    char *temp = (char*)malloc(10);
    sprintf(temp, "t%d", temp_count++);
    return temp;
}
%}

/* Make these visible in parser.tab.h */
%code requires {
    #include <stdio.h>
    #include <stdlib.h>
    #include <string.h>
}

/* Semantic values */
%union {
    char* str;
}

%token <str> ID NUM
%type <str> expr

%left '+' '-'
%left '*' '/'

%%

input:
      /* empty */
    | input line
;

line:
      ID '=' expr '\n' {
            fprintf(outfile, "(=, %s, -, %s)\n\n", $3, $1);
            temp_count = 1;   /* ✅ RESET TEMP COUNTER PER LINE */
      }
    | '\n'
;

expr:
      expr '+' expr {
            char *t = newTemp();
            fprintf(outfile, "(+, %s, %s, %s)\n", $1, $3, t);
            $$ = t;
      }
    | expr '-' expr {
            char *t = newTemp();
            fprintf(outfile, "(-, %s, %s, %s)\n", $1, $3, t);
            $$ = t;
      }
    | expr '*' expr {
            char *t = newTemp();
            fprintf(outfile, "(*, %s, %s, %s)\n", $1, $3, t);
            $$ = t;
      }
    | expr '/' expr {
            char *t = newTemp();
            fprintf(outfile, "(/, %s, %s, %s)\n", $1, $3, t);
            $$ = t;
      }
    | '(' expr ')' {
            $$ = $2;
      }
    | ID {
            $$ = strdup($1);
      }
    | NUM {
            $$ = strdup($1);
      }
;

%%

void yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
}

int main() {
    yyin = fopen("input.txt", "r");
    outfile = fopen("output.txt", "w");

    if (!yyin || !outfile) {
        printf("Error opening input/output file\n");
        return 1;
    }

    yyparse();

    fclose(yyin);
    fclose(outfile);

    printf("IC generated successfully in output.txt\n");
    return 0;
}
