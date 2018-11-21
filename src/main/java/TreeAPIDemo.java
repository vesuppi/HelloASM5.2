import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import static java.lang.System.out;

public class TreeAPIDemo {
    public static void testReadClass() {
//        InputStream in= null;
//        try {
//            in = new FileInputStream("test/Foo.class");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        InputStream in = HelloASM.class.getResourceAsStream("/java/lang/String.class");

        ClassReader cr= null;
        try {
            cr = new ClassReader(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClassNode classNode=new ClassNode();

        //ClassNode is a ClassVisitor
        cr.accept(classNode, 0);

        //Let's move through all the methods

        for(Object methodobj: classNode.methods){
            MethodNode methodNode = (MethodNode)methodobj;
            System.out.println(methodNode.name+"  "+methodNode.desc);

            Iterator<AbstractInsnNode> insnNodes=methodNode.instructions.iterator();
            while(insnNodes.hasNext()){
                AbstractInsnNode insn = insnNodes.next();
                
                if (insn instanceof MethodInsnNode) {
                    out.println(((MethodInsnNode) insn).name);
                    out.print(insn.getOpcode() + " " + Utils.insnToString(insn));
                    //out.println(Utils.toString((MethodInsnNode) insn));
                }
            }

//            System.out.println(methodNode.instructions);
//
//            //A method can have multiple places for return
//            //All of them must be handled.
//            insnNodes=methodNode.instructions.iterator();
//            while(insnNodes.hasNext()){
//                AbstractInsnNode insn=insnNodes.next();
//                System.out.println(insn.getOpcode());
//
//                if(insn.getOpcode()==Opcodes.IRETURN
//                        ||insn.getOpcode()==Opcodes.RETURN
//                        ||insn.getOpcode()==Opcodes.ARETURN
//                        ||insn.getOpcode()==Opcodes.LRETURN
//                        ||insn.getOpcode()==Opcodes.DRETURN){
//                    InsnList endList=new InsnList();
//                    endList.add(new LdcInsnNode(methodNode.name));
//                    endList.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "com/geekyarticles/asm/Logger", "logMethodReturn", "(Ljava/lang/String;)V"));
//                    methodNode.instructions.insertBefore(insn, endList);
//                }
//
//            }
        }

    }

}