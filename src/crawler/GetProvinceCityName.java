package crawler;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 
 * @author liugang
 *
 */
public class GetProvinceCityName {
	private Document document;
	
	public GetProvinceCityName(String fileName) throws DocumentException{
		SAXReader reader = new SAXReader();
		this.document = reader.read(new File(fileName));
	}
	public void traverse(Document document)
	{
		Element root = document.getRootElement();
		for(Iterator<Element> i = root.elementIterator();i.hasNext();){
			Element province = (Element)i.next();
			Attribute name = (Attribute) province.attribute("name");
			System.out.println(name.getValue());
		}
	}
	public String getProvince(int provinceId){
		System.out.println("[" + new Date().toString() + "]" + "***Spider.Tools.GetProvinceCityName***");
		Element root = this.document.getRootElement();
		for(Iterator<Element> i = root.elementIterator();i.hasNext();){
			Element province = (Element)i.next();
			Attribute id = (Attribute)province.attribute("id");
			if(id.getValue().equals(Integer.toString(provinceId))){
				Attribute name = (Attribute)province.attribute("name");
				return name.getValue();
			}
		}
		return "";
	}
	public String getCity(int provinceId,int cityId){
		System.out.println("[" + new Date().toString() + "]" + "***Spider.Tools.GetProvinceCityName***");
		if(provinceId == 100)
			return "鍏朵粬";
		Element root = this.document.getRootElement();
		for(Iterator<Element> i = root.elementIterator();i.hasNext();){
			Element province = (Element)i.next();
			Attribute id = (Attribute)province.attribute("id");
			if(id.getValue().equals(Integer.toString(provinceId))){
				for(Iterator<Element> j = province.elementIterator();j.hasNext();){
					Element city = (Element)j.next();
					Attribute cid = (Attribute)city.attribute("id");
					if(cid.getValue().equals(Integer.toString(cityId))){
						Attribute name = (Attribute)city.attribute("name");
						return name.getValue();
					}
				}
			}
		}
		return "";
	}
	public static void main(String[] args) throws DocumentException {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍?
		GetProvinceCityName gpc = new GetProvinceCityName("provinces.xml");
		System.out.println(gpc.getProvince(100));
		System.out.println(gpc.getCity(100,1000));
		System.out.println("Done");
	}
}
