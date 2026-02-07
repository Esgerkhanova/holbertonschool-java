public class PrintJobFactory {

    public static PrintJob createPrintJob(
            PrintSize size,
            int totalPages,
            int colorPages,
            boolean isDoubleSided
    ) {

        double colorDouble;
        double bwDouble;
        double colorSingle;
        double bwSingle;

        switch (size) {
            case A2:
                colorSingle = 0.32;
                bwSingle = 0.22;
                colorDouble = 0.28;
                bwDouble = 0.18;
                break;

            case A3:
                colorSingle = 0.30;
                bwSingle = 0.20;
                colorDouble = 0.25;
                bwDouble = 0.15;
                break;

            default: // A4
                colorSingle = 0.25;
                bwSingle = 0.15;
                colorDouble = 0.20;
                bwDouble = 0.10;
        }

        return new PrintJob(
                totalPages,
                colorPages,
                isDoubleSided,
                colorDouble,
                bwDouble,
                colorSingle,
                bwSingle
        );
    }
}
