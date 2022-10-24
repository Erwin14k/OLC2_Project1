package Ambit;
/*
*

import { Type } from "../Expresion/Retorno";

export class Simbolo {
    constructor(public valor:any,public id:string, public type:Type ){ }
}
* */
import Expression.ReturnType;


public class Symbol {
    public Object value;
    public String id;
    public ReturnType type;
    public String line;
    public String column;
    public int position;
    public Symbol(Object value, String id, ReturnType type,String line, String column,int position){
        this.id=id;
        this.value=value;
        this.type=type;
        this.line=line;
        this.column=column;
        this.position=position;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReturnType getType() {
        return type;
    }

    public void setType(ReturnType type) {
        this.type = type;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
