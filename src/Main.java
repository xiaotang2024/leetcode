public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String res1 = main.getModelName("table_info");
        String res2 = main.getModelName("table");
        String res3 = main.getModelName("tableInfo");
        String res4 = main.getModelName("Tableinll");
    }

    public  String getModelName (String snakeCase) {
        StringBuilder camelCase = new StringBuilder();
        String[] parts = snakeCase.split("_");

        for (String part : parts) {
            if (part.length() > 0) {
                // 首字母大写，其他字母小写
                camelCase.append(part.substring(0, 1).toUpperCase());
                camelCase.append(part.substring(1).toLowerCase());
            }
        }

        return camelCase.toString();
    }
}