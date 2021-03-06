# DokymeLex

-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            13            130            119           1176
-------------------------------------------------------------------------------
SUM:                            13            130            119           1176
-------------------------------------------------------------------------------

## 概述

这是一个模仿Lex程序功能的词法分析器代码生成程序，简称“编译器的编译器”。该程序能够读取由用户定义的.dkm文件，分析该文件中的声明、正规定义、规则并生成能够通过JVM运行的JAVA的词法分析器源代码。

## Lex简介

Lex helps write programs whose control flow is directed by instances of regular expressions in the input stream. It is well suited for editor-script type transformations and for segmenting input in preparation for a parsing routine.
Lex source is a table of regular expressions and corresponding program fragments. The table is translated to a program which reads an input stream, copying it to an output stream and partitioning the input into strings which match the given expressions. As each such string is recognized the corresponding program fragment is executed. The recognition of the expressions is performed by a deterministic finite automaton generated by Lex. The program fragments written by the user are executed in the order in which the corresponding regular expressions occur in the input stream.

The lexical analysis programs written with Lex accept ambiguous specifications and choose the longest match possible at each input point. If necessary, substantial lookahead is performed on the input, but the input stream will be backed up to the end of the current partition, so that the user has general freedom to manipulate it.

Lex can generate analyzers in either C or Ratfor, a language which can be translated automatically to portable Fortran. It is available on the PDP-11 UNIX, Honeywell GCOS, and IBM OS systems. This manual, however, will only discuss generating analyzers in C on the UNIX system, which is the only supported form of Lex under UNIX Version 7. Lex is designed to simplify interfacing with Yacc, for those with access to this compiler-compiler system.

## 完整食用说明

1. 确保你的电脑上有jdk1.8及以上版本，没有的话，我也无能为力咯。。。
2. 在某个文件夹下创建一个lex文件，并在其中写一些东西，具体怎么写参照[.lex文件结构](#lexFormat)。
    假设路径为 'C:\dokyme.lex'。
3. 在console中运行DokymeLex_{i386或x64}.exe（以下简称DokymeLex.exe）,注意要带有参数 -l（是小写L不是1不是i）。可以使用参数 -h 查看所有参数。
    `.\DokymeLex.exe -l C:\dokyme.lex`
4. 程序会自动读取lex文件中的声明、正规定义、函数定义，并生成可执行的、仅包含有一个类的.java源程序文件。
    默认生成文件名为 DokymeLex.java，默认路径为应用程序所在路径，如果想要自定义请直接使用 -h 参数查阅需要的参数。
    **注：请自觉将文件名命名为DokymeLexer.java文件，否则文件名和主类名不匹配，javac没办法编译的。**
    **程序运行所需的时间取决于lex文件的复杂度，再加上我比较菜，所以请不要写太过复杂的lex，比如ANSI C这样的lex定义。**
5. 生成的java源文件中默认的包名为com。因此请新建一个com文件夹，把生成的.java文件放到com文件夹下。当然你也可以自己修改包名，并让包名和目录结构匹配。
    `javac com/DokymeLexer.java`
6. 然后运行生成的.class文件，注意同样需要一些参数，同样可以使用 -h 查看帮助文档。假设需要做词法分析的文件为wenwen.txt（实际情况下，一般都是对某种语言的源文件进行词法分析，比如.c、.java、.py这样的，这里就以txt为例了）。
    `java com.DokymeLexer wenwen.txt`
7. 程序会打印分析出的token序列。至此结束。

## .lex文件结构

<div id="lexFormat"></div>

实际上文件的拓展名并没有具体要求，可以是.lex、.txt或者其他，只要在运行的时候指明文件完整路径即可。

### 正规定义

由正则表达式定义。所有定义的类型都将直接替换后文中声明段和规则段。相当于c语言中的`#define`。

### 声明段

声明一些必须的成员变量，这些成员变量其实是全局可访问的，因为最后生成的主程序只有一个类。
声明段的代码会被直接复制到词法分析器主类的定义中。

### 规则段

匹配字符串模式，根据规则采取行为。规则段中的代码会被直接复制到相应状态下。

### 程序段

主程序代码。代码段中包含的函数都将直接复制带词法分析器主类的定义中。

### 示例如下:

[示例.lex文件](https://github.com/Dokyme/DokymeLex/blob/master/rule.dokyme)
    
    [a-zA-Z]    {letter}
    [0-9]       {digit}
    letter(letter|digit)*   {id}
    digit+      {number}
    [!@#$%^&\*\(\)_\[\]{}?\+:;,.]  {symbol}
    [ \r\n] {blank}
    %%
    private int counter = 0;
    %%
    if    {increment();return "IF";}
    else  {return "ELSE";}
    while {return "WHILE";}
    for   {return "FOR";}
    switch  {return "SWITCH";}
    case  {return "CASE";}
    break {return "BREAK";}
    blank   {return "BLANK";}
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
    ;   {return "SEMI";}
    
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
    
    \|\|    {return "OR";}
    &&    {return "AND";}
    !     {return "NOT";}
    %%
    private void increment(){
        counter++;
    }
    public static void main(String[] args){
        new DokymeLexer(args);
    }
    
    %%
    private void increment(){
       counter++;
    }
