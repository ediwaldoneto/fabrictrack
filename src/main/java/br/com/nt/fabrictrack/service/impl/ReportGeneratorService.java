/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Neto
 *
 */
public interface ReportGeneratorService {

    public void bestSellingItemsBySeller(HttpServletResponse response) throws IOException;
}
