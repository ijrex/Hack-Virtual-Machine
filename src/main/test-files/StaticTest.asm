@PROGRAM_START
0;JMP
(ARITHMETIC_ADD)
@SP
AM=M-1
D=M
A=A-1
M=M+D
@ARITHMETIC_LIB_END
0;JMP
(ARITHMETIC_AND)
@SP
AM=M-1
D=M
A=A-1
M=M&D
@ARITHMETIC_LIB_END
0;JMP
(ARITHMETIC_EQ)
@SP
AM=M-1
D=M
A=A-1
D=M-D
@ARITHMETIC_IS_EQUAL
D;JEQ
D=-1
(ARITHMETIC_IS_EQUAL)
@SP
A=M-1
M=!D
@ARITHMETIC_LIB_END
0;JMP
(ARITHMETIC_GT)
@SP
AM=M-1
D=M
A=A-1
D=M-D
@ARITHMETIC_IS_GT
D;JGT
D=0
@ARITHMETIC_GT_RESOLVE
0;JMP
(ARITHMETIC_IS_GT)
D=-1
(ARITHMETIC_GT_RESOLVE)
@SP
A=M-1
M=D
@ARITHMETIC_LIB_END
0;JMP
(ARITHMETIC_LT)
@SP
AM=M-1
D=M
A=A-1
D=M-D
@ARITHMETIC_IS_LT
D;JLT
D=0
@ARITHMETIC_LT_RESOLVE
0;JMP
(ARITHMETIC_IS_LT)
D=-1
(ARITHMETIC_LT_RESOLVE)
@SP
A=M-1
M=D
@ARITHMETIC_LIB_END
0;JMP
(ARITHMETIC_NEG)
@SP
A=M-1
M=-M
@ARITHMETIC_LIB_END
0;JMP
(ARITHMETIC_NOT)
@SP
A=M-1
M=!M
@ARITHMETIC_LIB_END
0;JMP
(ARITHMETIC_OR)
@SP
AM=M-1
D=M
A=A-1
M=M|D
@ARITHMETIC_LIB_END
0;JMP
(ARITHMETIC_SUB)
@SP
AM=M-1
D=M
A=A-1
M=M-D
(ARITHMETIC_LIB_END)
@R14
A=M
0;JMP
(PROGRAM_START)
@111
D=A
@SP
AM=M+1
A=A-1
M=D
@333
D=A
@SP
AM=M+1
A=A-1
M=D
@888
D=A
@SP
AM=M+1
A=A-1
M=D
@SP
AM=M-1
D=M
@function.8
M=D
@SP
AM=M-1
D=M
@function.3
M=D
@SP
AM=M-1
D=M
@function.1
M=D
@function.3
D=M
@SP
AM=M+1
A=A-1
M=D
@function.1
D=M
@SP
AM=M+1
A=A-1
M=D
@137
D=A
@R14
M=D
@ARITHMETIC_SUB
0;JMP
@function.8
D=M
@SP
AM=M+1
A=A-1
M=D
@149
D=A
@R14
M=D
@ARITHMETIC_ADD
0;JMP