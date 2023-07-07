/**
 * 
 */
package br.com.nt.fabrictrack.controller.v1;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.fabrictrack.service.impl.ReportGeneratorServiceImpl;

/**
 * @author Neto
 *
 */
@RestController
@RequestMapping("api/v1/seller")
public class ReportGeneratorController {

    @Autowired
    private ReportGeneratorServiceImpl service;

    @GetMapping("/bestsellingitemsbyseller")
    public void generateReport(HttpServletResponse response) throws IOException {
	service.bestSellingItemsBySeller(response);
    }
}
