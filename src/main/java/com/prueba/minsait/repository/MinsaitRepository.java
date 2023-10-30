package com.prueba.minsait.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Repository;

import com.prueba.minsait.exception.RepositoryException;
import com.prueba.minsait.model.entity.Minsait;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MinsaitRepository implements IMinsaitRepository {
	
	private static final String STARTDATE = "startdate";
	
	private static final String ENDDATE = "enddate";
	
	private static String dropTable = "DROP TABLE IF EXISTS prices;";
	
	private static String queryCreateTable = "CREATE TABLE prices" + " (" + 
            "idbrand VARCHAR(10)," +
            "idproduct VARCHAR(10)," +
            "pricelist  VARCHAR(10)," +
            "startdate VARCHAR(30)," +
            "enddate VARCHAR(30)," +
            "priority VARCHAR(10)," +
            "price VARCHAR(30)," +
            "curr VARCHAR(10)" +
            ");";
	
	private static String insert1Table = "INSERT INTO prices (idbrand, idproduct, pricelist, startdate, enddate, priority, price, curr) VALUES ('1', '35455', '1', '2020-06-14-00.00.00', '2020-12-31-23.59.59', '0', '35.50', 'EUR');";
	private static String insert2Table ="INSERT INTO prices (idbrand, idproduct, pricelist, startdate, enddate, priority, price, curr) VALUES ('1', '35455', '2', '2020-06-14-15.00.00', '2020-06-14-18.30.00', '1', '25.45', 'EUR');";
	private static String insert3Table ="INSERT INTO prices (idbrand, idproduct, pricelist, startdate, enddate, priority, price, curr) VALUES ('1', '35455', '3', '2020-06-15-00.00.00', '2020-06-15-11.00.00', '1', '30.50', 'EUR');";
	private static String insert4Table ="INSERT INTO prices (idbrand, idproduct, pricelist, startdate, enddate, priority, price, curr) VALUES ('1', '35455', '4', '2020-06-15-16.00.00', '2020-12-31-23.59.59', '1', '38.95', 'EUR');";

	public Minsait findById(String idCadena, String idProduct, String fechaApp) throws RepositoryException {
		Minsait minsait = null;
		String startdate = null;
		String[] partIni = null;
		String[] partFin = null;
		String[] partApp = null;
		String[] horaIni = null;
		String[] horaFin = null;
		String[] horaApp = null;
		String fechaapp = null;
		String fechaIni = null;
		String fechaFin = null;
		DateTime inicio = new DateTime();
		DateTime fin = new DateTime();
		DateTime app = new DateTime();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-mm-dd HH:mm:ss");
		 log.debug("Inicio de llamada al repositorio");
		 try {
			 if(null != fechaApp) {
				 partApp = fechaApp.split("-");
				 horaApp = partApp[3].split("\\.");
				 fechaapp = partApp[0] + "-" + partApp[1] + "-" + partApp[2] + " " + horaApp[0] + ":" + horaApp[1] + ":" + horaApp[2];
				 app = DateTime.parse(fechaapp, formatter);
				 Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "password");
				 connection.prepareStatement(dropTable).execute();
				 connection.prepareStatement(queryCreateTable).execute();
				 connection.prepareStatement(insert1Table).execute();
				 connection.prepareStatement(insert2Table).execute();
				 connection.prepareStatement(insert3Table).execute();
				 connection.prepareStatement(insert4Table).execute();
				 PreparedStatement statement = connection.prepareStatement("SELECT * FROM prices WHERE idbrand=? AND idproduct=? order by priority desc");
				 statement.setString(1, idCadena);
				 statement.setString(2, idProduct);
				 ResultSet result = statement.executeQuery();
				 if(result != null) {
					 log.debug("Devuelve resultados");
					 while (result.next()) {
						 if(null != result.getString(STARTDATE) && null != result.getString(ENDDATE)) {
							startdate = result.getString(STARTDATE);
							if(null != startdate) {
								partIni = startdate.split("-");
								horaIni = partIni[3].split("\\.");
								fechaIni = partIni[0] + "-" + partIni[1] + "-" + partIni[2] + " " + horaIni[0] + ":" + horaIni[1] + ":" + horaIni[2];
								inicio = DateTime.parse(fechaIni, formatter);
								fechaFin = result.getString(ENDDATE);
								if(null != fechaFin) {
									partFin = fechaFin.split("-");
									horaFin = partFin[3].split("\\.");
									fechaFin = partFin[0] + "-" + partFin[1] + "-" + partFin[2] + " " + horaFin[0] + ":" + horaFin[1] + ":" + horaFin[2];
									fin = DateTime.parse(fechaFin, formatter);
									DateTimeComparator dateTimeComparator = DateTimeComparator.getInstance();
									if(dateTimeComparator.compare(app, inicio) >= 0 && dateTimeComparator.compare(app, fin) <= 0) {
										minsait = new Minsait();
										minsait.setIdProduct(result.getString("idproduct"));
										minsait.setCurr(result.getString("curr"));
										minsait.setEndDate(result.getString(ENDDATE));
										minsait.setIdBrand(result.getString("idbrand"));
										minsait.setPrice(result.getString("price"));
										minsait.setPriceList(result.getString("pricelist"));
										minsait.setPriority(result.getString("priority"));
										minsait.setStartDate(result.getString(STARTDATE));
										break;
									} 
								}
							}
						 }
					}
				 }
			 }
		 } catch (Exception e) {
			throw new RepositoryException("Exception en price: " + e.getMessage());
		 }

		return minsait;
	}
}
