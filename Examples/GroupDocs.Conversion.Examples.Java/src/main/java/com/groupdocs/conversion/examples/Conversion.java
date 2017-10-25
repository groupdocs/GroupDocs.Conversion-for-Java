package com.groupdocs.conversion.examples;

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

import com.aspose.ms.System.IO.FileMode;
import com.aspose.ms.System.IO.FileStream;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.CellsSaveOptions;
import com.groupdocs.conversion.converter.option.HtmlSaveOptions;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.converter.option.LoadOptions;
import com.groupdocs.conversion.converter.option.OutputType;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.converter.option.PsdOptions;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.converter.option.SlidesSaveOptions;
import com.groupdocs.conversion.converter.option.WatermarkOptions;
import com.groupdocs.conversion.converter.option.WordsSaveOptions;
import com.groupdocs.conversion.converter.option.XmlLoadOptions;
import com.groupdocs.conversion.handler.ConversionCompleteEventArgs;
import com.groupdocs.conversion.handler.ConversionCompleteHandler;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.groupdocs.conversion.handler.ConversionProgressEventArgs;
import com.groupdocs.conversion.handler.ConversionProgressHandler;
import com.groupdocs.conversion.handler.ConversionStartEventArgs;
import com.groupdocs.conversion.handler.ConversionStartHandler;
import com.groupdocs.conversion.handler.DocumentInfo;
import com.groupdocs.conversion.handler.PdfConversionCompleteEventArgs;
import com.groupdocs.conversion.handler.output.IOutputDataHandler;
import com.groupdocs.conversion.metered.Metered;
//import com.groupdocs.conversion.internal.c.a.d.Metered;
import com.groupdocs.foundation.domain.FileType;
import com.groupdocs.foundation.utils.wrapper.stream.GroupDocsInputStream;

public class Conversion {

	// region Convert to spreadsheet

	/*
	 * Convert document to spreadsheet and get result as file path
	 */
	public static void convertToCellsAsFilePath(String fileName) {
		//ExStart:convertToCellsAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		CellsSaveOptions saveOption = new CellsSaveOptions();
		saveOption.setOutputType(OutputType.String);
		String convertedDocumentPath = conversionHandler.<String> convert(fileName, saveOption);
		System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToCellsAsFilePath
	}

	/*
	 * Convert document to spreadsheet and get result as stream
	 */
	public static void convertToCellsAsStream(String fileName) {
		//ExStart:convertToCellsAsStream
		// instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new CellsSaveOptions());
		//ExEnd:convertToCellsAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToCellsAsPath(String fileName) {
		//ExStart:convertProtectedFilesToCellsAsPath
		// instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// convert file to Xls, starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new CellsSaveOptions();
		saveOptions.setConvertFileType(CellsSaveOptions.CellsFileType.XLS);
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		System.out.println(convertedDocumentPath);
		//ExEnd:convertProtectedFilesToCellsAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream to the converted file
	 */
	public static void convertProtectedFilesToCellsAsStream(String fileName) {
		//ExStart:convertProtectedFilesToCellsAsStream
		// instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// convert file to Xls, starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new CellsSaveOptions();
		saveOptions.setConvertFileType(CellsSaveOptions.CellsFileType.XLS);
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToCellsAsStream
	}
	// endregion Convert to spreadsheet

	// region Convert to word

	/*
	 * convert document to word and get result as path
	 */
	public static void convertToWordAsFilePath(String fileName) {
		//ExStart:convertToWordAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		WordsSaveOptions saveOption = new WordsSaveOptions();
		saveOption.setOutputType(OutputType.String);
		// Set absolute path to file
		String guid = fileName;
		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		//System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToWordAsFilePath
	}

	/*
	 * convert document to word and get result as stream
	 */
	public static void convertToWordAsStream(String fileName) {
		//ExStart:convertToWordAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert("PDFsample.pdf",
				new WordsSaveOptions());
		//ExEnd:convertToWordAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToWordAsPath(String fileName) {
		//ExStart:convertProtectedFilesToWordAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert file to Doc, starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new WordsSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setConvertFileType(WordsSaveOptions.WordsFileType.DOC);
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToWordAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToWordAsStream(String fileName) {
		//ExStart:convertProtectedFilesToWordAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert file to Doc, starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new WordsSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setConvertFileType(WordsSaveOptions.WordsFileType.DOC);
		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToWordAsStream
	}

	// endregion Convert to word

	// region Convert to Html

	/*
	 * Convert document to html and get result as file path
	 */
	public static void convertToHtmlAsFilePath(String fileName) {
		//ExStart:convertToHtmlAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOption = new HtmlSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set absolute path to file
		String guid = fileName;

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		//System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToHtmlAsFilePath
	}

	/*
	 * Convert document to html and get result as stream
	 */
	public static void convertToHtmlAsStream(String fileName) {
		//ExStart:convertToHtmlAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new HtmlSaveOptions());
		//ExEnd:convertToHtmlAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToHtmlAsPath(String fileName) {
		//ExStart:convertProtectedFilesToHtmlAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert starting from page 2 and convert 2 pages
		HtmlSaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToHtmlAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToHtmlAsStream(String fileName) {
		//ExStart:convertProtectedFilesToHtmlAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Сonvert starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToHtmlAsStream
	}

	// endregion Convert to Html

	// region Convert to Image

	/*
	 * Convert document to image and get result as image path
	 */
	public static void convertToImageAsFilePath(String fileName) {
		//ExStart:convertToImageAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions saveOption = new ImageSaveOptions(); 
		saveOption.setConvertFileType(ImageSaveOptions.ImageFileType.JPG); 
		saveOption.setOutputType(OutputType.String); 

		List<String> convertedDocumentPath = conversionHandler.<List<String>> convert(fileName, saveOption);
		//System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToImageAsFilePath
	}

	/*
	 * Convert document to image and get result as stream
	 */
	public static void convertToImageAsStream(String fileName) {
		//ExStart:convertToImageAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler
				.<List<GroupDocsInputStream>> convert(fileName, new ImageSaveOptions());
		//ExEnd:convertToImageAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted image
	 */
	public static void convertProtectedFilesToImageAsPath(String fileName) {
		//ExStart:convertProtectedFilesToImageAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Сonvert file to Tiff, starting from page 2 and convert 2 pages,
		// use DPI 300, image width 1024, image height 768
		ImageSaveOptions saveOptions = new ImageSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768);
		saveOptions.setConvertFileType(FileType.Tiff);
		saveOptions.setOutputType(OutputType.String);

		List<String> convertedDocumentPath = conversionHandler.<List<String>> convert(fileName, loadOptions,
				saveOptions);
		//ExEnd:convertProtectedFilesToImageAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToImageAsStream(String fileName) {
		//ExStart:convertProtectedFilesToImageAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Сonvert file to Tiff, starting from page 2 and convert 2 pages,
		// use DPI 300, image width 1024, image height 768
		ImageSaveOptions saveOptions = new ImageSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768);
		saveOptions.setConvertFileType(FileType.Tiff);

		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler
				.<List<GroupDocsInputStream>> convert(fileName, loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToImageAsStream
	}

	// region Convert to Image

	// region Convert to pdf

	/*
	 * Convert document to pdf and get result as pdf path
	 */
	public static void convertToPdfAsFilePath(String fileName) {
		//ExStart:convertToPdfAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions saveOption = new PdfSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set absolute path to file
		String guid = fileName;

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		//System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToPdfAsFilePath
	}

	/*
	 * Convert document to pdf and get result as stream
	 */
	public static void convertToPdfAsStream(String fileName) {
		//ExStart:convertToPdfAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new PdfSaveOptions());
		//ExEnd:convertToPdfAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToPdfAsPath(String fileName) {
		//ExStart:convertProtectedFilesToPdfAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert starting from page 2 and convert 2 pages,
		// use DPI 300, page width 1024, page height 768
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768);
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToPdfAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToPdfAsStream(String fileName) {
		//ExStart:convertProtectedFilesToPdfAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert starting from page 2 and convert 2 pages,
		// use DPI 300, page width 1024, page height 768
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768);

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToPdfAsStream
	}

	// region Convert to pdf

	// region Convert to slides

	/*
	 * Convert document to slide and get result as file path
	 */
	public static void convertToSlideAsFilePath(String fileName) {
		//ExStart:convertToSlideAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		SlidesSaveOptions saveOption = new SlidesSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set absolute path to file
		String guid = fileName;

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		//ExEnd:convertToSlideAsFilePath
	}

	/*
	 * Convert document to slide and get result as stream
	 */
	public static void convertToSlideAsStream(String fileName) {
		//ExStart:convertToSlideAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new SlidesSaveOptions());
		//ExEnd:convertToSlideAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToSlideAsPath(String fileName) {
		//ExStart:convertProtectedFilesToSlideAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert file to Ppt, starting from page 2 and convert 2 pages,
		SaveOptions saveOptions = new SlidesSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setConvertFileType(SlidesSaveOptions.SlidesFileType.PPT);
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToSlideAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToSlideAsStream(String fileName) {
		//ExStart:convertProtectedFilesToSlideAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert file to Ppt, starting from page 2 and convert 2 pages,
		SaveOptions saveOptions = new SlidesSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setConvertFileType(SlidesSaveOptions.SlidesFileType.PPT);

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToSlideAsStream
	}

	// endregion Convert to slides

	// region custom input data handler

	public static void inputDataHandler(String fileName) {
		//ExStart:inputDataHandler
		// Instantiating the conversion handler
		AmazonInputDataHandler inputDataHandler = new AmazonInputDataHandler("AccessKey", "SecretKey");
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration(), inputDataHandler);

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new PdfSaveOptions());
		//ExEnd:inputDataHandler
	}

	// endregion custom input data handler

	// region custom output data handler
	public static void outputDataHanlder() {
		//ExStart:outputDataHanlder
		// Instantiating the conversion handler
		AmazonOutputDataHandler outputDataHandler = new AmazonOutputDataHandler(Utilities.getConfiguration(),
				"AccessKey", "SecretKey");
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration(),
				(IOutputDataHandler) outputDataHandler);
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert("DOCXsample.docx", saveOptions);
		//ExEnd:outputDataHanlder
	}
	// endregion custom output data handler

	// conversion progress
	public static void conversionProgress(String fileName) {
		//ExStart:conversionProgress
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		conversionHandler.ConversionProgress.add(new ConversionProgressHandler() {
			// Here is the implementation of the conversion progress handler
			// method
			@Override
			public void invoke(ConversionProgressEventArgs args) {
				System.out.println("Conversion progress: {" + args.getProgress() + "}");
			}
		});
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		String resultPath = conversionHandler.<String> convert(fileName, saveOptions);
		System.out.println("The conversion finished. The result can be located here: " + resultPath
				+ ". Press <<ENTER>> to exit.");
		//ExEnd:conversionProgress
	}

	// get available save options by file extension
	public static void getAvailableSaveOptionsByExtension(String sourceDocument) {
		//ExStart:getAvailableSaveOptionsByExtension
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		String file = sourceDocument.substring(sourceDocument.lastIndexOf("."));
		String documentExtension = file.substring(file.indexOf(".") + 1);
		Dictionary<String, SaveOptions> availableConversions = conversionHandler.getSaveOptions(documentExtension);

		// list all available conversions
		for (Enumeration name = availableConversions.keys(); name.hasMoreElements();) {
			System.out.println(name.nextElement());
		}

		// use prepared save option for ToPdf conversion
		GroupDocsInputStream result = conversionHandler.<GroupDocsInputStream> convert(sourceDocument,
				availableConversions.get("pdf"));
		//ExEnd:getAvailableSaveOptionsByExtension
	}

	// get available save options by file stream
	public static void getAvailableSaveOptionsForDocumentStream(String sourceDocument) {
		//ExStart:getAvailableSaveOptionsByStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		FileStream sourceStream = new FileStream(sourceDocument, FileMode.Open);
		Dictionary<String, SaveOptions> availableConversions = conversionHandler
				.getSaveOptions(sourceStream.toInputStream());
		sourceStream.setPosition(0);

		// list all available conversions
		for (Enumeration name = availableConversions.keys(); name.hasMoreElements();) {
			System.out.println(name.nextElement());
		}
		// use prepared save option for ToPdf conversion
		GroupDocsInputStream result = conversionHandler.<GroupDocsInputStream> convert(sourceStream.toInputStream(),
				availableConversions.get("pdf"));
		//ExEnd:getAvailableSaveOptionsByStream
	}

	// Usage of PageMode when converting to PDF
	public static void usePageModeConvertingToPdf(String sourceFileName) {
		//ExStart:usePageModeConvertingToPdf
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setPageMode(true);

		// Note: when using PageMode expected result is either IList<string> or
		// IList<Stream> depending
		// of used OutputType in save options provided
		List<String> resultPaths = conversionHandler.<List<String>> convert(sourceFileName, saveOptions);
		for (String path : resultPaths) {
			System.out.println(path);
		}
		//ExEnd:usePageModeConvertingToPdf
	}

	// Usage of PageMode when converting to HTML
	public static void usePageModeConvertingToHtml(String sourceFileName) {
		//ExStart:usePageModeConvertingToHtml
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setPageMode(true);

		// Note: when using PageMode expected result is either IList<string> or
		// IList<Stream> depending
		// of used OutputType in save options provided
		List<String> resultPaths = conversionHandler.<List<String>> convert(sourceFileName, saveOptions);
		for (String path : resultPaths) {
			System.out.println(path);
		}
		//ExEnd:usePageModeConvertingToHtml
	}

	// adding watermark on converted documents
	public static void addWatermarkOnConvertedDocs(String sourceFileName) {
		//ExStart:addWatermarkOnConvertedDocs
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Save options
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		WatermarkOptions watermarkOptions = new WatermarkOptions("Watermark text");
		watermarkOptions.setColor(Color.blue);
		watermarkOptions.setFont(new Font("Arial", 40, 12));
		watermarkOptions.setRotationAngle(45);
		watermarkOptions.setTransparency(0.1);
		watermarkOptions.setLeft(200);
		watermarkOptions.setTop(400);
		saveOptions.setWatermarkOptions(watermarkOptions);

		String result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		System.out.println(
				"The conversion finished. The result can be located here: " + result + ". Press <<ENTER>> to exit.");
		//ExEnd:addWatermarkOnConvertedDocs
	}

	// Convert document to psd
	public static void convertToPsd(String sourceFileName) {
		//ExStart:convertToPsd
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		ImageSaveOptions saveOptions = new ImageSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setConvertFileType(ImageSaveOptions.ImageFileType.PSD);
		PsdOptions psdOptions = new PsdOptions();
		psdOptions.setColorMode(PsdOptions.ColorModes.GRAYSCALE);
		psdOptions.setCompressionMethod(PsdOptions.CompressionMethods.RAW);
		saveOptions.setPsdOptions(psdOptions);
		List<String> result = conversionHandler.<List<String>> convert(sourceFileName, saveOptions);
		//ExEnd:convertToPsd
	}

	// convert from psd
	public static void convertFromPsd(String sourceFileName) {
		//ExStart:convertFromPsd
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		SaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		String result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		//ExEnd:convertFromPsd
	}

	// use conversion events
	public static void useConversionEvents(String sourceFileName) {
		//ExStart:useConversionEvents
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		conversionHandler.ConversionStart.add(new ConversionStartHandler() {
			@Override
			public void invoke(ConversionStartEventArgs args) {
				System.out.println("Conversion " + args.getConversionGuid() + " started");
			}
		});
		conversionHandler.ConversionProgress.add(new ConversionProgressHandler() {
			@Override
			public void invoke(ConversionProgressEventArgs args) {
				System.out
						.println("Conversion " + args.getConversionGuid() + " progress: " + args.getProgress() + " %");
			}
		});
		conversionHandler.ConversionComplete.add(new ConversionCompleteHandler() {
			@Override
			public void invoke(ConversionCompleteEventArgs args) {
				System.out.println("Conversion " + args.getConversionGuid() + " completed");
				System.out.println(
						"Result document is " + args.getConversionType() + ". Cache is " + args.getUsedCache());
				System.out.println(
						"Result document has " + ((PdfConversionCompleteEventArgs) args).getPageCount() + " page(s).");
			}
		});
		// Save options
		SaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		String result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		//ExEnd:useConversionEvents
	}

	// show grid lines when converting from excel
	public static void showGridLinesConvertingFromExcel(String sourceFileName) {
		//ExStart:showGridLinesConvertingFromExcel
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Save options
		SaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setShowGridLines(true);

		String result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		//ExEnd:showGridLinesConvertingFromExcel
	}

	// show hidden sheets when converting from excel
	public static void showHiddenSheetesWhenConvertingFromExcel(String sourceFileName) {
		//ExStart:showHiddenSheetesWhenConvertingFromExcel
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		SaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setShowHiddenSheets(true);
		String result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		//ExEnd:showHiddenSheetesWhenConvertingFromExcel
	}

	// remove slide comments
	public static void removeSlideComments(String sourceFileName) {
		//ExStart:removeSlideComments
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		SlidesSaveOptions saveOptions = new SlidesSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setRemoveSlidesComments(true);

		String result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		//ExEnd:removeSlideComments
	}

	// hide tracked changes
	public static void hideTrackedChanges(String sourceFileName) {
		//ExStart:hideTrackedChanges
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		SaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setHideWordTrackedChanges(false);

		String result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		//ExEnd:hideTrackedChanges
	}
	
	//count document pages
	public static void countDocumentPages(String sourceFileName){
		//ExStart:countDocumentPages
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		
		int count = conversionHandler.getDocumentPagesCount(sourceFileName);
		System.out.print("Page Count: " + count);
		//ExEnd:countDocumentPages
	}
	
	//get possible conversions from file extension
	public static void getPossibleConversionsFromFileExtension(String fileExtension){
		//ExStart:possibleConversionsFromFileExtension
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
				
		String[] possibleConversions = conversionHandler.getPossibleConversions(fileExtension);
		System.out.print("Possible conversions: " + possibleConversions);
		//ExEnd:possibleConversionsFromFileExtension
	}
	
	//get possible conversions from stream
	public static void getPossibleConversionsFromStream(String sourceFileName) throws FileNotFoundException{
		//ExStart:possibleConversionsFromFileStream
		ConversionConfig conversionConfig = Utilities.getConfiguration();
		ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
		
		FileInputStream fileStream = new FileInputStream(conversionConfig.getStoragePath() + "/" + sourceFileName);
		
		String[] possibleConversions = conversionHandler.getPossibleConversions(fileStream);
		System.out.print("Possible conversions: " + possibleConversions);
		//ExEnd:possibleConversionsFromFileStream
	}
	
	//convert files to WebP and get result as stream
	public static void convertFilesToWebPAsStream(String sourceFileName){
		//ExStart:convertFilesToWebPAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(ImageSaveOptions.ImageFileType.WEBP);
		options.getWebpOptions().setLossless(true);
		
		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		System.out.print("Converted file path is: " + convertedDocumentStream);
		//ExEnd:convertFilesToWebPAsStream
	}
	
	//convert files from WebP and get result as stream
	public static void convertFromWebPAsStream(String sourceFileName){
		//ExStart:convertFromWebPAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(ImageSaveOptions.ImageFileType.JPG);
		options.setOutputType(OutputType.String);
		
		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);		
		System.out.print("Converted file path is: " + convertedDocumentStream);
		//ExEnd:convertFromWebPAsStream
	}
	
	//convert file to greyscale image and get result as stream
	public static void convertFileToGreyscaleImageAsStream(String sourceFileName){
		//ExStart:convertFileToGreyscaleImageAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(ImageSaveOptions.ImageFileType.JPG);
		options.setGrayscale(true);
		
		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		System.out.print("Converted file path is: " + convertedDocumentStream);
		//ExEnd:convertFileToGreyscaleImageAsStream
	}
	
	//convert file to SVG and get result as stream
	public static void convertFileToSVGAsStream(String sourceFileName){
		//ExStart:convertFileToSVGAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(ImageSaveOptions.ImageFileType.SVG);
		 
		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		System.out.print("Converted file path is: " + convertedDocumentStream);
		//ExEnd:convertFileToSVGAsStream
	}
	
	//convert file to XPS and get result as stream
	public static void convertFileToXPSAsStream(String sourceFileName){
		//ExStart:convertFileToXPSAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(PdfSaveOptions.PdfFileType.XPS);
		 
		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert("DOCXsample.docx", options);
		System.out.print("Converted file path is: " + convertedDocumentStream);
		//ExEnd:convertFileToXPSAsStream
	}
	
	//metered licensing
	public static void meteredLicensingOnFile(String sourceFileName) throws Exception{
		//ExStart:meteredLicensingOnFile
		Metered metered = new Metered();		 
		// Set public and private key to metered instance
		metered.setMeteredKey("***","***");
		
		// Get metered value before usage of the conversion
		double amountBefore = Metered.getConsumptionQuantity();
		System.out.print("Amount consumed before: " + amountBefore);
		
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions options = new PdfSaveOptions();
		options.setConvertFileType(PdfSaveOptions.PdfFileType.PDF);
		 
		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(sourceFileName, options);
		 
		// Get metered value after usage of the conversion
		double amountAfter = Metered.getConsumptionQuantity();
		System.out.print("Amount consumed after: " + amountAfter);
		//ExEnd:meteredLicensingOnFile
	}
	
	//hide comments when converting from word
	public static void hideCommentsWhenConvertingFromWord(String sourceFileName){
		//ExStart:hideCommentsWhenConvertingFromWord
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		
		SaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setHideWordComments(false);
		 
		String result = conversionHandler.<String>convert(sourceFileName, saveOptions);		 
		System.out.print("Converted file path is: " + result);
		//ExEnd:hideCommentsWhenConvertingFromWord
	}
	
	// mark image Dpi as Obsolete
	public static void markImageDpiAsObsolete(String sourceFileName){
		//ExStart:markImageDpiAsObsolete
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(ImageSaveOptions.ImageFileType.TIFF);
		// Dpi is obsolete, now horizontal and vertical resolutions can be set independently
		options.setHorizontalResolution(96);
		options.setVerticalResolution(96);
		 
		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		System.out.print("Converted file path is: " + convertedDocumentStream);
		//ExEnd:markImageDpiAsObsolete
	}
	//Get source document metadata
	public static void sourceDocMetadata(String sourceFileName){
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		DocumentInfo documentInfo = conversionHandler.getDocumentInfo(sourceFileName); 
		 
		System.out.print("Size: %s}" + documentInfo.getSize());
		System.out.print("File type: %s" + documentInfo.getFileType());
		System.out.print("Pages count: %s" + documentInfo.getPageCount());
		System.out.print("Last modified: %s" + documentInfo.getModifiedDate());
	}
	
	//convert xml-fo/xsl to pdf
	public static void xmlToPdfConversion(String sourceFileName, String foFileName) throws Throwable{
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		FileInputStream foStream = new FileInputStream(Utilities.storagePath + "/" + foFileName); 
		 
		PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
		pdfSaveOptions.setOutputType(OutputType.String); 
		 
		XmlLoadOptions xmlLoadOptions = new XmlLoadOptions();
		xmlLoadOptions.setXslFo(foStream); 
		 
		String result = conversionHandler.<String>convert(sourceFileName, xmlLoadOptions, pdfSaveOptions);
		System.out.print(result);
	}
	
	//Zoom when converting slides to HTML
	public static void zoomWhileConvertingToHtml(String sourceFileName){
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		saveOptions.setZoom(150); 
		 
		String resultPath = conversionHandler.<String>convert(sourceFileName, saveOptions); 
		 
		System.out.print(resultPath);
	}
	
	//get available layouts in a CAD document 
	public static void availableLayoutsInCad(String sourceFileName){
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		DocumentInfo result = conversionHandler.getDocumentInfo(sourceFileName); 
		 
		for (String layer : result.getLayers()) {
		System.out.println(layer);
		}
	}
	
	//convert specific layout from a CAD document 
	public static void convertSpecificLayoutFromCad(String sourceFileName){
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		String[] layoutNames = new String[1];
		layoutNames[0] = "layout-1"; 
		PdfSaveOptions options = new PdfSaveOptions();
		options.setOutputType(OutputType.String);
		options.getCadOptions().setLayoutNames(layoutNames); 
		 
		String result = conversionHandler.<String>convert(sourceFileName, options); 
		 
		System.out.print(result);
	}
	
	//set specific width and height for each layout from CAD document 
	public static void setWidthHeightForCad(String sourceFileName){
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions options = new PdfSaveOptions();
		options.setOutputType(OutputType.String);
		options.getCadOptions().setWidth(800);
		options.getCadOptions().setHeight(600); 
		 
		String result = conversionHandler.<String>convert(sourceFileName, options); 
		 
		System.out.print(result);
	}
	
	//Hide annotations when converting from PDF
	public static void hideAnnotations(String sourceFileName){
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		WordsSaveOptions options = new WordsSaveOptions();
		options.setOutputType(OutputType.String);
		options.setHidePdfAnnotations(true); 
		 
		String result = conversionHandler.<String>convert(sourceFileName, options); 
		 
		System.out.print(result);
	}
}
