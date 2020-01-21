package za.co.discovery.assignment.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import za.co.discovery.assignment.bo.Planet;
import za.co.discovery.assignment.bo.Route;
import za.co.discovery.assignment.dao.PlanetDAO;
import za.co.discovery.assignment.dao.RouteDAO;

public class DataLoader {
	private static RouteDAO rDao;
	private static PlanetDAO pDao;

	public static void loadData() {
		loadPlanets();
		loadRoutes();
	}

	private static void loadPlanets() {
		try {
			pDao = new PlanetDAO();

			ClassLoader classLoader = DataLoader.class.getClassLoader();
			File file = new File(classLoader.getResource("interstellar.xlsx").getFile());
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Load the planets from the first sheet
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()) {
				itr.next();
				Row row = itr.next();

				Planet p = new Planet();
				p.setpNode(row.getCell(0).getStringCellValue());
				p.setpName(row.getCell(1).getStringCellValue());
				System.out.println(p.getpName() + "\t" + p.getpNode());
				pDao.addPlanet(p);
				System.out.println(p.getpName() + "\t" + p.getpNode());
				p = null;
			}
			wb.close();
			fis.close();
			System.gc();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void loadRoutes() {
		try {
			pDao = new PlanetDAO();
			ClassLoader classLoader = DataLoader.class.getClassLoader();
			File file = new File(classLoader.getResource("interstellar.xlsx").getFile());
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Load the routes from the second sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()) {
				itr.next();
				Row row = itr.next();
				Route r = new Route();
				r.setDestination(row.getCell(1).getStringCellValue());
				r.setOrigin(row.getCell(2).getStringCellValue());
				r.setDistance(row.getCell(3).getNumericCellValue());
				r.setTraffic(wb.getSheetAt(2).getRow(row.getRowNum()).getCell(3).getNumericCellValue());
				System.out.println(r.getDistance() + "\t" + r.getTraffic());
				rDao.addRoute(r);
				System.out.println(r.getDestination() + "\t" + r.getOrigin());
				r = null;

			}
			wb.close();
			fis.close();
			System.gc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
