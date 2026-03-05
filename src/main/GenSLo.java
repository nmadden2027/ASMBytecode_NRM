package main;

import java.io.FileOutputStream;
import java.io.IOException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.*;

public class GenSLo {
    public static void main(String args[]) throws IOException {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(V11, ACC_PUBLIC + ACC_SUPER, "SLo", null, "java/lang/Object", null);
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
        mv.visitLdcInsn(1000000000L);
        mv.visitVarInsn(LSTORE, 1);
        mv.visitLdcInsn(250000000L);
        mv.visitVarInsn(LSTORE, 3);
        mv.visitVarInsn(LLOAD, 1);
        mv.visitVarInsn(LLOAD, 3);
        mv.visitInsn(LSUB);
        mv.visitVarInsn(LSTORE, 5);
        mv.visitLdcInsn(9.99);
        mv.visitVarInsn(DSTORE, 7);
        mv.visitLdcInsn(4.55);
        mv.visitVarInsn(DSTORE, 9);
        mv.visitVarInsn(DLOAD, 7);
        mv.visitVarInsn(DLOAD, 9);
        mv.visitInsn(DSUB);
        mv.visitVarInsn(DSTORE, 11);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(LLOAD, 5);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(DLOAD, 11);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        cw.visitEnd();
        
        FileOutputStream out = new FileOutputStream("bin/SLo.class");
        out.write(cw.toByteArray());
        out.close();
    }
}
