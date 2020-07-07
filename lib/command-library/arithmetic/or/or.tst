load or.asm,
output-file or.out,
compare-to or.cmp,
output-list RAM[0]%D2.6.2 RAM[256]%D2.6.2;

set RAM[0] 258,
set RAM[256] 1, 
set RAM[257] 1,

repeat 10 {   
  ticktock;
}

output;  

set PC 0,
set RAM[0] 258,
set RAM[256] 2, 
set RAM[257] 1,

repeat 10 {   
  ticktock;
}

output;  

set PC 0,
set RAM[0] 258,
set RAM[256] 0, 
set RAM[257] 0,

repeat 10 {   
  ticktock;
}

output;  