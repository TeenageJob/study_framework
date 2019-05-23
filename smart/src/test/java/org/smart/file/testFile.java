package org.smart.file;

import java.io.File;
import java.io.FileFilter;

public class testFile {
	public static void main(String[] args) {
		String packagePath = "C:/Users/源/Desktop/mywebframe/ty/smart/target/classes";
		File[] files = new File(packagePath).listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
			}
		});
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
}
