package main;

import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.*;

public class GenMInt {

    public static void main(String args[]) throws IOException {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(V11, ACC_PUBLIC + ACC_SUPER, "MInt", null, "java/lang/Object", null);

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
        mv.visitIntInsn(BIPUSH, 3);
        mv.visitVarInsn(ISTORE, 1);
        mv.visitIntInsn(BIPUSH, 4);
        mv.visitVarInsn(ISTORE, 2);
        mv.visitVarInsn(ILOAD, 1);
        mv.visitVarInsn(ILOAD, 2);
        mv.visitInsn(IMUL);
        mv.visitVarInsn(ISTORE, 3);          
        mv.visitLdcInsn(5.5);
        mv.visitVarInsn(DSTORE, 4);          
        mv.visitLdcInsn(2.0);
        mv.visitVarInsn(DSTORE, 6);          
        mv.visitVarInsn(DLOAD, 4);
        mv.visitVarInsn(DLOAD, 6);
        mv.visitInsn(DMUL);
        mv.visitVarInsn(DSTORE, 8);          
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(ILOAD, 3);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(DLOAD, 8);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        cw.visitEnd();
        
        FileOutputStream out = new FileOutputStream("bin/MInt.class");
                out.write(cw.toByteArray());
                out.close();
    }
}
