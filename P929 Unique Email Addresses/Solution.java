class Solution {
    // Time Complexity: O(C), where C is the total content of emails.
    // Space Complexity: O(C).
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet();
        for(int i = 0;i < emails.length; i++) {
            String[] emailParts = emails[i].split("@");
            String local = emailParts[0].replace(".", "");
            if(local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            emailSet.add(local + "@" + emailParts[1]);
        }
        return emailSet.size();
    }
}