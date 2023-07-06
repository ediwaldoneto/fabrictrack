/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import java.util.List;

import br.com.nt.fabrictrack.model.BestSellingItemsBySeller;

/**
 * @author Neto
 *
 */
public interface ReportGeneratorRepository {

    public List<BestSellingItemsBySeller> bestSellingItemsBySeller();
}
