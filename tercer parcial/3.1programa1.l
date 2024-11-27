%{
#include <stdio.h>
extern FILE *yyin;
%}

DIGIT [0-9]
OPERATOR [+*/-]
%%

{DIGIT}+    printf("Número: %s\n", yytext);
{OPERATOR}  printf("Operador: %s\n", yytext);
.           /* Ignorar otros caracteres */

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
