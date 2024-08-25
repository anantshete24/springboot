package com.example.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

	private Logger logger =LoggerFactory.getLogger(PdfService.class);
	
	public ByteArrayInputStream createPdf()
	{
			logger.info("creating pdf started");
			String title="Welcome to learn code with Anant";
			String content="Software developer with having 5 years of exprience";
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			Document document = new Document();
					
			PdfWriter.getInstance(document, out);
			HeaderFooter footer = new HeaderFooter(true, new Phrase("LCWD"));
			footer.setAlignment(Element.ALIGN_CENTER);
			footer.setBorderWidth(0);
			document.setFooter(footer);
			
			document.open();
		
			Font titleFont= FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
			Paragraph titlePara= new Paragraph(title,titleFont);
			titlePara.setAlignment(Element.ALIGN_CENTER);
			
			document.add(titlePara);
			
			Font paraFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
			Paragraph paragrph = new Paragraph(content);	
			paragrph.add(new Chunk("Wow this text is added after creating paragraph"));
			document.add(paragrph);
			document.close();
			
			return new ByteArrayInputStream(out.toByteArray());
	}
}
