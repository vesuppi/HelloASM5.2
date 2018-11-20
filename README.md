Surprisingly, tutorials on asm are not abundant and well-explained.

Most of this code comes from:
- https://www.javacodegeeks.com/2012/02/manipulating-java-class-files-with-asm.html

Seems like ASM can only visit each type of instructions, like `visitInsn`,
`visitIntInsn` etc. You can take actions when a certain type of insn is visited,
but I am not sure how to iterate every instructions like `getInstructions()`.