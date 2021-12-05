class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder res  = new StringBuilder();
        StringBuilder toClean  = new StringBuilder(identifier);
        char c = ' ';
        for(int i = 0; i < toClean.toString().length(); i++) {
            c = toClean.toString().charAt(i);
            // Task 1
            if (c == ' ') {
                res.append('_');
            // Task 2
            } else if (Character.isISOControl(c)) {
                res.append("CTRL");
            // Task 3
            } else if (c == '-') {
                res.append(Character.toUpperCase(toClean.toString().charAt(i + 1)));
                toClean.replace(i, i + 1, "");
            // Task 4
            } else if (Character.isLowerCase(c) && String.valueOf(c).matches("\\p{InGreek}")) {
                toClean.replace(i, i, "");
            } else if (Character.isLetter(c)) {
                res.append(c);
            }
        }
        
        return res.toString();
    }
}