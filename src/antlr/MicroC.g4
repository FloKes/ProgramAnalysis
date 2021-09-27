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
TRUE : 'true';
FALSE : 'false';

program: LBRACE decl statement RBRACE EOF;

blockStmnt: LBRACE (decl | statement) RBRACE;

statement
    : (ifElse
    | lAssign
    | recordAssign
    | whileStmnt
    | readStmnt
    | writeStmnt)+
    ;

ifElse: IF LPAREN bexpr RPAREN blockStmnt (elseStmnt)?;
elseStmnt: ELSE blockStmnt;
lAssign: lexpr EQUAL rexpr SEMI;
recordAssign:  R EQUAL LPAREN rexpr COMMA rexpr RPAREN SEMI;
whileStmnt: WHILE LPAREN bexpr RPAREN blockStmnt;
readStmnt:READ lexpr SEMI;
writeStmnt:WRITE rexpr SEMI;

lexpr: arrayIndexId
    | varIdentifier
    | recFst
    | recSnd
    ;
recFst: (R)FST ;
recSnd: (R)SND ;
varIdentifier: IDENTIFIER;
arrayIndexId: IDENTIFIER array;
number: INTEGER;

rexpr: rexpr opa rexpr
    | number
    | arrayIndexId
    | varIdentifier
    | recFst
    | recSnd
    ;

array: LBRACKET (INTEGER|IDENTIFIER) RBRACKET ;

bexpr: rexpr opr rexpr
    | bexpr opb bexpr
    | TRUE
    | FALSE
    | NOT bexpr
    ;

decl: (varDecl
    | arrayDecl
    | recordDecl
    )*
    ;

varDecl: INT IDENTIFIER (EQUAL INTEGER)? (SEMI)?;
arrayDecl: INT LBRACKET INTEGER RBRACKET IDENTIFIER SEMI;
recordDecl: LBRACE varDecl varDecl RBRACE  R SEMI;

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


/* Tokens */

INTEGER : ('0' | '1'..'9' '0'..'9'*);
IDENTIFIER : LETTER (LETTER|'0'..'9')* ;
fragment
LETTER : 'A'..'Z'
       | 'a'..'z'
       | '_'
       ;

COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : (' '|'\r'|'\t'|'\u000C'|'\n') -> skip ;
