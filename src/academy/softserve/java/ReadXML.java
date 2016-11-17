package academy.softserve.java;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class ReadXML {

    public static enum Xpaths {
        ALL_AUTHORS_nNR("./author"), ALL_AUTHORS("author"), FIRST_NAME("first.name"), BOOK_STORE(
                "/bookstore"), ALL_AUTHORS_IN_DOC("//author"), ALL_FIRST_NAMES("author/first-name");

        private String field;

        private Xpaths(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }

    }

    public static void main(String[] args)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException,
            jdk.internal.org.xml.sax.SAXException, TransformerFactoryConfigurationError, TransformerException {
        String filepath = "inventory.xml";
        ParserXML parser_one = new ParserXML();
        NodesKeeper xml_one = new NodesKeeper(parser_one.parseXmlXpath(filepath));
        for (Xpaths value : Xpaths.values()) {
            System.out.println("--------" + value + "---------");
            System.out.println();
            String path = value.toString();
            xml_one.itemText(xml_one.getNodeByXpath(path));

            // System.out.println(value + " " +
            // xml_one.getNodeByXpath(path).toString());
        }
    }

}
