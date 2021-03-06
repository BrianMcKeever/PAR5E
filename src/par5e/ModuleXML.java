/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package par5e;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
/**
 *
 * @author zeph
 */
public class ModuleXML {
    Document doc;
    Element root;
       
    public ModuleXML() {
        Comment comment = new Comment("Generated by PAR5E - Fantasy Grounds Module Parser - Zeus Copyright 2014");
        
        root = new Element("root");
        root.setAttribute("version", "3.0");
        doc = new Document(root);
        doc.addContent(0,comment);
        
        //doc.setRootElement(root);
    }
    
    public Document getDocument() {
        return doc;
    }
    
    public Element getRoot() {
        return root;
    }
    
    public void writeDef(String aModuleName, String aAuthor, String aRuleset) {
        Element name = new Element("name").setText(aModuleName);
        Element author = new Element("author").setText(aAuthor);
        Element ruleset = new Element("ruleset").setText(aRuleset);
        
        root.addContent(name);
        root.addContent(author);
        root.addContent(ruleset);
        
    }
    
    public void outputXML(String xmlFilePath) {
        XMLOutputter xmlOutput = new XMLOutputter();        
        Format fgFormat = Format.getPrettyFormat();
        fgFormat.setEncoding("ISO-8859-1");
        
       /* EscapeStrategy strat = new EscapeStrategy() {
            @Override
            public boolean shouldEscape(char ch) {
                boolean escape = false;
                switch(ch) {
                    
                }
                return escape;
            }
        };
        
        fgFormat.setEscapeStrategy(strat);
        */xmlOutput.setFormat(fgFormat);
        
               
        try {
            xmlOutput.output(doc, new FileWriter(xmlFilePath));
            // xmlOutput.output(doc, System.out);
        } catch (IOException ex) {
            Logger.getLogger(ModuleXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
