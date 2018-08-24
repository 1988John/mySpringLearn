package com.foo.common.utils;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Title:FlowFile Description: 文件操作 记录待充值流量客户 Company:HPE
 * 
 * @author jiangwang
 * @date Oct 20, 2016 7:46:34 PM
 */

public class FlowFileUtil {

	private static final Integer FILE_BUFFER_SIZE = 1024;

	/**
	 * 创建文件
	 * @author jiangwang
	 * @date 9:03 2018/8/24
	 */
	public static boolean createFile(File fileName) {
		boolean flag = false;
		try {
			if (!fileName.exists()) {
				flag = fileName.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 写入文件
	 * @author jiangwang
	 * @date 9:03 2018/8/24
	 */
	public static void writeToTxt(File filename, String str) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filename, true);
			fos.write(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null){
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 写入文件
	 * @author jiangwang
	 * @date 9:02 2018/8/24
	 */
	public static void writeToTxt(File filename, List<String> list, boolean flag) {

		StringBuffer sb = new StringBuffer(list.size() + "\n");// 文件第一行存储总条数
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		list.clear();
		OutputStreamWriter oStreamWriter = null;
		String str = sb.toString();
		try {

			oStreamWriter = new OutputStreamWriter(new FileOutputStream(
					filename, flag), "UTF-8");
			oStreamWriter.append(str);
			oStreamWriter.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oStreamWriter.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * 写入文件(覆盖版）
	 * @author jiangwang
	 * @date 9:02 2018/8/24
	 */
	public static void writeToTxt(File filename, String str, Boolean flag) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filename, flag);
			fos.write(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 删除指定文件夹下所有文件
	 * @author jiangwang
	 * @date 9:02 2018/8/24
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + File.separator + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + File.separator + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 删除指定文件
	 * @author jiangwang
	 * @date 9:02 2018/8/24
	 */
	public static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteFile(files[i]);
			}
		}
		file.delete();
	}

	/**
	 * 读文件夹里的所有内容
	 * @author jiangwang
	 * @date 9:01 2018/8/24
	 */
	public static List<String> readAllFile(String dirPath) {
		List<String> listStr = new ArrayList<String>();
		File file = new File(dirPath);
		String[] tempList = file.list();
		File temp = null;
		String errFileName = "";
		for (int i = 0; i < tempList.length; i++) {
			errFileName = tempList[i];
			if (!errFileName.startsWith(".")) {
				if (dirPath.endsWith(File.separator)) {
					temp = new File(dirPath + tempList[i]);
				} else {
					temp = new File(dirPath + File.separator + tempList[i]);
				}
				listStr = CSVUtils.importCsv(temp);
				listStr.add("error_" + errFileName);
			}
		}
		return listStr;
	}

	/**
	 * 获取文件夹里的所有内容
	 * @author jiangwang
	 * @date 9:01 2018/8/24
	 */
	public static List<String> getAllFile(String dirPath) {
		List<String> listStr = new ArrayList<String>();
		File file = new File(dirPath);
		String[] tempList = file.list();
		for (int i = 0; i < tempList.length; i++) {
			if (!tempList[i].startsWith(".")){
				listStr.add(tempList[i]);
			}
		}
		return listStr;
	}

	/**
	 * 读单独文件
	 * @author jiangwang
	 * @date 9:01 2018/8/24
	 */
	public static List<String> readSoleFile(String dirPath, String filename) {
		List<String> listStr = new ArrayList<String>();
		File temp = null;
		if (dirPath.endsWith(File.separator)) {
			temp = new File(dirPath + filename);
		} else {
			temp = new File(dirPath + File.separator + filename);
		}
		listStr = CSVUtils.importCsv(temp);
		return listStr;
	}

	/**
	 * 删除文件夹
	 * @author jiangwang
	 * @date 9:01 2018/8/24
	 */
	public static void delFolder(String folderPath) {
		try {
			// 删除完里面所有内容
			delAllFile(folderPath);
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改文件名
	 * @author jiangwang
	 * @date 9:01 2018/8/24
	 */
	public static void renameFile(String name, String newName) {
		File toBeREnamed = new File(name);

		if (!toBeREnamed.exists() || toBeREnamed.isDirectory()) {
			return;
		} else {
			File newFile = new File(newName);
			toBeREnamed.renameTo(newFile);
		}
	}

	/**
	 * 将srcPath文件夹下所有文件复制到aimPath下
	 * @author jiangwang
	 * @date 9:00 2018/8/24
	 */
	public static void transferFiles(String srcPath, String aimPath) {
		File srcfile = new File(srcPath);
		File aimfile = new File(aimPath);
		byte[] buffer = new byte[FILE_BUFFER_SIZE];
		int len = 0;// 记录每一次读取的长度
		if (srcfile.isFile() && !srcfile.getName().startsWith(".")) {
			FileInputStream is = null;
			FileOutputStream ps = null;
			try {
				is = new FileInputStream(srcfile);
				ps = new FileOutputStream(aimfile);
				while ((len = is.read(buffer)) != -1) {
					ps.write(buffer, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
					ps.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (srcfile.isDirectory()) {
			String[] list = srcfile.list();
			for (int i = 0; i < list.length; i++) {
				String childSrcPath = srcPath + File.separator + list[i];
				String childAimPath = aimPath + File.separator + list[i];
				File childSrcFile = new File(childSrcPath);
				File childAimFile = new File(childAimPath);
				if (childSrcFile.isDirectory())// 如果源文件是文件夹 需在目标文件夹中创建该文件夹
					childAimFile.mkdir();// 在目标文件夹中创建子文件夹
				transferFiles(childSrcPath, childAimPath);
			}
		}
	}

	/**
	 * 先根据长度排序 若长度一样则根据大小排序
	 * @author jiangwang
	 * @date 9:00 2018/8/24
	 */
	public static List<String> sortByLengthAndSize(String[] arrStr) {
		Arrays.sort(arrStr);// 先按大小排序
		List<Integer> lenList = new ArrayList<Integer>();
		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < arrStr.length; i++) {// 获取所有可能的长度
			if (!lenList.contains(arrStr[i].length())) {
				lenList.add(arrStr[i].length());
			}
		}
		Collections.sort(lenList);// 将长度按大小排序
		for (int temp : lenList) {
			for (int i = 0; i < arrStr.length; i++) {
				if (arrStr[i].length() == temp) {
					strList.add(arrStr[i]);
				}
			}

		}
		return strList;
	}
}
