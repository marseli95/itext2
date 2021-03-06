/*
 * $Id: SplitRows.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.tables;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Add a table to a PDF with document.add() and if the cell doesn't fit, the row
 * is split in two parts.
 */
public class SplitRowsTest {

	/**
	 * Demonstrates how rows are split when the cell is too big.
	 * 
	 */
	@Test
	public void main() throws Exception {
		// step1
		Document document1 = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
		Document document2 = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
		Document document3 = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
		// step2
		PdfWriter.getInstance(document1, PdfTestBase.getOutputStream("SplitRowsBetween.pdf"));
		PdfWriter.getInstance(document2, PdfTestBase.getOutputStream("SplitRowsWithin.pdf"));
		PdfWriter.getInstance(document3, PdfTestBase.getOutputStream("OmitRows.pdf"));
		// step3
		document1.open();
		document2.open();
		document3.open();
		// step4
		String text = "Quick brown fox jumps over the lazy dog. ";
		for (int i = 0; i < 5; i++) {
			text += text;
		}
		PdfPTable table = new PdfPTable(2);
		PdfPCell largeCell;
		Phrase phrase;
		for (int i = 0; i < 10; i++) {
			phrase = new Phrase(text);
			for (int j = 0; j < i; j++) {
				phrase.add(new Phrase(text));
			}
			if (i == 7) {
				phrase = new Phrase(text);
			}
			table.addCell(String.valueOf(i));
			largeCell = new PdfPCell(phrase);
			table.addCell(largeCell);
		}
		document1.add(table);
		table.setSplitLate(false);
		document2.add(table);
		table.setSplitRows(false);
		document3.add(table);

		// step5
		document1.close();
		document2.close();
		document3.close();
	}
}