package com.skcoder.interviewpoints.jvms;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.IO.println;

public class CustomClassLoaderForMultpleClazz extends ClassLoader {

    private final String classesDir;

    public CustomClassLoaderForMultpleClazz(String classesDir) {
        this.classesDir = classesDir;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.replace('.', '/') + ".class";
            println("fileName:: " + fileName);
            Path classFile = Paths.get(classesDir, fileName);
            println("classFile:: " + classFile);
            byte[] classBytes = Files.readAllBytes(classFile);
            println("classBytes:: " + Arrays.toString(classBytes));
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class " + name, e);
        }
    }


    public static void main(String[] args) throws Exception {
        String pluginDir = "C:/Users/HP/Documents/plugins/class";
        CustomClassLoaderForMultpleClazz loader = new CustomClassLoaderForMultpleClazz(pluginDir);

        // Scan all .class files under plugins directory
        try (Stream<Path> paths = Files.walk(Paths.get(pluginDir))) {
            paths.filter(p -> p.toString().endsWith(".class")).forEach(classFile -> {
                try {
                    // Convert file path back to class name
                    String relativePath = Paths.get(pluginDir).relativize(classFile).toString();
                    String className = relativePath
                            .replace(FileSystems.getDefault().getSeparator(), ".")
                            .replace(".class", "");

                    // Load class dynamically
                    Class<?> pluginClass = loader.loadClass(className);
                    Object pluginInstance = pluginClass.getDeclaredConstructor().newInstance();

                    // Try invoking sayHello or sayGoodbye if present
                    try {
                        pluginClass.getMethod("sayHello").invoke(pluginInstance);
                    } catch (NoSuchMethodException ignored) {
                    }
                    try {
                        pluginClass.getMethod("sayGoodbye").invoke(pluginInstance);
                    } catch (NoSuchMethodException ignored) {
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
