/*
 * $Id: Skew.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.objects.chunk;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Making chunks skew.
 * 
 * @author blowagie
 */

public class SkewTest {

	/**
	 * SetSkew.
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();
		// step 2:
		// we create a writer that listens to the document
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("Skew.pdf"));

		// step 3: we open the document
		document.open();
		// step 4:
		Paragraph p = new Paragraph("Skew test:");
		document.add(p);
		Chunk chunk = new Chunk("TESTING skew");
		chunk.setSkew(45f, 0f);
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		chunk.setSkew(0f, 45f);
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		chunk.setSkew(-45f, 0f);
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		chunk.setSkew(0f, -45f);
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		chunk.setSkew(15f, 30f);
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		Chunk italic = new Chunk("This looks like Font.ITALIC");
		italic.setSkew(0f, 12f);
		document.add(italic);

		// step 5: we close the document
		document.close();
	}
}