public class Reader {

    public static List<String> readFile(String path) {

        List<String> lines = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(path))) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

        return lines;
    }
}