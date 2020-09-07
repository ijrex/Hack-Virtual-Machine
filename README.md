# Hack-Virtual-Machine

## Converts programmes written in the Hack Virtual Machine (VM) language to Hack Machine Assembly (ASM) code designated for the Hack hardware platform.

This personal project was created as an accompaniment for Chapters 7 and 8 of the book The Elements of Computing Systems. The aforementioned should be referenced for full specification of the Hack VM and Hack ASM languages. 

—

Purpous:

Takes one or more Hack VM (.vm) files as input and outputs a single Hack ASM (.asm) file to the same directory.

Project Structure:

VMTranslator: Software entry point

Loads VM file, creates CommandLib (described below) and initiates Read/Write  (described below).

—

#commandlib package 

## Defines Hack VM language commands

- Defines all commands in the Hack VM Language using templates from the Command package.

## Returns commands and other chunks of assembly output as strings.

- CommandLib

VM commands to be parsed into ASM code. All VM commands are defined in the `assignCommandDescriptions` method and are described using the nested Commands package.  

Commands are loaded into the `commands` map by type and syntax:

`commands.put("push", new PushCommand(new String[] { "push", "LOCATION", "VALUE" }, true));

In the above example: 
- `push` is referenced in the map by its name
- The string array describes `push`’s expected arguments. e.g. { "push", "LOCATION", "VALUE" } might be seen in VM as `push constant 999`. Where relevant, args should match the variables used in their .asm template file (described below).
- Certain commands need to know the class name of the .vm file being parsed. This information can be passed by appending `true` in the constructor.

### How commands get written

- Write (`write`)
VM commands parsed while traversing through the .vm file

- Bootstrap code (`init`)
Chunks of code to be ran prior to any compiled .vm code. 

- Libraries (`lib `)
Libs contain chunks of reusable code which don’t take on the complex stack requirements of functions. Commands described in the command library may yield using Libs.

The specific Lib for this project is the Arithmetic Library. For example, the VM command `neg` is parsed in a way that the assembly output will jump to the location of the `neg` command in the Arithmetic Library computer program, perform its operation on the stack and jump back to where it left off.  


# commandlib.command package

Templates for all VM commands are defined in this package using the abstract `Command` class. VM code can be parsed in different ways but the `write` method must always return a String Array holding individual lines of assembly code, this is essential for the `commandlib` package to keep track of the output file’s line number.

## Command Classes

Most `commandlib.command` classes use .asm template files to be further parsed with specific arguments. 

Using the `FunctionCommand` command as an example. The .vm file supplies something like `function Main.fibonacci 3`, where the virtual machine sees arg[1] as `Main.fibonacci ` and arg[2] as `3`

1. On creation, the constructor has already loaded an asm file called `function-locals.asm` into the class’s `output` variable
2. The `write` method handles the arguments appropriately.
	- Injecting arg[1] into a .asm label command
	- Performing a regex search on the template file to replace all instances of `$V$_VALUE_$V$` with arg[2] 

## Template files 

Template files are saved outside of the main project in the `/lib/command-library` directory and should be fetched using the `loadTemplateFile` util. Template files are searched recursively; the folder structure inside of  `/lib/command-library` exists to aid the developer but is not required by the package. 

It should be noted that the .asm template files can run on the Hack CPU emulator and therefore, have their own unit tests.

To make life easier for the developer, a common syntax is recommended for template file variables. The prefix and suffix are outlined below, the middle text should be uppercase and informative to the developer of the intended output.

$V$

A user-defined variable argument to be parsed by the Virtual machine. These should match the arguments described in the `assignCommandDescriptions` method of the `commandlib` package.

e.g.

$V$_VALUE_$V$
$V$_LOCATION_$V$


$C$

A non user-defined variable argument to be parsed by the Virtual machine: In the below example, the END_OF_BLOCK isn’t an argument explicitly defined in the VM code, but is required by the parser to allocate a specific memory address.

e.g.

@$C$_END_OF_BLOCK_$C$

$S$

A static variable name. These are not explicitly defined in the VM code but rather the name of the .vm file itself (which is also the class name). Further reading on static variables here.

e.g. 

$S$_STATIC_$S$

$L$

Used to point to Libs. As an example, the following is replaced to point to a specific command in the Arithmetic Lib; the `add` command template will be parsed: `@$L$_ARITHMETIC_LIB_$L$` > `@ARITHMETIC_ADD`

e.g. 

$L$_ARITHMETIC_LIB_$L$

## `commandlib.command.memorylocation`

Certain pointers have specific memory locations on the Hack hardware platform. As an example, `local` is significant enough to have a designated value in the hack assembly language (`LCL`), `temp` doesn’t have its own value but is stored in `R5` (RAM[5]).

This package stores all memory locations/bases as constants and can be parsed/referenced using the provided methods.










