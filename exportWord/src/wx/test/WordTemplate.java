package wx.test;

import java.io.Serializable;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class WordTemplate extends BaseRowModel implements Serializable {

	@ExcelProperty(index = 0, value = "序号")
	private String serialNumber;
	@ExcelProperty(index = 1, value = "地块编号")
	private String plotNumber;
	@ExcelProperty(index = 2, value = "水田")
	private String paddyField;
	@ExcelProperty(index = 3, value = "旱地")
	private String dryLand;
	@ExcelProperty(index = 4, value = "小计")
	private String subtotalOne;
	@ExcelProperty(index = 5, value = "果园")
	private String orchard;
	@ExcelProperty(index = 6, value = "林地")
	private String woodland;
	@ExcelProperty(index = 7, value = "农村道路")
	private String ruralRoad;
	@ExcelProperty(index = 8, value = "坑塘水面")
	private String pondWaterSurface;
	@ExcelProperty(index = 9, value = "沟渠")
	private String ditch;
	@ExcelProperty(index = 10, value = "田坎")
	private String ridgeOfField;
	@ExcelProperty(index = 11, value = "小计")
	private String subtotalTWo;
	@ExcelProperty(index = 12, value = "合计")
	private String total;
	@ExcelProperty(index = 13, value = "施工方实际施工面积")
	private String constructionArea;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPlotNumber() {
		return plotNumber;
	}

	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}

	public String getPaddyField() {
		return paddyField;
	}

	public void setPaddyField(String paddyField) {
		this.paddyField = paddyField;
	}

	public String getDryLand() {
		return dryLand;
	}

	public void setDryLand(String dryLand) {
		this.dryLand = dryLand;
	}

	public String getSubtotalOne() {
		return subtotalOne;
	}

	public void setSubtotalOne(String subtotalOne) {
		this.subtotalOne = subtotalOne;
	}

	public String getOrchard() {
		return orchard;
	}

	public void setOrchard(String orchard) {
		this.orchard = orchard;
	}

	public String getWoodland() {
		return woodland;
	}

	public void setWoodland(String woodland) {
		this.woodland = woodland;
	}

	public String getRuralRoad() {
		return ruralRoad;
	}

	public void setRuralRoad(String ruralRoad) {
		this.ruralRoad = ruralRoad;
	}

	public String getPondWaterSurface() {
		return pondWaterSurface;
	}

	public void setPondWaterSurface(String pondWaterSurface) {
		this.pondWaterSurface = pondWaterSurface;
	}

	public String getDitch() {
		return ditch;
	}

	public void setDitch(String ditch) {
		this.ditch = ditch;
	}

	public String getRidgeOfField() {
		return ridgeOfField;
	}

	public void setRidgeOfField(String ridgeOfField) {
		this.ridgeOfField = ridgeOfField;
	}

	public String getSubtotalTWo() {
		return subtotalTWo;
	}

	public void setSubtotalTWo(String subtotalTWo) {
		this.subtotalTWo = subtotalTWo;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getConstructionArea() {
		return constructionArea;
	}

	public void setConstructionArea(String constructionArea) {
		this.constructionArea = constructionArea;
	}

	@Override
	public String toString() {
		return "Show{\" + \"serialNumber=" + getSerialNumber() + '\'' + "," + "plotNumber='" + plotNumber + '\''
				+ ", total='" + getTotal() + '\'' + '}';
	}

}
