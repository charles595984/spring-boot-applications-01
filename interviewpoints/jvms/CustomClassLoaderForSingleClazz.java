package com.skcoder.interviewpoints.jvms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.IO.println;

public class CustomClassLoaderForSingleClazz extends ClassLoader {
    private final String classesDir;

    public CustomClassLoaderForSingleClazz(String classesDir) {
        this.classesDir = classesDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // Convert class name to file path
            String fileName = name.replace('.', File.separatorChar) + ".class";
            println("File name:" + fileName);

            Path classFile = Paths.get(classesDir, fileName);
            println("classFile:" + classFile);

            // Read bytes from the class file
            byte[] classBytes = Files.readAllBytes(classFile);
            println("classBytes:" + classBytes);

            // Define the class in JVM
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class " + name, e);
        }
    }

    public static void main(String[] args) throws Exception {
        // Point to your plugins directory under Documents
        String pluginDir = "C:/Users/HP/Documents/plugins/class";
        //String pluginDir = "C:\\Users\\HP\\Documents\\plugins";

        // Example usage: load a class from "plugins" directory
        CustomClassLoaderForSingleClazz loader = new CustomClassLoaderForSingleClazz(pluginDir);

        // Suppose we have a class file plugins/com/example/Hello.class
        Class<?> helloClass = loader.loadClass("com.example.HelloPlugin");

        // Create instance and invoke method
        Object obj = helloClass.getDeclaredConstructor().newInstance();
        println("Object from classloader: " + obj);
        helloClass.getMethod("sayHello").invoke(obj);
    }
}
