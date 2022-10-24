grammar Grammar;


options { caseInsensitive = true; }

INT             : [0-9]+;
DOUBLE          : [0-9]+'.'[0-9]+;
IDEN            : [a-zA-Z0-9_]+;
COMMENT         : '!'(~[\r\n])* '\r'? '\n' -> skip;
STRING          : '"' (~["\r\n] | '""')+ '"';
STRING2         : '\'' (~["\r\n] | '\'\'')+ '\'';
WS              : [ \t\r\n]+ -> skip;
tart : listaInstrucciones EOF;
listaInstrucciones : e += instruction*
                   ;
instruction : declaration       #declar
            | print             #ptr
            | if_               #insIf
            | doWhile           #dw
            | for_              #fo
            | asignation        #as
            | function          #fun
            | functionCall      #fc
            | subroutine        #sub
            | subroutineCall    #subC
            | arrayDeclaration  #arrD
            | arrayDeclaration2 #arrD2
            | program           #comeOn
            | oneDimArrayAsig   #oneArrAs
            | oneArrayListAsig  #oneArrListAs
            | twoDimArrayAsig   #twoArrAs
            | continue_         #cont
            | break_            #bre
            | dynamicArrayDec   #dynamic1
            | allocate          #allo
            | deallocate        #deall
            ;


declaration : t=('integer'|'character'|'complex'|'logical'|'real') ':' ':' IDEN                                 #singularNull
            | t=('integer'|'character'|'complex'|'logical'|'real') ':' ':' IDEN '=' expr                        #singularActive
            | t=('integer'|'character'|'complex'|'logical'|'real') ':' ':' p+=IDEN (',' e+=IDEN)*               #pluralNull
            | t=('integer'|'character'|'complex'|'logical'|'real') ':' ':' p+=IDEN (',' e+=IDEN)* '=' expr      #pluralActive
            ;

asignation: o=IDEN '=' expr #asig
   ;
print   : ins='print' '*' ','  p+=expr (',' e+=expr)*
        ;




expr :   op='-' u=expr                                    #ngative
       | left = expr op = '**' right = expr               #opExpr
       | left = expr op = ('*' | '/') right = expr        #opExpr
       | left = expr op = ('+' | '-') right = expr        #opExpr
       | left = expr op = ('==' | '.eq.') right = expr    #igualExpr
       | left = expr op = ('/=' | '.ne.') right = expr    #diferenteExpr
       | left = expr op = ('>=' | '.ge.') right = expr    #mayorIgualExpr
       | left = expr op = ('<=' | '.le.') right = expr    #menorIgualExpr
       | left = expr op = ('>' | '.gt.') right = expr     #mayorExpr
       | left = expr op = ('<' | '.lt.') right = expr     #menorExpr
       | left = expr op ='.and.' right = expr             #andExpr
       | left = expr op ='.or.' right = expr              #orExpr
       | op ='.not.' left = expr                          #notExpr
       | '(' expr ')'                                     #parenExpr
       | atom=INT                                         #atomExpr
       | dou=DOUBLE                                       #douExpr
       | str=STRING                                       #strExpr
       | str2=STRING2                                     #strExpr2
       | bool=('.true.'|'.false.')                        #boolExpr
       | id=IDEN                                          #idExpr
       | id=IDEN '[' ind=expr ']'                         #oneArrayAccess
       | id=IDEN '[' ind1=expr ','ind2=expr ']'           #twoArrayAccess
       | t='size' '(' id=expr')'                          #sizeArr
       | functionCall                                     #exprFunctionReturn
       ;
if_ : i='if' '(' expr ')' th='then' statement (else_)? 'endif'?
    ;

statement :   e+=instruction*        #normalIfStatement
    ;
else_:  'else' statement  #elseNormal
        |i='else' if_     #elseIfNormal
    ;



doWhile: IDEN? i='do' 'while' '('expr')' whileStatement 'end' 'do'
        ;
whileStatement: e+=instruction*       #normalWhileStatement
        ;
for_ : IDEN? i='do' ini=expr ',' lim=expr ',' sped=expr forStatement 'end' 'do' #easyFor
        | i='do' asignation ',' lim=expr ',' sped=expr forStatement 'end' 'do' #mediumFor
        ;
forStatement: e+=instruction*       #normalForStatement
        ;

function: u='function' name=IDEN '('')''result' '(' res=IDEN')' 'implicit' 'none' l+=decParameter* funStatement 'end' 'function' name2=IDEN                         #withoutParamsFunc
        | u='function' name=IDEN '('p+=expr (',' e+=expr)*')''result' '(' res=IDEN')' 'implicit' 'none' l+=decParameter* funStatement 'end' 'function' name2=IDEN   #withParamsFunc
;


funStatement: e+=instruction*       #normalFuncStatement
        ;

programStatement: e+=instruction*       #mainStatement
        ;

functionCall: y=IDEN '('p+=expr (',' e+=expr)* ')' #funcCallWith
            | y=IDEN '(' ')' #funcCallWithout
;

subroutine: u='subroutine' name=IDEN '('')' 'implicit' 'none' l+=decParameter* subStatement 'end' 'subroutine' name2=IDEN                            #withoutParamsSub
            | u='subroutine' name=IDEN '('p+=expr (',' e+=expr)*')' 'implicit' 'none' l+=decParameter* subStatement 'end' 'subroutine' name2=IDEN    #withParamsSub
;

decParameter: t=('integer'|'character'|'complex'|'logical'|'real') k=',' 'intent' '(' 'in' ')' ':' ':' u=expr   #decPar
;

subStatement: e+=instruction*       #normalSubStatement
        ;

subroutineCall: t='call' y=IDEN '('p+=expr (',' e+=expr)* ')' #subCallWith
            | t='call' y=IDEN '(' ')' #subCallWithout
;

arrayDeclaration :t=('integer'|'character'|'real')',' 'dimension''('left=expr')' ':'':' id=expr             #firstArraySingular
            | t=('integer'|'character'|'real') ':'':' id=expr '('left=expr')'                               #secondArraySingular
            ;
program: y='program' u1=IDEN 'implicit' 'none' programStatement 'end' 'program' f=IDEN  #mainProgram;


oneDimArrayAsig: o=IDEN '['e=expr']''=' f=expr #oda;

twoDimArrayAsig: o=IDEN '[' a=expr ',' b=expr ']''=' f=expr #tda;

oneArrayListAsig: o=IDEN '=' '(''/'p+=expr (',' e+=expr)*'/' ')' #listAsigOneArray;

arrayDeclaration2:  t=('integer'|'character'|'real')',' 'dimension''('left=expr','right=expr')' ':'':' id=expr    #firstArrayPlural
                  | t=('integer'|'character'|'real') ':'':' id=expr '('left=expr','right=expr')'                  #secondArrayPlural
                  ;

continue_: i='cycle' IDEN?;
break_ : i='exit' IDEN?;

dynamicArrayDec: t=('integer'|'character'|'real')',' 'allocatable' ':'':' id=expr'('':'')'  #oneDynamic
                | t=('integer'|'character'|'real')',' 'allocatable' ':'':' id=expr'(' ':' ',' ':' ')'  #twoDynamic;

allocate: a='allocate' '('i=IDEN '('g=expr ')' ')' #oneAllocate
        | a='allocate' '('i=IDEN '('g1=expr ',' g2=expr ')' ')' #twoAllocate
;
deallocate: o='deallocate' '(' i=IDEN ')';