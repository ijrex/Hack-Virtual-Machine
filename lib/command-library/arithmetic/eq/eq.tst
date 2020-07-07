load eq.asm,
output-file eq.out,
compare-to eq.cmp,
output-list RAM[0]%D2.6.2 RAM[256]%D2.6.2;

set RAM[0] 258,
set RAM[256] 15,
set RAM[257] 16,

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
set RAM[256] 13298, 
set RAM[257] 333,

repeat 20 {   
  ticktock;
}

output;  