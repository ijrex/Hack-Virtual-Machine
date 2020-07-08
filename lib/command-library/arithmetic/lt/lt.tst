load lt.asm,
output-file lt.out,
compare-to lt.cmp,
output-list RAM[0]%D2.6.2 RAM[256]%B2.16.2;

set RAM[0] 258,
set RAM[256] 15,
set RAM[257] 20,

repeat 20 {   
  ticktock;
}

output;

set PC 0,
set RAM[0] 258,
set RAM[256] 15, 
set RAM[257] 15,

repeat 20 {   
  ticktock;
}

output;  

set PC 0,
set RAM[0] 258,
set RAM[256] 0, 
set RAM[257] 0,

repeat 20 {   
  ticktock;
}

output;  

set PC 0,
set RAM[0] 258,
set RAM[256] 200, 
set RAM[257] 100,

repeat 20 {   
  ticktock;
}

output;  