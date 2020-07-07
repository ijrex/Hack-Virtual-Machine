load not.asm,
output-file not.out,
compare-to not.cmp,
output-list RAM[0]%D2.6.2 RAM[256]%D2.6.2;

set RAM[0] 257, 
set RAM[256] 0,  

repeat 10 {      
  ticktock;
}

output;        

set PC 0,
set RAM[0] 257,  
set RAM[256] 32767,  

repeat 10 {     
  ticktock;
}

output;         
