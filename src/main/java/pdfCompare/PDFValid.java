package pdfCompare;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PDFValid {
	public static ExtentReports reports = new ExtentReports(
			System.getProperty("user.dir") + "/reports/PDFExtentReport.html", true);
	public static ExtentTest exTest;

	@Test(dataProvider = "fileProvider")
	private void comparePDFTextImage(String file1, String file2) throws IOException {
		exTest = reports.startTest("Compare PDF Text & Image:Comparing " + file1 + " & " + file2);
		try {
			File f1 = new File(file1);
			File f2 = new File(file2);
			Assert.assertTrue(validatePDF(f1, f2));
			renderImages(f1);
			renderImages(f2);
			Assert.assertTrue(
					compareImage(f1.getName().split("\\.")[0] + ".jpg", f2.getName().split("\\.")[0] + ".jpg"));
		} catch (Exception e) {
			exTest.log(LogStatus.FAIL, e.getMessage());
		} finally {
			reports.endTest(exTest);
		}
	}

	@AfterClass
	private void flushExtent() {
		reports.flush();
		reports.close();
	}

	@DataProvider(name = "fileProvider")
	public Object[][] getDataFromDataprovider() throws IOException {
		String[][] tabArray = null;
		try {
			FileInputStream ExcelFile = new FileInputStream("C:\\Users\\User\\Downloads\\PDF_Compare\\BookTwo.xlsx");
			XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols = 2;
			tabArray = new String[totalRows][totalCols];
			ci = 0;
			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j <totalCols; j++, cj++) {
					tabArray[ci][cj] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(tabArray[ci][cj]);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}

	private void renderImages(File file) throws IOException {
		PDDocument document = PDDocument.load(file);

		// Instantiating the PDFRenderer class
		PDFRenderer renderer = new PDFRenderer(document);

		// Rendering an image from the PDF document
		BufferedImage image = renderer.renderImage(0);

		// Writing the image to a file
		ImageIO.write(image, "JPEG", new File(file.getName().split("\\.")[0] + ".jpg"));

		exTest.log(LogStatus.PASS, "Image created:" + file.getName().split("\\.")[0] + ".jpg");

		// Closing the document
		document.close();
	}

	private static boolean validatePDF(File pdfFile1, File pdfFile2) throws IOException {
		boolean bFlag = true;
		exTest.log(LogStatus.INFO, "Comparing PDF files (" + pdfFile1 + "," + pdfFile2 + ")");
		PDDocument pdf1 = PDDocument.load(pdfFile1);
		PDDocument pdf2 = PDDocument.load(pdfFile2);
		PDPageTree pdf1pages = pdf1.getDocumentCatalog().getPages();
		PDPageTree pdf2pages = pdf2.getDocumentCatalog().getPages();
		try {
			if (pdf1pages.getCount() != pdf2pages.getCount()) {
				String message = "Number of pages in the files (" + pdfFile1 + "," + pdfFile2
						+ ") do not match. pdfFile1 has " + pdf1pages.getCount() + " no pages, while pdf2pages has "
						+ pdf2pages.getCount() + " no of pages";
				exTest.log(LogStatus.FAIL, message);
				bFlag = false;
			}
			PDFTextStripper pdfStripper = new PDFTextStripper();
			exTest.log(LogStatus.INFO, "pdfStripper is :- " + pdfStripper);
			exTest.log(LogStatus.INFO, "pdf1pages.size() is :- " + pdf1pages.getCount());
			for (int i = 0; i < pdf1pages.getCount(); i++) {
				pdfStripper.setStartPage(i + 1);
				pdfStripper.setEndPage(i + 1);
				String pdf1PageText = pdfStripper.getText(pdf1);
				String pdf2PageText = pdfStripper.getText(pdf2);
				if (!pdf1PageText.equals(pdf2PageText)) {
					String difference = StringUtils.difference(pdf1PageText, pdf2PageText);
					exTest.log(LogStatus.FAIL, "difference is " + difference);
					bFlag = false;
				}
			}
			if (bFlag)
				exTest.log(LogStatus.PASS,
						"Returning " + bFlag + " , as PDF Files (" + pdfFile1 + "," + pdfFile2 + ") get matched");
			else
				exTest.log(LogStatus.FAIL,
						"Returning " + bFlag + " , as PDF Files (" + pdfFile1 + "," + pdfFile2 + ") not matched");
		} finally {
			pdf1.close();
			pdf2.close();
		}
		return bFlag;
	}

	boolean compareImage(String file1, String file2) {
		boolean bPixelCompare = false;
		Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
		Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

		try {

			PixelGrabber grabImage1Pixels = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grabImage2Pixels = new PixelGrabber(image2, 0, 0, -1, -1, false);

			int[] image1Data = null;

			if (grabImage1Pixels.grabPixels()) {
				int width = grabImage1Pixels.getWidth();
				int height = grabImage1Pixels.getHeight();
				image1Data = new int[width * height];
				image1Data = (int[]) grabImage1Pixels.getPixels();
			}

			int[] image2Data = null;

			if (grabImage2Pixels.grabPixels()) {
				int width = grabImage2Pixels.getWidth();
				int height = grabImage2Pixels.getHeight();
				image2Data = new int[width * height];
				image2Data = (int[]) grabImage2Pixels.getPixels();
			}

			bPixelCompare = java.util.Arrays.equals(image1Data, image2Data);
			if (bPixelCompare)
				exTest.log(LogStatus.PASS, "Images are equal");
			else
				exTest.log(LogStatus.FAIL, "Images are not equal");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return bPixelCompare;
	}

}
