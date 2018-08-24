package com.foo.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangwang
 */
public class CSVUtils {

	/**
	 * 导出
	 * 
	 * @param file
	 *            csv文件(路径+文件名)，csv文件不存在会自动创建
	 * @param dataList
	 *            数据
	 */
	public static boolean exportCsv(File file, List<String> dataList) {
		boolean isSucess = false;

		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out, "utf8");
			bw = new BufferedWriter(osw);
			if (dataList != null && !dataList.isEmpty()) {
				for (String data : dataList) {
					bw.append(data).append("\r");
				}
			}
			isSucess = true;
		} catch (Exception e) {
			isSucess = false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw != null) {
				try {
					osw.close();
					osw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return isSucess;
	}

	/**
	 * 导入
	 * 
	 * @param file
	 *            csv文件(路径+文件)
	 */
	public static List<String> importCsv(File file) {
		List<String> dataList = new ArrayList<String>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					file), "UTF-8"));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (StringUtils.isNotBlank(line)) {
					dataList.add(line);
				}
			}
		} catch (Exception e) {

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return dataList;
	}
}