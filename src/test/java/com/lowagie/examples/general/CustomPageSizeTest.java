/*
 * $Id: CustomPageSize.java 3373 2008-05-12 16:21:24Z xlv $
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */

package com.lowagie.examples.general;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Demonstrates the use of PageSize.
 * 
 * @author blowagie
 */
public class CustomPageSizeTest {
	/**
	 * Creates a PDF document with a certain pagesize
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Rectangle pageSize = new Rectangle(216, 720);
		pageSize.setBackgroundColor(new java.awt.Color(0xFF, 0xFF, 0xDE));
		Document document = new Document(pageSize);

		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file

		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("CustomPageSize.pdf"));

		// step 3: we open the document
		document.open();

		// step 4: we add some paragraphs to the document
		document.add(new Paragraph("The size of this page is 216x720 points."));
		document.add(new Paragraph("216pt / 72 points per inch = 3 inch"));
		document.add(new Paragraph("720pt / 72 points per inch = 10 inch"));
		document.add(new Paragraph("The size of this page is 3x10 inch."));
		document.add(new Paragraph("3 inch x 2.54 = 7.62 cm"));
		document.add(new Paragraph("10 inch x 2.54 = 25.4 cm"));
		document.add(new Paragraph("The size of this page is 7.62x25.4 cm."));
		document.add(new Paragraph("The backgroundcolor of the Rectangle used for this PageSize, is #FFFFDE."));
		document.add(new Paragraph("That's why the background of this document is yellowish..."));

		// step 5: we close the document
		document.close();
	}
}
