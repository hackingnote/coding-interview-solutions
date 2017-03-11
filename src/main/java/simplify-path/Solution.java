public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        LinkedList<String> list = new LinkedList<>();

        for (int i = 1; i < parts.length; i++) {
            if (parts[i].equals(".") || parts[i].length() == 0) continue;
            if (parts[i].equals("..")) {
                if (list.size() > 0) {
                    list.removeLast();
                }
            } else {
                list.addLast(parts[i]);
            }
        }

        String result = "";

        for (String s : list) {
            result += "/" + s;
        }

        if (result.length() == 0) {
            result = "/";
        }

        return result;
    }
}