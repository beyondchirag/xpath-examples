package xpath.examples.Utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Utils {

	public static Document getTestXMLDoc() {
		Document doc = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(false);
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse("test.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doc;
	}
	
	public static void outputSeparator() {
		System.out.println("-----------------------------------\n\n");
	}
	
}
