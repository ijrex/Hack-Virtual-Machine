load neg.asm,
output-file neg.out,
compare-to neg.cmp,
output-list RAM[0]%D2.6.2 RAM[256]%2.6.2;

set RAM[0] 257,  
set RAM[256] 15, 

repeat 10 {      
  ticktock;
}

output;        
