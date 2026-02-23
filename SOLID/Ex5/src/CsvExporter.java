import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    @Override
    protected ExportResult doExport(ExportRequest req) {
        String body = req.body == null ? "" : req.body;

        String safeTitle = quote(req.title);
        String safeBody = quote(body);

        String csv = "title,body\n" + safeTitle + "," + safeBody + "\n";

        return new ExportResult("text/csv",
                csv.getBytes(StandardCharsets.UTF_8));
    }

    private String quote(String s) {
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }
}