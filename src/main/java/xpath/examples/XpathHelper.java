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

	public NodeList evaluateXPathNodeList(Document document, String xpathExpression) throws Exception {
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList nodes = null;
		try {
			XPathExpression expr = xpath.compile(xpathExpression);
			nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new Exception("Error while evaluating xpath "+xpathExpression+" error "+ e.getMessage());
		}
		return nodes;
	}

	public String evaluateXPath(Document document, String xpathExpression) throws Exception {
		XPath xpath = XPathFactory.newInstance().newXPath();
		String data = null;
		try {
			XPathExpression expr = xpath.compile(xpathExpression);
			data = ((Node) expr.evaluate(document, XPathConstants.NODE)).getTextContent();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			data = " ";
		}
		return data;
	}
}
