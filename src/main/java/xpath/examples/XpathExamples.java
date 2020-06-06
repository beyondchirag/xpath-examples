package xpath.examples;

import java.util.stream.IntStream;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static xpath.examples.Utils.Utils.*;
import static xpath.examples.XpathHelper.*;

public class XpathExamples {
	
	public static void getNodeTextContent(Node n) {
		System.out.println(n.getTextContent());
	}
	
	public static void main(String[] args) {

		Document document = getTestXMLDoc();
		String xpathExpression = "";
		NodeList nodes = null;
		Node node = null;
		
//		Print all book titles
		xpathExpression = "//movie/title";
		nodes = evaluateXPathNodeList(document, xpathExpression);    
		IntStream.range(0, nodes.getLength()).mapToObj(nodes::item).forEach(XpathExamples::getNodeTextContent);;	
		outputSeparator();
		
//		Attribute based filtering  year attribute
		xpathExpression = "//movie[@year>2001]/title";
		nodes = evaluateXPathNodeList(document, xpathExpression);    
		IntStream.range(0, nodes.getLength()).mapToObj(nodes::item).forEach(XpathExamples::getNodeTextContent);;	
		outputSeparator();
		
//		Node based filtering
		xpathExpression = "//movie[price<100]/title";
		nodes = evaluateXPathNodeList(document, xpathExpression);    
		IntStream.range(0, nodes.getLength()).mapToObj(nodes::item).forEach(XpathExamples::getNodeTextContent);;	
		outputSeparator();
		
		
//		Get 1st node - index start with 1
		xpathExpression = "//movie[1]/title";
		node = evaluateXPathNode(document, xpathExpression);  
		getNodeTextContent(node);
		outputSeparator();
	}
}
