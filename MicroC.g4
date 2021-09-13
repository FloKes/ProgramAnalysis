grammar MicroC;

LPARENT : '(';
RPARENT : ')';
LBRACE : '{';
RBRACE : '}';
SEMI : ';';
LBRACKET : '[';
RBRACKET : ']';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
GT : '>';
GE : '>=';
LT : '<';
LE : '<=';
EQ : '==';
NEQ : '!=';
NOT : '!';
AND : '&';
OR : '|';
COMMA : ',';
ELSE : 'else';
FST : '.fst';
SND : '.snd';
INT : 'int';
EQUAL : ':=';
READ : 'read';
WRITE : 'write';
IF : 'if';
WHILE : 'while';
R : 'R';

program: LBRACE decl statement RBRACE;

statement : lexpr EQUAL rexpr
     | R EQUAL LPARENT rexpr COMMA rexpr RPARENT SEMI
     | statement statement
     | IF LPARENT bexpr RPARENT LBRACE statement RBRACE
     | IF LPARENT bexpr RPARENT LBRACE statement RBRACE ELSE LBRACE statement RBRACE
     | WHILE LPARENT bexpr RPARENT LBRACE statement RBRACE
     | READ lexpr SEMI
     | WRITE rexpr SEMI
     ;

lexpr: IDENTIFIER
    | IDENTIFER LBRACKET rexpr RBRACKET
    | (R)FST
    | (R)SND
    ;

rexpr: INTEGER
    | IDENTIFIER
    | IDENTIFER LBRACKET rexpr RBRACKET
    | (R)FST
    | (R)SND
    | rexpr opa rexpr
    ;

bexpr: TRUE
    | FALSE
    | rexpr opr rexpr
    | bexpr opb bexpr
    | NOT bexpr
    ;

decl: (INT IDENTIFIER SEMI
    | INT LBRACKET INTEGER RBRACKET IDENTIFIER SEMI
    | LBRACE INT IDENTIFIER SEMI INT IDENTIFIER RBRACE R SEMI
    )*
    ;

opa: PLUS
    | MINUS
    | MULT
    | DIV
    | MOD
    ;

opr: GT
    | LT
    | GE
    | LE
    | EQ
    | NEQ
    ;


opb: AND
    | OR
    ;

INTEGER : ('0' | '1'..'9' '0'..'9'*);
IDENTIFIER : LETTER (LETTER|'0'..'9')* ;
fragment
LETTER : 'A'..'Z'
       | 'a'..'z'
       | '_'
       ;



WS : (' '|'\r'|'\t'|'\u000C'|'\n') -> skip ;
