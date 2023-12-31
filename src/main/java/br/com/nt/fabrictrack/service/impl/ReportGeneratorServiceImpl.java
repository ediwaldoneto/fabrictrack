/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.BestSellingItemsBySeller;
import br.com.nt.fabrictrack.repository.impl.ReportGeneratorRepositoryImpl;

/**
 * @author Neto
 *
 */
@Service
public class ReportGeneratorServiceImpl implements ReportGeneratorService {

	@Autowired
	private ReportGeneratorRepositoryImpl repository;

	private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

	@Override
	public void bestSellingItemsBySeller(HttpServletResponse response) throws IOException {
		log.info("starting report");
		List<BestSellingItemsBySeller> list = repository.bestSellingItemsBySeller();

		if (list.isEmpty()) {
			response.setContentType("text/plain");
			response.getWriter().write(" -> no data available. ");
			return;
		}
		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("Itens Mais Vendidos por Vendedor");

		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Vendedor");
		headerRow.createCell(1).setCellValue("Produto");
		headerRow.createCell(2).setCellValue("Quantidade Vendida");

		int rowNum = 1;
		for (BestSellingItemsBySeller bySeller : list) {
			Row dataRow = sheet.createRow(rowNum++);
			dataRow.createCell(0).setCellValue(bySeller.getSeller());
			dataRow.createCell(1).setCellValue(bySeller.getProduct());
			dataRow.createCell(2).setCellValue(bySeller.getSoldAmount());
		}

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Itens Mais Vendidos por Vendedor.xlsx");

		try {
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			log.info("an error occurred while generating report -> {}", e.getMessage());
		} finally {
			workbook.close();
		}
	}

}
