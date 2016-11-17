package academy.softserve.java;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NodesKeeper {
    private Document docXml;

    public NodesKeeper(Document docXml) {
        super();
        this.docXml = docXml;
    }

    public NodeList getNodeByXpath(String xpathQuery)
            throws SAXException, IOException, XPathExpressionException, ParserConfigurationException {

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(xpathQuery);
        NodeList nodeList = (NodeList) expr.evaluate(docXml, XPathConstants.NODESET);
        return nodeList;

    }

    public void itemText(NodeList nodeList) throws TransformerFactoryConfigurationError, TransformerException{
       
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node elem = nodeList.item(i); 
            StringWriter buf = new StringWriter();
            Transformer xform = TransformerFactory.newInstance().newTransformer();
            xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            xform.setOutputProperty(OutputKeys.INDENT, "yes");
            xform.transform(new DOMSource(elem), new StreamResult(buf));
            System.out.println(buf.toString()); 
            System.out.println();
            }
    }
    
    public Document getDocXml() {
        return docXml;
    }

    public void setDocXml(Document docXml) {
        this.docXml = docXml;
    }

}
