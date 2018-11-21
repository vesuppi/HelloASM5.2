This tutorial shows ASM's visitor API and Tree API.

# Build & Run
```bash
# Build an executable jar
$ mvn clean compile assembly:single

# Run it
$ java -jar target/hello-asm-1.0-SNAPSHOT-jar-with-dependencies.jar
```

# References
- https://www.javacodegeeks.com/2012/02/manipulating-java-class-files-with-asm.html
- https://www.javacodegeeks.com/2012/02/manipulating-java-class-files-with-asm_22.html
- ASM 4 User Guide
- https://github.com/llbit/ow2-asm/tree/master/src/org/objectweb/asm/tree (Correspond an opcode to a XXNode)