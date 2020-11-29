class Solution:
    # Time Complexity: O(C), where C is the total content of emails.
    # Space Complexity: O(C).
    def numUniqueEmails(self, emails: List[str]) -> int:
        email_set = set()
        for email in emails:
            local, domain = email.split("@")
            local = local.replace(".", "")
            if "+" in local:
                local = local.split("+")[0]
            email_set.add(local + "@" + domain)
        return len(email_set)