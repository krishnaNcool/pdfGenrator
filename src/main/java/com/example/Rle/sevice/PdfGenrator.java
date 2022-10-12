package com.example.Rle.sevice;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DottedBorder;
import com.itextpdf.layout.border.DoubleBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
@Service
public class PdfGenrator {
    public void pdf(String pdfName) throws Exception {
        // Creating a PdfWriter
        String dest = "D:/"+pdfName+".pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument object
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Creating a Document object
        // Creating a Document
        Document document = new Document(pdfDoc);

        String imFile = "src/main/resources/static/RLE-Logo.png";
        String authorised="src/main/resources/static/authorised.png";

        ImageData rleLogoImg = ImageDataFactory.create(imFile);
        ImageData authorisedImg= ImageDataFactory.create(authorised);



        String customerNameDetail="SKODA AUTO Volkswagen India Private\n" + "Limited\n";
        String customerGSTIN="27AACCV4229P1ZT";
        String customerBillingAddress="SKODA AUTO Volkswagen India Private\n" +
                "Limited\n" +
                "\"E-1, MIDC Industrial Area (Phase\n" +
                "III),Chakan, Village Nigoje Mhalunge\n" +
                "Kharabwadi, Tal : Khed,Chakan, Pune - 410\n" +
                "501\n" +
                "Maharashtra, India\"\n" +
                "Maharashtra\n" +
                "India\n";
        String customerShippingAddress="SKODA AUTO Volkswagen India Private\n" +
                "Limited\n" +
                "\"E-1, MIDC Industrial Area (Phase\n" +
                "III),Chakan, Village Nigoje Mhalunge\n" +
                "Kharabwadi, Tal : Khed,Chakan, Pune - 410\n" +
                "501\n" +
                "Maharashtra, India\"\n" +
                "Maharashtra\n" +
                "India\n" +
                "27AACCV4229P1ZT";


        // Creating a table
        float[] pointColumnWidths = {200F, 200F,200F};
        Table table = new Table(pointColumnWidths);

        // Populating row 1 and adding it to the table
        Cell c1 = new Cell();
        c1.setBorder(Border.NO_BORDER);
        table.addCell(c1);                           // Adding cell 1 to the table

        Cell c2 = new Cell();
        c2.add("TAX INVOICE");
        c2.setBorder(Border.NO_BORDER);
        c2.setFontColor(Color.RED);
        c2.setTextAlignment(TextAlignment.CENTER);
        table.addCell(c2);

        // Populating row 2 and adding it to the table
        Cell c3 = new Cell();
        c3.add("ORIGINAL RECIPIENT");
        c3.setBorder(new DottedBorder(Color.DARK_GRAY, 3));
        c3.setTextAlignment(TextAlignment.CENTER);
        table.addCell(c3);


        // Adding Table to document
        document.add(table);


        float[] pointColumnWidthSForHeading = {200F, 400F,500F, 300F, 350F};
        Table tableHeading = new Table(pointColumnWidthSForHeading);

        Cell rleLogo = new Cell();
        Image image = new Image(rleLogoImg);
        // Setting the position of the image to the center of the page
        image.setMarginTop(20);
        image.setWidth(60);
        image.setHeight(60);
        rleLogo.add(image);
        rleLogo.setBorder(Border.NO_BORDER);
        tableHeading.addCell(rleLogo);

        Cell rleAddress = new Cell();
        rleAddress.setWidth(150);
        rleAddress.setMarginTop(10);

        Paragraph paragraph1 = new Paragraph("RLE INDIA PRIVATE LIMITED");
        paragraph1.setFontSize(10);
        paragraph1.setFontColor(Color.RED);
        Paragraph paragraph4 = new Paragraph("RLE India pvt limited");
        paragraph4.setFontSize(8);
        Paragraph paragraph2 = new Paragraph("8th Floor ,Innovator");
        paragraph2.setFontSize(8);
        Paragraph paragraph6 = new Paragraph("ITPL ,Whitefield, Bangalore");
        paragraph6.setFontSize(8);
        Paragraph paragraph7 = new Paragraph("Karnataka 560066");
        paragraph7.setFontSize(8);
        Paragraph paragraph3 = new Paragraph("08777634415");
        paragraph3.setFontSize(8);
        Paragraph paragraph5 = new Paragraph("smita.dhar@rle.co.in");
        paragraph5.setFontSize(8);


        rleAddress.add(paragraph1);
        rleAddress.add(paragraph4);
        rleAddress.add(paragraph2);
        rleAddress.add(paragraph6);
        rleAddress.add(paragraph7);
        rleAddress.add(paragraph3);
        rleAddress.add(paragraph5);
        rleAddress.setBorder(Border.NO_BORDER);
        tableHeading.addCell(rleAddress);

        Cell rleSpace = new Cell();
        rleSpace.setWidth(300);
        rleSpace.setBorder(Border.NO_BORDER);
        tableHeading.addCell(rleSpace);

        // Creating nested table for contact
        float [] pointColumnWidths2 = {50f, 150f};
        Table nestedTable = new Table(pointColumnWidths2);

        Cell nested1 = new Cell();
        nested1.setBorder(Border.NO_BORDER);
        nested1.add("GSTIN");
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        nested1.setFont(font);
        nestedTable.addCell(nested1);

        Cell nested2 = new Cell();
        nested2.setBorder(Border.NO_BORDER);
        nested2.add("29AADCR1029A1ZV");
        nestedTable.addCell(nested2);

        Cell nested3 = new Cell();
        nested3.setBorder(Border.NO_BORDER);
        nested3.add("State");
        nested3.setFont(font);
        nestedTable.addCell(nested3);

        Cell nested4 = new Cell();
        nested4.setBorder(Border.NO_BORDER);
        nested4.add("29-Karnataka");
        nestedTable.addCell(nested4);

        Cell nested5 = new Cell();
        nested5.setBorder(Border.NO_BORDER);
        nested5.add("PAN");
        nested5.setFont(font);
        nestedTable.addCell(nested5);

        Cell nested6 = new Cell();
        nested6.setBorder(Border.NO_BORDER);
        nested6.add("AADCR1029A");
        nestedTable.addCell(nested6);

        Cell nested7 = new Cell();
        nested7.setBorder(Border.NO_BORDER);
        nested7.add("CIN");
        nested7.setFont(font);
        nestedTable.addCell(nested7);

        Cell nested8 = new Cell();
        nested8.setBorder(Border.NO_BORDER);
        nested8.add("U34300KA2005PTC127670");
        nestedTable.addCell(nested8);


        Cell rleInfo4 = new Cell();
        rleInfo4.add(nestedTable);
        rleInfo4.setFontSize(7);
        rleInfo4.setMarginTop(50);
        rleInfo4.setWidth(50);
        rleInfo4.setBorder(Border.NO_BORDER);
        rleInfo4.setTextAlignment(TextAlignment.LEFT);
        tableHeading.addCell(rleInfo4);


        float [] pointColumnWidths3 = {80f, 100f};
        Table nestedTables = new Table(pointColumnWidths3);

        Cell nested11 = new Cell();
        nested11.setBorder(Border.NO_BORDER);
        nested11.add("Invoice Date");
        nested11.setFont(font);
        nestedTables.addCell(nested11);

        Cell nested22 = new Cell();
        nested22.setBorder(Border.NO_BORDER);
        nested22.add("01/10/2022");
        nestedTables.addCell(nested22);

        Cell nested33 = new Cell();
        nested33.setBorder(Border.NO_BORDER);
        nested33.add("Invoice No");
        nested33.setFont(font);
        nestedTables.addCell(nested33);

        Cell nested44 = new Cell();
        nested44.setBorder(Border.NO_BORDER);
        nested44.add("KA12563834");
        nestedTables.addCell(nested44);

        Cell nested55 = new Cell();
        nested55.setBorder(Border.NO_BORDER);
        nested55.setFont(font);
        nested55.add("Reference No");
        nested55.setFontSize(7);
        nestedTables.addCell(nested55);

        Cell nested66 = new Cell();
        nested66.setBorder(Border.NO_BORDER);
        nested66.add("3254654745");
        nestedTables.addCell(nested66);

        Cell rleInfo5 = new Cell();
        rleInfo5.setWidth(100);
        rleInfo5.add(nestedTables);
        rleInfo5.setFontSize(7);
        rleInfo5.setMarginTop(50);
        rleInfo5.setBorder(Border.NO_BORDER);
        tableHeading.addCell(rleInfo5);

        document.add(tableHeading);
        // Creating an Image object
// Creating a new page\
        // Creating a new page
        PdfPage pdfPage = pdfDoc.getPage(1);
        // Creating a PdfCanvas object
        PdfCanvas canvas = new PdfCanvas(pdfPage);

        // Initial point of the line
        canvas.moveTo(30, 650);

        // Drawing the line
        canvas.lineTo(550, 650);

        canvas.setStrokeColor(Color.RED);

        // Closing the path stroke
        canvas.closePathStroke();


        float[] pointColumnWidthsCustomerDetails = {200F, 200F,200F};
        Table CustomerDetails = new Table(pointColumnWidths);

        // Populating row 1 and adding it to the table
        Cell customerCol1 = new Cell();
        customerCol1.add("CustomerName");
        customerCol1.add(customerNameDetail);
        customerCol1.setBorder(Border.NO_BORDER);
        customerCol1.add("Customer GSTIN");
        customerCol1.add(customerGSTIN);
        customerCol1.setFontSize(8);
        CustomerDetails.addCell(customerCol1);

        Cell customerCol2 = new Cell();
        customerCol2.add("Billing Address");
        customerCol2.add(customerBillingAddress);
        customerCol2.setFontSize(8);
        customerCol2.setBorder(Border.NO_BORDER);
        CustomerDetails.addCell(customerCol2);

        // Populating row 2 and adding it to the table
        Cell customerCol3 = new Cell();
        customerCol3.add("Shipping Address");
        customerCol3.add(customerShippingAddress);
        customerCol3.setFontSize(8);
        customerCol3.setBorder(Border.NO_BORDER);
        CustomerDetails.addCell(customerCol3);
        CustomerDetails.setMarginTop(20);
            document.add(CustomerDetails);

        PdfPage pdfPageline2 = pdfDoc.getPage(1);
        // Creating a PdfCanvas object
        PdfCanvas canvasline2 = new PdfCanvas(pdfPageline2);

        // Initial point of the line
        canvasline2.moveTo(30, 500);

        // Drawing the line
        canvasline2.lineTo(550, 500);

        canvasline2.setStrokeColor(Color.RED);

        // Closing the path stroke
        canvasline2.closePathStroke();


        float[] pointColumnWidthsSupply1 = {200F, 200F,200F};
        Table Supply1 = new Table(pointColumnWidthsSupply1);
        Supply1.setMarginTop(7);
        // Populating row 1 and adding it to the table
        Cell supplycol1 = new Cell();
        supplycol1.add("Place Of Supply 27-Maharashtra");
        supplycol1.setBorder(Border.NO_BORDER);
        supplycol1.setFontSize(8);
        Supply1.addCell(supplycol1);

        Cell supplycol2 = new Cell();
        supplycol2.add("Due Date 08/10/2022");
        supplycol2.setFontSize(8);
        supplycol2.setBorder(Border.NO_BORDER);
        Supply1.addCell(supplycol2);

        Cell supplycol3 = new Cell();
        supplycol3.setBorder(Border.NO_BORDER);
        Supply1.addCell(supplycol3);

        document.add(Supply1);
        // Populating row 2 and adding it to the table


        PdfPage pdfPageline3 = pdfDoc.getPage(1);
        // Creating a PdfCanvas object
        PdfCanvas canvasline3 = new PdfCanvas(pdfPageline3);

        // Initial point of the line
        canvasline3.moveTo(30, 480);

        // Drawing the line
        canvasline3.lineTo(550, 480);

        canvasline3.setStrokeColor(Color.RED);

        // Closing the path stroke
        canvasline3.closePathStroke();


        float[] pointColumnWidthsSupply2 = {200F, 200F,200F};
        Table Supply2 = new Table(pointColumnWidthsSupply2);
        Supply2.setMarginTop(7);

        // Populating row 1 and adding it to the table
        Cell supplyCol1 = new Cell();
        supplyCol1.add("Reference Date 15.02.2022");
        supplyCol1.setBorder(Border.NO_BORDER);
        supplyCol1.setFontSize(8);
        Supply2.addCell(supplyCol1);

        Cell supplyCol2 = new Cell();
        supplyCol2.add("Supplier Code 101056");
        supplyCol2.setFontSize(8);
        supplyCol2.setBorder(Border.NO_BORDER);
        Supply2.addCell(supplyCol2);

        Cell supplyCol3 = new Cell();
        supplyCol3.add("LUT");
        supplyCol3.setFontSize(8);
        supplyCol3.setBorder(Border.NO_BORDER);
        Supply2.addCell(supplyCol3);
        document.add(Supply2);
        // Populating row 2 and adding it to the table


        PdfPage pdfPageline4 = pdfDoc.getPage(1);
        // Creating a PdfCanvas object
        PdfCanvas canvasline4 = new PdfCanvas(pdfPageline4);

        // Initial point of the line
        canvasline4.moveTo(30, 460);

        // Drawing the line
        canvasline4.lineTo(550, 460);

        canvasline4.setStrokeColor(Color.RED);

        // Closing the path stroke
        canvasline4.closePathStroke();



        float [] pointColumnWidthsOfItems = {20F, 200F, 40F, 40F, 40F, 40F, 40F, 40F, 40F, 40F };
        Table tableItem = new Table(pointColumnWidthsOfItems);

        // Populating row 1 and adding it to the table
        Cell itemNo = new Cell();                        // Creating cell 1
        itemNo.add("");                              // Adding name to cell 1
        itemNo.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemNo.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemNo);

        Cell itemName = new Cell();                        // Creating cell 1
        itemName.add("Items");                              // Adding name to cell 1
        itemName.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemName.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemName);

        Cell itemHSN = new Cell();                        // Creating cell 1
        itemHSN.add("HSN /\n" + "SAC");                              // Adding name to cell 1
        itemHSN.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemHSN.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemHSN);

        Cell itemQuantity = new Cell();                        // Creating cell 1
        itemQuantity.add("Quantity");                              // Adding name to cell 1
        itemQuantity.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemQuantity.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemQuantity);

        Cell itemRate = new Cell();                        // Creating cell 1
        itemRate.add("Rate / Item\n" + "(₹)\n");                              // Adding name to cell 1
        itemRate.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemRate.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemRate);

        Cell itemDiscount = new Cell();                        // Creating cell 1
        itemDiscount.add("Discount\n" + "(₹)");                              // Adding name to cell 1
        itemDiscount.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemDiscount.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemDiscount);

        Cell itemTax = new Cell();                        // Creating cell 1
        itemTax.add("Taxable Value\n" + "(₹)\n");                              // Adding name to cell 1
        itemTax.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemTax.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemTax);

        Cell itemGST = new Cell();                        // Creating cell 1
        itemGST.add("IGST (₹) ");                              // Adding name to cell 1
        itemGST.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemGST.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemGST);

        Cell itemCess = new Cell();                        // Creating cell 1
        itemCess.add("CESS\n" + "(₹)");                              // Adding name to cell 1
        itemCess.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemCess.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemCess);

        Cell itemTotal = new Cell();                        // Creating cell 1
        itemTotal.add("Total (₹)");                              // Adding name to cell 1
        itemTotal.setBackgroundColor(Color.YELLOW);      // Setting background color
        itemTotal.setBorder(Border.NO_BORDER);              // Setting border
        tableItem.addCell(itemTotal);
        tableItem.setMarginTop(6);
        tableItem.setFontSize(7);
        tableItem.setBorder(new SolidBorder(Color.LIGHT_GRAY, 1));


        String [][] items={{"1." ,"Engineering Support services Onsite Engineering service provided for the month of Aug -2022 for Avinash Londhe",
        "998349" ,"171.00" ,"575.00" ,"0.00" ,"98,325.00", "17,698.50 @18%", "0.00", "1,16,023.50"},{"1." ,"Engineering Support services Onsite Engineering service provided for the month of Aug -2022 for Avinash Londhe",
                "998349" ,"171.00" ,"575.00" ,"0.00" ,"98,325.00", "17,698.50 \n @18%", "0.00", "1,16,023.50"}};

        for(int i=0;i<2;i++){
            for(int j=0;j<10;j++){
                tableItem.addCell(new Cell().add(items[i][j]));
            }
        }

        String []total={"","","","","Total","", "98,325.00", "17,698.50", "0.00", "1,16,023.50"};
        for(int j=0;j<10;j++){
            tableItem.addCell(new Cell().add(total[j]).setBackgroundColor(Color.YELLOW).setBorder(Border.NO_BORDER));
        }
        document.add(tableItem);


        float [] pointColumnWidthsOfItemTotal = {400F, 60F, 60F };
        Table tableItemTotal = new Table(pointColumnWidthsOfItemTotal);

        String [][] totaldata={{"","Taxable Amount", "₹ 98,325.00"},{
                "","Total Tax", "₹ 17,698.50"},
                {"","Rounding off", "₹ 0.50"}};

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tableItemTotal.addCell(new Cell().setBorder(Border.NO_BORDER).setFontSize(7).add(totaldata[i][j]));
            }
        }

        String [] totalAmount ={"","Total Value", "₹ 1,16,024.00"};

        for(int j=0;j<3;j++){
            tableItemTotal.addCell(new Cell().setBorder(Border.NO_BORDER).setFontSize(9).add(totalAmount[j]));
        }
        tableItemTotal.setTextAlignment(TextAlignment.RIGHT);
        tableItemTotal.setBorder(Border.NO_BORDER);

        document.add(tableItemTotal);


        float [] pointColumnWidthsOfBank = {70F, 70F, 70F, 70F };
        Table tableBank = new Table(pointColumnWidthsOfBank);

        String [][]bankDetails={{"Account Number" ,"10026388136" ,"IFSC", "IDFB0080155"},
                {"Bank Name:", "IDFC Bank Limited- Current A/C", "Branch Name:" ,"Indiranagar Branch"}};

        Cell bank = new Cell();
        bank.setBorder(Border.NO_BORDER).add("Bank Details:").setFont(font).setFontSize(8);
        tableBank.addCell(bank);

        tableBank.addCell(new Cell().setBorder(Border.NO_BORDER));
        tableBank.addCell(new Cell().setBorder(Border.NO_BORDER));
        tableBank.addCell(new Cell().setBorder(Border.NO_BORDER));

        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                tableBank.addCell(new Cell().setBorder(Border.NO_BORDER).setMarginTop(10).setMarginLeft(10).setFontSize(7).add(bankDetails[i][j]));
            }
        }

        float [] pointColumnWidthsOfAuthorized = { 60F };
        Table authorized = new Table(pointColumnWidthsOfAuthorized);

        Cell authorizedData = new Cell();
        Image authorisedImgLogo = new Image(authorisedImg);
        // Setting the position of the image to the center of the page
        authorisedImgLogo.setMarginTop(8);
        authorisedImgLogo.setWidth(80);
        authorisedImgLogo.setHeight(40);
        authorisedImgLogo.setBorder(Border.NO_BORDER);
        authorizedData.add(authorisedImgLogo);
        authorizedData.setBorder(Border.NO_BORDER);
        authorized.addCell(authorizedData);

        float [] pointColumnWidthsOfBankAndAuthorized = {340F,90F, 90F };
        Table bankAndAuthorized = new Table(pointColumnWidthsOfBankAndAuthorized);

        bankAndAuthorized.addCell(tableBank).setMarginTop(10);
        bankAndAuthorized.addCell(new Cell().setBorder(Border.NO_BORDER));
        bankAndAuthorized.addCell(authorized);


        document.add(bankAndAuthorized);

        // Creating a Paragraph
//        Paragraph paragraph = new Paragraph("Tutorials Point provides the following tutorials");
//
//        // Creating a list
//        List list = new List();
//
//        // Add elements to the list
//        list.add("Java");
//        list.add("JavaFX");
//        list.add("Apache Tika");
//        list.add("OpenCV");
//        list.add("WebGL");
//        list.add("Coffee Script");
//        list.add("Java RMI");
//        list.add("Apache Pig");
//
//        // Adding paragraph to the document
//        document.add(paragraph);
//
//        // Adding list to the document
//        document.add(list);

        // Closing the document
        document.close();
        System.out.println("List added");
    }
}
