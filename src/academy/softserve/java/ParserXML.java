package academy.softserve.java;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ParserXML {
    String fileName;

    public Document parseXmlXpath(String fileName)
            throws SAXException, IOException, XPathExpressionException, ParserConfigurationException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(fileName));
        return doc;
    }
}
