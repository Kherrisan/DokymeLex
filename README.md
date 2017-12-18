# DokymeLex

## 概述

这是一个播放Lex程序功能的词法分析器代码生成程序，简称“编译器的编译器”。该程序能够读取由用户定义的.dkm文件，分析该文件中的声明、正规定义、规则并生成能够通过JVM运行的JAVA的词法分析器源代码。

## .dkm文件结构

### 正规定义

由正则表达式定义。所有定义的类型都将直接替换后文中声明段和规则段。

### 声明段

声明一些必须的成员变量。
    声明段的代码会被直接复制到词法分析器主类的定义中。

### 规则段

匹配字符串模式，根据规则采取行为。规则段中的代码会被直接复制到相应状态下。

### 程序段

主程序代码。代码段中包含的函数都将直接复制带词法分析器主类的定义中。

### 示例如下:
    
    [a-zA-Z]    {letter}
    [0-9]       {digit}
    letter(letter|digit)*   {id}
    digit+      {number}
    [!@#$%^&\*\(\)_\[\]{}?\+:;,.]  {symbol}
    %%
    private int counter = 0;
    %%
    if    {incrementCounter();return "IF";}
    else  {return "ELSE";}
    while {return "WHILE";}
    for   {return "FOR";}
    switch  {return "SWITCH";}
    case  {return "CASE";}
    break {return "BREAK";}
    
    int   {return "INT";}
    float {return "FLOAT";}
    char  {return "CHAR";}
    bool  {return "BOOL";}
    void  {return "VOID";}
    
    static  {return "STATIC";}
    return {return "RETURN";}
    
    id      {return "ID";}
    number  {return "CONSTANT";}
    "(symbol|digit|letter)+"    {return "CONSTANT";}
    
    =     {return "ASN";}
    \+     {return "ADD";}
    \-     {return "SUB";}
    \*     {return "MUL";}
    /     {return "DIV";}
    %     {return "MOD";}
    >     {return "BT";}
    <     {return "ST";}
    ==    {return "EQU";}
    \+=    {return "ADDA";}
    \-=    {return "SUBA";}
    \*=    {return "MULA";}
    /=    {return "DIVA";}
    %=    {return "MODA";}
    \+\+    {return "INC";}
    \-\-    {return "DEC";}   
    "     {return "QUO";}
    {     {return "LBRCE";}
    }     {return "RBRCE";}
    \[     {return "LBRCKT";}
    \]     {return "RBRCKT";}
    \(     {return "LPTH";}
    \)     {return "RPTH";}
    .     {return "DOT";}
    
    ||    {return "OR";}
    &&    {return "AND";}
    !     {return "NOT";}
    
    %%
    public String parseType(){
        //this.token是一个String类型的、代表着当前识别出来的字符串的变量。
    }
    public String printf(String content){
        System.out.println("["+this.token+"]"+content);
    }
    public void incrementCounter(){
        this.counter++;
    }
    public static void main(String[] args){
        dokyme(); //开始运行分析器。
    }
    