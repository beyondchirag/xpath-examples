package xpath.examples;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XpathHelper {

	public static NodeList evaluateXPathNodeList(Document document, String xpathExpression) {
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList nodes = null;
		try {
			XPathExpression expr = xpath.compile(xpathExpression);
			nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return nodes;
	}

	public static Node evaluateXPathNode(Document document, String xpathExpression) {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Node data = null;
		try {
			XPathExpression expr = xpath.compile(xpathExpression);
			data = (Node) expr.evaluate(document, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} 
		return data;
	}
}
