package ec.gob.cj.pesnot.notaria.controlador;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import ec.gob.cj.pesnot.notaria.modelo.TablaAdministracionNotaria;
import ec.gob.cj.pesnot.notaria.repositorio.TablaAdministracionNotariaRepository;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reportesNotaria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReporteController {
    final
    TablaAdministracionNotariaRepository repository;

    public ReporteController(TablaAdministracionNotariaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{fileName}/{fileType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void download(
            @PathVariable String fileName,
            @PathVariable String fileType,
            HttpServletResponse response
    ) throws FileNotFoundException {
        exportAllFileData(
                fileName,
                fileType,
                this.repository.findAll(),
                response);
    }

    private void exportAllFileData(String filename, String filetype, List<TablaAdministracionNotaria> list, HttpServletResponse response)
            throws FileNotFoundException {
        String sourceJrxmlFile = ResourceUtils.getFile(
                ResourceUtils.CLASSPATH_URL_PREFIX + "Notaria.jrxml"
        ).getAbsolutePath();
        JasperPrint jasperPrint;
        ServletOutputStream outputStream;
        try {
            List<TablaAdministracionNotaria> dataList = new ArrayList<>(list);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
            JasperReport jasperReport = JasperCompileManager.compileReport(sourceJrxmlFile);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("dataSource", dataSource);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            if (filetype.equalsIgnoreCase("PDF")) {
                response.addHeader("Content-Disposition", "inline; filename=" + filename + ".pdf;");
                response.setContentType("application/octet-stream");
                outputStream = response.getOutputStream();
                JRPdfExporter exporter = new JRPdfExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
                exporter.exportReport();
            }
            if (filetype.equalsIgnoreCase("EXCEL")) {
                response.addHeader("Content-Disposition", "inline; filename=" + filename + ".xlsx;");
                response.setContentType("application/octet-stream");
                outputStream = response.getOutputStream();
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
                exporter.exportReport();
            }
            if (filetype.equalsIgnoreCase("CSV")) {
                response.addHeader("Content-Disposition", "inline; filename=" + filename + ".csv;");
                response.setContentType("application/octet-stream");
                outputStream = response.getOutputStream();
                JRCsvExporter exporter = new JRCsvExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
                exporter.exportReport();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    List<TablaAdministracionNotaria> todos(){
    	return repository.findAll();
    }
}