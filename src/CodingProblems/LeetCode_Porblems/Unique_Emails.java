package CodingProblems.LeetCode_Porblems;

import java.util.HashSet;
import java.util.Set;

public class Unique_Emails {

    public static void main(String[] args) {
        String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        int result = numUniqueEmails(emails);

        System.out.println(result);
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<emails.length;i++) {
            String email = emails[i];

            String[] emailArr = email.split("@");
            String formattedEmail = emailArr[0].split("[+]")[0].replaceAll("[.]","") + "@" + emailArr[1];

            set.add(formattedEmail);



        }
        return set.size();
    }
}
