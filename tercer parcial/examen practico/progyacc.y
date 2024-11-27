%{
    #include <stdio.h>
    #include <stdlib.h>
%}

%token NUM
%token MUL

%%


expr:
    NUM MUL NUM { printf("Expresi�n v�lida: Multiplicaci�n\n"); }
    ;

%%

int main() {
    printf("Ingrese una expresi�n: ");
    yyparse();
    return 0;
}

int yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
    return 0;
}
