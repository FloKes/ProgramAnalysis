grammar MicroC;

LPAREN : '(';
RPAREN: ')';
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

statement
    : (IF LPAREN bexpr RPAREN LBRACE statement RBRACE (ELSE LBRACE statement RBRACE)?
    | lexpr EQUAL rexpr SEMI
    | R EQUAL LPAREN rexpr COMMA rexpr RPAREN SEMI
    | WHILE LPAREN bexpr RPAREN LBRACE statement RBRACE
    | READ lexpr SEMI
    | WRITE rexpr SEMI)+
    ;

lexpr: IDENTIFIER array
    | IDENTIFIER
    | (R)FST
    | (R)SND
    ;

rexpr: rexpr opa rexpr
    | INTEGER
    | IDENTIFIER array
    | IDENTIFIER
    | (R)FST
    | (R)SND
    ;

array: LBRACKET (INTEGER|IDENTIFIER) RBRACKET;

bexpr: rexpr opr rexpr
    | bexpr opb bexpr
    | TRUE
    | FALSE
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

COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : (' '|'\r'|'\t'|'\u000C'|'\n') -> skip ;
