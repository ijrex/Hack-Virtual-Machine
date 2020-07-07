load sub.asm,
output-file sub.out,
compare-to sub.cmp,
output-list RAM[0]%D2.6.2 RAM[256]%D2.6.2;

set RAM[0] 258,
set RAM[256] 15, 
set RAM[257] 10,

repeat 10 {   
  ticktock;
}

output;  

set PC 0,
set RAM[0] 258,
set RAM[256] 15, 
set RAM[257] 15,

repeat 10 {   
  ticktock;
}

output;  