%{
#include <stdio.h>
extern FILE *yyin;
%}

IZQ [a-zA-Z0-9._%+-]
DER [a-zA-Z0-9.-]
ARROBA @
DOMINIO \.[a-zA-Z]{2,}
%%

{IZQ}+{ARROBA}{DER}+{DOMINIO}    printf("Correo electrónico válido: %s\n", yytext);
.|\n                             /* Ignorar otros caracteres */

%%

int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Uso: %s <archivo de entrada>\n", argv[0]);
        return 1;
    }

    yyin = fopen(argv[1], "r");
    if (!yyin) {
        perror("Error al abrir el archivo");
        return 1;
    }

    yylex();
    fclose(yyin);

    return 0;
}
