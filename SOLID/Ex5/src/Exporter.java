public abstract class Exporter {

    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("ExportRequest cannot be null");
        }

        ExportResult result = doExport(req);

        if (result == null) {
            throw new IllegalStateException("ExportResult cannot be null");
        }

        return result;
    }

    protected abstract ExportResult doExport(ExportRequest req);
}