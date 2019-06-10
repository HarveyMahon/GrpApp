package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;

import java.io.FileOutputStream;
import java.io.IOException;

public class Certificate {

    public static void main(String[] args) throws Exception {
        // write your code here
        Document certificate = createCertificate("Easy", "Harvey", 71, 92);
        Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler Certificate.pdf");
        p.waitFor();
    }

    public static Document createCertificate(String difficulty, String userName, Integer wpm, Integer accuracy) throws Exception {
        Document certificate = new Document();
        PdfWriter writer = PdfWriter.getInstance(certificate, new FileOutputStream("Certificate.pdf"));

        certificate.open();
        //creating fonts for the pdf file
        BaseFont font = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        BaseFont fontI = BaseFont.createFont(BaseFont.TIMES_ITALIC, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        //setting the pdf decorations to make it look better
        Image tlCorner = Image.getInstance("src\\cornerDeco.png");
        tlCorner.setAbsolutePosition(0, 717);
        certificate.add(tlCorner);

        Image trCorner = Image.getInstance("src\\cornerDeco.png");
        trCorner.setAbsolutePosition(470, 717);
        trCorner.setRotationDegrees(270);
        certificate.add(trCorner);

        Image brCorner = Image.getInstance("src\\cornerDeco.png");
        brCorner.setAbsolutePosition(0,0 );
        brCorner.setRotationDegrees(90);
        certificate.add(brCorner);

        Image blCorner = Image.getInstance("src\\cornerDeco.png");
        blCorner.setAbsolutePosition(470, 0);
        blCorner.setRotationDegrees(180);
        certificate.add(blCorner);

        Image logo = Image.getInstance("src\\logo.jpg");
        logo.setAbsolutePosition(235, 100);
        certificate.add(logo);
        //creating the text to be shown on the pdf file
        try {
            //this var sets the relative y pos of all of the labels on the screen
            int relativeYPos = 665;
            //title line 1
            PdfContentByte title1 = writer.getDirectContent();
            title1.saveState();
            title1.beginText();
            title1.moveText(165,relativeYPos+10);
            title1.setFontAndSize(font, 30);
            title1.showText("The Associated Board");
            title1.endText();
            title1.restoreState();
            //title line 2
            PdfContentByte title2 = writer.getDirectContent();
            title2.saveState();
            title2.beginText();
            title2.moveText(110,relativeYPos-20);
            title2.setFontAndSize(font, 30);
            title2.showText("of the Royal Schools of Typing");
            title2.endText();
            title2.restoreState();
            //name line 1
            PdfContentByte name1 = writer.getDirectContent();
            name1.saveState();
            name1.beginText();
            name1.moveText(215,relativeYPos-140);
            name1.setFontAndSize(fontI  , 20);
            name1.showText("This is to certify that");
            name1.endText();
            name1.restoreState();
            //name line 2
            PdfContentByte name2 = writer.getDirectContent();
            name2.saveState();
            name2.beginText();
            name2.moveText(300-(((float)userName.length()/2f)*10),relativeYPos-170);
            name2.setFontAndSize(font, 20);
            name2.showText(userName);
            name2.endText();
            name2.restoreState();
            //pedigree line 1
            PdfContentByte pedi1 = writer.getDirectContent();
            pedi1.saveState();
            pedi1.beginText();
            pedi1.moveText(230,relativeYPos-200);
            pedi1.setFontAndSize(fontI, 20);
            pedi1.showText("was examined in");
            pedi1.endText();
            pedi1.restoreState();
            //pedigree line 2
            PdfContentByte pedi2 = writer.getDirectContent();
            String text = difficulty + " level typing";
            pedi2.saveState();
            pedi2.beginText();
            pedi2.moveText(314-(((float)text.length()/2f)*10),relativeYPos-230);
            pedi2.setFontAndSize(font, 20);
            pedi2.showText(text);
            pedi2.endText();
            pedi2.restoreState();
            //pedigree line 3
            PdfContentByte pedi3 = writer.getDirectContent();
            pedi3.saveState();
            pedi3.beginText();
            pedi3.moveText(130,relativeYPos-260);
            pedi3.setFontAndSize(fontI, 20);
            pedi3.showText("and passed with a typing speed of " + wpm.toString() + "wpm");
            pedi3.endText();
            pedi3.restoreState();
            //issued by line 1
            PdfContentByte iss1 = writer.getDirectContent();
            iss1.saveState();
            iss1.beginText();
            iss1.moveText(180,relativeYPos-340);
            iss1.setFontAndSize(fontI, 20);
            iss1.showText("Presented for examination by");
            iss1.endText();
            iss1.restoreState();
            //issued by line 2
            PdfContentByte iss2 = writer.getDirectContent();
            iss2.saveState();
            iss2.beginText();
            iss2.moveText(155,relativeYPos-370);
            iss2.setFontAndSize(fontI, 20);
            iss2.showText("The THEMA advanced typing tutor");
            iss2.endText();
            iss2.restoreState();
        } catch (Exception e) {
            System.out.println(e);
        }

        certificate.close();
        return certificate;
    }

}
