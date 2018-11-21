import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceMethodVisitor;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Utils {
    public static String insnToString(AbstractInsnNode insn){
        insn.accept(mp);
        StringWriter sw = new StringWriter();
        printer.print(new PrintWriter(sw));
        printer.getText().clear();
        return sw.toString();
    }

    private static Printer printer = new Textifier();
    private static TraceMethodVisitor mp = new TraceMethodVisitor(printer);

    public static boolean isAbstract(MethodNode methodNode) {
        return (methodNode.access & Opcodes.ACC_ABSTRACT) != 0;
    }

    public static boolean isStatic(MethodNode methodNode) {
        return (methodNode.access & Opcodes.ACC_STATIC) != 0;
    }

    public static boolean isStatic(MethodInsnNode methodNode) {
        return methodNode.getOpcode() == Opcodes.INVOKESTATIC;
    }
    
    public static String toString(VarInsnNode node) {
        return opcodeToString(node.getOpcode()) + " " + node.var;
    }
    
    public static String toString(MethodInsnNode node) {
        return opcodeToString(node.getOpcode()) + " " + node.owner + "." + node.name + " " + node.desc;
    }
    
    public static String toString(FieldInsnNode node) {
        return opcodeToString(node.getOpcode()) + " " + node.owner + "." + node.name + " " + node.desc;
    }
    
    public static String toString(TypeInsnNode node) {
        return opcodeToString(node.getOpcode()) + " " + node.desc;
    }
    
    public static String toString(LabelNode node) {
        return "LABEL";
    }
    
    public static String opcodeToString(int opcode) {
        switch (opcode) {
            case Opcodes.INVOKESTATIC:
                return "invokestatic";
            default:
                return Integer.toString(opcode);
        }
    }
    
}
