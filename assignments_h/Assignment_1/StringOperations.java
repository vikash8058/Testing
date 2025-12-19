public class StringOperations {

    public static void main(String[] args) {

        String text = "  Java Programming  ";

        System.out.println(text.length());
        System.out.println(text.isEmpty());
        System.out.println(text.charAt(2));
        System.out.println(text.toString());
        System.out.println(text.equals("Java"));
        System.out.println(text.compareTo("Java"));
        System.out.println(text.contains("Java"));
        System.out.println(text.indexOf("a"));
        System.out.println(text.lastIndexOf("a"));
        System.out.println(text.startsWith("  J"));
        System.out.println(text.endsWith("  "));
        System.out.println(text.matches(".*Java.*"));
        System.out.println(text.substring(2, 6));
        System.out.println(text.toLowerCase());
        System.out.println(text.trim());
        System.out.println(text.replace("Java", "Core Java"));
        System.out.println(String.join("-", "Java", "Is", "Powerful"));
        System.out.println(String.valueOf(100));
    }
}
