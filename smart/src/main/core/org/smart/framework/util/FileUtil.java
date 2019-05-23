package org.smart.framework.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.io.Resources;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.FrameworkConstant;

/**
 * 文件操作工具类
 *
 * @author TY
 * @Time 2017年9月20日 下午9:44:29
 * @since 1.0.0
 */
public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 判断是否为目录 为目录返回true
	 */
	public static boolean isDirectory(File dir) {
		if (dir.exists() && dir.isDirectory() && !dir.getName().contains(ConstantUtil.POINT_S)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断指定名称是否为目录 <br>
	 * 为目录返回true
	 */
	public static boolean isDirectory(String dir) {
		if (!dir.contains(ConstantUtil.POINT_S)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取目录下所有指定文件类型文件 <br>
	 * 包括子目录和子文件 <br>
	 * create by on TY 2017年12月6日 下午2:08:11
	 * 
	 * @param res
	 *            文件路径
	 * @param type
	 *            文件类型
	 * @param list
	 *            返回文件集合
	 * @throws IOException
	 */
	public static void getFileByDirectory(String res, final String type, List<String> fileList) throws IOException {

		URL url = Resources.getResourceURL(res);
		String resUrl = res;
		if (!resUrl.endsWith(ConstantUtil.SPRIT_S)) {
			resUrl += ConstantUtil.SPRIT_S;
		}
		String types = ConstantUtil.POINT_S + type;
		if (url != null && url.getPath() != null) {
			// 获取当前指定文件和目录
			File[] files = new File(url.getPath()).listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					if (name.toLowerCase().endsWith(ConstantUtil.POINT_S + type) || FileUtil.isDirectory(name)) {
						return true;
					}
					return false;
				}
			});
			for (File file : files) {
				if (file.getName().toLowerCase().endsWith(types)) {// 如果是指定文件则添加到链表中
					fileList.add(resUrl + file.getName());
					logger.debug("获取到文件：[" + file.getName() + "]");
				} else if (file.isDirectory()) {// 如果是目录则递归调用
					getFileByDirectory(resUrl + file.getName(), type, fileList);
				}
			}
		}
	}

	/**
	 * 创建目录
	 */
	public static File createDir(String dirPath) {
		File dir;
		try {
			dir = new File(dirPath);
			if (!dir.exists()) {
				FileUtils.forceMkdir(dir);
			}
		} catch (Exception e) {
			logger.error("创建目录出错！", e);
			throw new RuntimeException(e);
		}
		return dir;
	}

	/**
	 * 创建文件
	 */
	public static File createFile(String filePath) {
		File file;
		try {
			file = new File(filePath);
			File parentDir = file.getParentFile();
			if (!parentDir.exists()) {
				FileUtils.forceMkdir(parentDir);
			}
		} catch (Exception e) {
			logger.error("创建文件出错！", e);
			throw new RuntimeException(e);
		}
		return file;
	}

	/**
	 * 复制目录（不会复制空目录）
	 */
	public static void copyDir(String srcPath, String destPath) {
		try {
			File srcDir = new File(srcPath);
			File destDir = new File(destPath);
			if (srcDir.exists() && srcDir.isDirectory()) {
				FileUtils.copyDirectoryToDirectory(srcDir, destDir);
			}
		} catch (Exception e) {
			logger.error("复制目录出错！", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 复制文件
	 */
	public static void copyFile(String srcPath, String destPath) {
		try {
			File srcFile = new File(srcPath);
			File destDir = new File(destPath);
			if (srcFile.exists() && srcFile.isFile()) {
				FileUtils.copyFileToDirectory(srcFile, destDir);
			}
		} catch (Exception e) {
			logger.error("复制文件出错！", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除目录
	 */
	public static void deleteDir(String dirPath) {
		try {
			File dir = new File(dirPath);
			if (dir.exists() && dir.isDirectory()) {
				FileUtils.deleteDirectory(dir);
			}
		} catch (Exception e) {
			logger.error("删除目录出错！", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除文件
	 */
	public static void deleteFile(String filePath) {
		try {
			File file = new File(filePath);
			if (file.exists() && file.isFile()) {
				FileUtils.forceDelete(file);
			}
		} catch (Exception e) {
			logger.error("删除文件出错！", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 重命名文件
	 */
	public static void renameFile(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		if (srcFile.exists()) {
			File newFile = new File(destPath);
			boolean result = srcFile.renameTo(newFile);
			if (!result) {
				throw new RuntimeException("重命名文件出错！" + newFile);
			}
		}
	}

	/**
	 * 将字符串写入文件
	 */
	public static void writeFile(String filePath, String fileContent) {
		OutputStream os = null;
		Writer w = null;
		try {
			FileUtil.createFile(filePath);
			os = new BufferedOutputStream(new FileOutputStream(filePath));
			w = new OutputStreamWriter(os, FrameworkConstant.UTF_8);
			w.write(fileContent);
			w.flush();
		} catch (Exception e) {
			logger.error("写入文件出错！", e);
			throw new RuntimeException(e);
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (w != null) {
					w.close();
				}
			} catch (Exception e) {
				logger.error("释放资源出错！", e);
			}
		}
	}

	/**
	 * 获取真实文件名（去掉文件路径）
	 */
	public static String getRealFileName(String fileName) {
		return FilenameUtils.getName(fileName);
	}

	/**
	 * 判断文件是否存在
	 */
	public static boolean checkFileExists(String filePath) {
		return new File(filePath).exists();
	}

	/**
	 * 判断文件夹是否为空 不为空返回true
	 */
	public static boolean isDirNotEmpty(File dir) {
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			if (files != null && files.length > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断文件夹是否为空 为空返回true
	 */
	public static boolean isDirEmpty(File dir) {
		return isDirNotEmpty(dir);
	}
	
	
}
