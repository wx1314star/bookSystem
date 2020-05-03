package wx.test;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import wx.utils.ExcelUtils;
import wx.utils.WordUtils;

public class ExcelManager {
	/**
	 * 导入文件流
	 */
	public static Map<Object, List<Object>> readExcel(InputStream is, Class clazz) {
		// BufferedInputStream bis = null;
		// ExcelReader reader = null;
		Map<Object, List<Object>> map = new HashMap<Object, List<Object>>();
		try {
//			bis = new BufferedInputStream(is);
//			AnalysisEventListener listener = new ExcelListener();
//			reader = EasyExcelFactory.getReader(bis, listener);
//			reader.read(new Sheet(1, 1, clazz));

			// 读取部分sheet
			String filePath = "/Users/wx/Desktop/北流复核统计情况表.xlsx";
			int flag = 1;
			// 第一个1代表sheet1, 第二个1代表从第几行开始读取数据，行号最小值为0
			Sheet sheetOne = new Sheet(flag, 1);
			List<Object> objectsOne = ExcelUtils.readMoreThan1000RowBySheet(filePath, sheetOne);
			if (objectsOne.size() < 0 || objectsOne.isEmpty()) {
				return map;
			}
			map.put(flag, objectsOne);
			flag++;
			objectsOne = null;

			Sheet sheetTwo = new Sheet(flag, 1);
			objectsOne = ExcelUtils.readMoreThan1000RowBySheet(filePath, sheetTwo);
			if (objectsOne.size() < 0 || objectsOne.isEmpty()) {
				return map;
			}
			map.put(flag, objectsOne);
			flag++;
			objectsOne = null;
			Sheet sheetThree = new Sheet(flag, 1);
			objectsOne = ExcelUtils.readMoreThan1000RowBySheet(filePath, sheetThree);
			if (objectsOne.size() < 0 || objectsOne.isEmpty()) {
				return map;
			}
			map.put(flag, objectsOne);
			flag++;
			objectsOne = null;
//			Sheet sheetThree = new Sheet(3, 1);
//			List<Object> objectsThree = ExcelUtils.readMoreThan1000RowBySheet(filePath, sheetThree);
//			for (Object object : objectsThree) {
//				System.out.println(object.toString());
//			}
//			Sheet sheetFour = new Sheet(4, 1);
//			List<Object> objectsFour = ExcelUtils.readMoreThan1000RowBySheet(filePath, sheetFour);
//			for (Object object : objectsFour) {
//				System.out.println(object.toString());
//			}
//			Sheet sheetFive = new Sheet(5, 1);
//			List<Object> objectsFive = ExcelUtils.readMoreThan1000RowBySheet(filePath, sheetFive);
//			for (Object object : objectsFive) {
//				System.out.println(object.toString());
//			}
//			Sheet sheetSix = new Sheet(6, 1);
//			List<Object> objectsSix = ExcelUtils.readMoreThan1000RowBySheet(filePath, sheetSix);
//			for (Object object : objectsSix) {
//				System.out.println(object.toString());
//			}
			// String fileName = TestFileUtil.getPath() + "demo" + File.separator +
			// "demo.xlsx";
//			String fileName = "/Users/wx/Desktop/北流复核统计情况表.xlsx";
//			ExcelReader excelReader = EasyExcel.read(fileName).build();
//			DemoDataListener d = new DemoDataListener();
//			DemoDataListener d1 = new DemoDataListener();
//			// 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
//			ReadSheet readSheet1 = EasyExcel.readSheet(0).head(Student.class).registerReadListener(d).build();
//			ReadSheet readSheet2 = EasyExcel.readSheet(1).head(Student.class).registerReadListener(d1).build();
//			// 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
//			excelReader.read(readSheet1, readSheet2);
//			List list = d.list;
//			System.out.println(list.size());
//			for (Object object : list) {
//				System.out.println(object.toString());
//			}
//			// 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//			excelReader.finish();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return map;
	}

	/**
	 * 导出文件流
	 */
	public static Boolean writeExcel(OutputStream os, Class clazz, List<? extends BaseRowModel> data) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(os);
			ExcelWriter writer = new ExcelWriter(bos, ExcelTypeEnum.XLSX);
			Sheet sheet = new Sheet(1, 0, clazz);
			writer.write(data, sheet);
			writer.finish();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			// fis = new FileInputStream("E:\\学生表.xlsx");
			fis = new FileInputStream("/Users/wx/Desktop/北流复核统计情况表.xlsx");
			// System.out.println(System.getProperty("user.dir"));

			Map<Object, List<Object>> map = ExcelManager.readExcel(fis, WordTemplate.class);
			System.out.println(map.size());
			System.out.println("导入成功：");
			List<Object> list = map.get(1);
			for (Object object : list) {
				System.out.println(object.toString());
			}
			// LocalWareExcelListener<Student> localWareExcelListener = new
			// LocalWareExcelListener<>();

			// List<Student> datas = localWareExcelListener.getDatas();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//		FileOutputStream fos = null;
//		try {
//			fos = new FileOutputStream("/Users/wx/Desktop/学生导出表.xlsx");
//			List<Student> list = new ArrayList<>();
//			// list.add(new Student("哈哈", "你猜"));
//			Boolean flag = ExcelManager.writeExcel(fos, Student.class, list);
//			System.out.println("导出是否成功:" + flag);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if (fos != null) {
//				try {
//					fos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}

		WordUtils wordUtil = new WordUtils();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("total", "0.789");
		params.put("serialNumber", "sadwerwer");

		try {
//			Map<String, Object> header = new HashMap<String, Object>();
//			header.put("width", 100);
//			header.put("height", 150);
//			header.put("type", "jpg");
//			// header.put("content", WordUtils.inputStream2ByteArray(new
//			// FileInputStream("C:/Users/Administrator/Desktop/jar包/11.jpg"), true));
//			params.put("${header}", header);
//			Map<String, Object> header2 = new HashMap<String, Object>();
//			header2.put("width", 100);
//			header2.put("height", 150);
//			header2.put("type", "jpg");
////			header2.put("content", WordUtils
////					.inputStream2ByteArray(new FileInputStream("C:/Users/Administrator/Desktop/jar包/22.jpg"), true));
////			params.put("${header2}", header2);
//			List<String[]> testList = new ArrayList<String[]>();
//			testList.add(new String[] { "1", "1AA", "1BB", "1CC" });
//			testList.add(new String[] { "2", "2AA", "2BB", "2CC" });
//			testList.add(new String[] { "3", "3AA", "3BB", "3CC" });
//			testList.add(new String[] { "4", "4AA", "4BB", "4CC" });
			String path = "/Users/wx/Desktop/模板2.docx"; // 模板文件位置
			String fileName = "/Users/wx/Desktop/测试模板.docx";
			wordUtil.getWord(path, params, null, fileName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
