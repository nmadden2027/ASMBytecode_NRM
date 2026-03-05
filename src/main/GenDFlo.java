package main;
import java.io.FileOutputStream;
import java.io.IOException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.*;

public class GenDFlo {
    public static void main(String args[]) throws IOException {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(V11, ACC_PUBLIC + ACC_SUPER, "DFlo", null, "java/lang/Object", null);
        {
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();
        mv.visitLdcInsn(15.0f);
        mv.visitVarInsn(FSTORE, 1);
        mv.visitLdcInsn(4.0f);
        mv.visitVarInsn(FSTORE, 2);
        mv.visitVarInsn(FLOAD, 1);
        mv.visitVarInsn(FLOAD, 2);
        mv.visitInsn(FDIV);
        mv.visitVarInsn(FSTORE, 3);
        mv.visitLdcInsn(22.0);
        mv.visitVarInsn(DSTORE, 4);
        mv.visitLdcInsn(7.0);
        mv.visitVarInsn(DSTORE, 6);
        mv.visitVarInsn(DLOAD, 4);
        mv.visitVarInsn(DLOAD, 6);
        mv.visitInsn(DDIV);
        mv.visitVarInsn(DSTORE, 8);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(FLOAD, 3);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(DLOAD, 8);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        cw.visitEnd();
        
        FileOutputStream out = new FileOutputStream("bin/DFlo.class");
        out.write(cw.toByteArray());
        out.close();
    }
}