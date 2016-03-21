/*
 * $Id: FormTextField.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.forms;

import java.awt.Color;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfAnnotation;
import com.lowagie.text.pdf.PdfAppearance;
import com.lowagie.text.pdf.PdfBorderDictionary;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Generates an Acroform with a TextField
 * 
 * @author blowagie
 */
public class FormTextField {
	/**
	 * Generates an Acroform with a TextField
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document(PageSize.A4);

		// step 2:
		PdfWriter writer = PdfWriter.getInstance(document, PdfTestBase.getOutputStream("textfield.pdf"));

		// step 3: we open the document
		document.open();

		// step 4:
		BaseFont helv = BaseFont.createFont("Helvetica", "winansi", false);
		PdfContentByte cb = writer.getDirectContent();
		cb.moveTo(0, 0);
		String text = "Some start text";
		float fontSize = 12;
		Color textColor = new GrayColor(0f);
		PdfFormField field = PdfFormField.createTextField(writer, false, false, 0);
		field.setWidget(new Rectangle(171, 750, 342, 769), PdfAnnotation.HIGHLIGHT_INVERT);
		field.setFlags(PdfAnnotation.FLAGS_PRINT);
		field.setFieldName("ATextField");
		field.setValueAsString(text);
		field.setDefaultValueAsString(text);
		field.setBorderStyle(new PdfBorderDictionary(2, PdfBorderDictionary.STYLE_SOLID));
		field.setPage();
		PdfAppearance tp = cb.createAppearance(171, 19);
		PdfAppearance da = (PdfAppearance) tp.getDuplicate();
		da.setFontAndSize(helv, fontSize);
		da.setColorFill(textColor);
		field.setDefaultAppearanceString(da);
		tp.beginVariableText();
		tp.saveState();
		tp.rectangle(2, 2, 167, 15);
		tp.clip();
		tp.newPath();
		tp.beginText();
		tp.setFontAndSize(helv, fontSize);
		tp.setColorFill(textColor);
		tp.setTextMatrix(4, 5);
		tp.showText(text);
		tp.endText();
		tp.restoreState();
		tp.endVariableText();
		field.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, tp);
		writer.addAnnotation(field);

		// step 5: we close the document
		document.close();
	}
}