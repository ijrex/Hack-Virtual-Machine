// FRAME = LCL
@LCL
D=M
@R14
M=D

// RET = *(FRAME-5)
@5
D=A
@R14
A=M-D
A=M
D=A
@R15
M=D

// ARG = pop(top of stack)
@SP
A=M-1
D=M
@ARG
A=M
M=D

// SP = ARG + 1
@ARG
D=M
@SP
M=D+1

// THAT = *(FRAME-1)
@R14
M=M-1
A=M
D=M
@THAT
M=D

// THIS = *(FRAME-2)
@R14
M=M-1
A=M
D=M
@THIS
M=D

// ARG = *(FRAME-3)
@R14
M=M-1
A=M
D=M
@ARG
M=D

// LCL = *(FRAME-4)
@R14
M=M-1
A=M
D=M
@LCL
M=D

// GOTO RETURN ADDRESS
@R15
A=M
0;JMP
