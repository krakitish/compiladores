%{
    #include <stdio.h>
    #include <stdlib.h>
%}

%token NUM
%token MUL

%%


expr:
    NUM MUL NUM { printf("Expresión válida: Multiplicación\n"); }
    ;

%%

int main() {
    printf("Ingrese una expresión: ");
    yyparse();
    return 0;
}

int yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
    return 0;
}
