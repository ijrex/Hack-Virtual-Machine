@256
D=A
@SP
M=D
@SYS_BOOTSTRAP
D=A
@SP
AM=M+1
A=A-1
M=D
@LCL
MD=0
@SP
AM=M+1
A=A-1
M=D
@ARG
MD=0
@SP
AM=M+1
A=A-1
M=D
@THIS
MD=0
@SP
AM=M+1
A=A-1
M=D
@THAT
MD=0
@SP
AM=M+1
A=A-1
M=D
@SP
D=M
@5
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
(SYS_BOOTSTRAP)
(Sys.init)
@4
D=A
@SP
AM=M+1
A=A-1
M=D
@RET_ADDRESS_94
D=A
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@SP
AM=M+1
A=A-1
M=D
@ARG
D=M
@SP
AM=M+1
A=A-1
M=D
@THIS
D=M
@SP
AM=M+1
A=A-1
M=D
@THAT
D=M
@SP
AM=M+1
A=A-1
M=D
@SP
D=M
@1
D=D-A
@5
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Main.fibonacci
0;JMP
(RET_ADDRESS_94)
(Sys$WHILE)
@Sys$WHILE
0;JMP
(Main.fibonacci)
@ARG
D=M
@0
A=A+D
D=M
@SP
AM=M+1
A=A-1
M=D
@2
D=A
@SP
AM=M+1
A=A-1
M=D
@117
D=A
@R14
M=D
@ARITHMETIC_LT
0;JMP
@SP
AM=M-1
D=M
@Main$IF_TRUE
D;JNE
@Main$IF_FALSE
0;JMP
(Main$IF_TRUE)
@ARG
D=M
@0
A=A+D
D=M
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@R14
M=D
@5
D=A
@R14
A=M-D
A=M
D=A
@R15
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M
@SP
M=D+1
@R14
M=M-1
A=M
D=M
@THAT
M=D
@R14
M=M-1
A=M
D=M
@THIS
M=D
@R14
M=M-1
A=M
D=M
@ARG
M=D
@R14
M=M-1
A=M
D=M
@LCL
M=D
@R15
A=M
0;JMP
(Main$IF_FALSE)
@ARG
D=M
@0
A=A+D
D=M
@SP
AM=M+1
A=A-1
M=D
@2
D=A
@SP
AM=M+1
A=A-1
M=D
@203
D=A
@R14
M=D
@ARITHMETIC_SUB
0;JMP
@RET_ADDRESS_247
D=A
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@SP
AM=M+1
A=A-1
M=D
@ARG
D=M
@SP
AM=M+1
A=A-1
M=D
@THIS
D=M
@SP
AM=M+1
A=A-1
M=D
@THAT
D=M
@SP
AM=M+1
A=A-1
M=D
@SP
D=M
@1
D=D-A
@5
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Main.fibonacci
0;JMP
(RET_ADDRESS_247)
@ARG
D=M
@0
A=A+D
D=M
@SP
AM=M+1
A=A-1
M=D
@1
D=A
@SP
AM=M+1
A=A-1
M=D
@268
D=A
@R14
M=D
@ARITHMETIC_SUB
0;JMP
@RET_ADDRESS_312
D=A
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@SP
AM=M+1
A=A-1
M=D
@ARG
D=M
@SP
AM=M+1
A=A-1
M=D
@THIS
D=M
@SP
AM=M+1
A=A-1
M=D
@THAT
D=M
@SP
AM=M+1
A=A-1
M=D
@SP
D=M
@1
D=D-A
@5
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Main.fibonacci
0;JMP
(RET_ADDRESS_312)
@318
D=A
@R14
M=D
@ARITHMETIC_ADD
0;JMP
@LCL
D=M
@R14
M=D
@5
D=A
@R14
A=M-D
A=M
D=A
@R15
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M
@SP
M=D+1
@R14
M=M-1
A=M
D=M
@THAT
M=D
@R14
M=M-1
A=M
D=M
@THIS
M=D
@R14
M=M-1
A=M
D=M
@ARG
M=D
@R14
M=M-1
A=M
D=M
@LCL
M=D
@R15
A=M
0;JMP
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