package wx.test;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class ExcelListener extends AnalysisEventListener {
	@Override
	public void invoke(Object object, AnalysisContext context) {
		System.out.println("当前行：" + context.getCurrentRowNum());
		System.out.println("当前数据:" + object);
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		System.out.println("=============" + context.getCurrentRowNum() + "结束===============");
	}
}
