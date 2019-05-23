package org.smart.plugin.mail;

import java.util.List;
import org.junit.Test;
import org.plugin.mail.fetch.MailFetcher;
import org.plugin.mail.fetch.MailInfo;
import org.plugin.mail.fetch.impl.DefaultMailFetcher;

public class FetchMailTest {

    private static final String username = "18428327427@163.com";
    private static final String password = "qq136078";
    private static final MailFetcher mailFetcher = new DefaultMailFetcher(username, password);

    @Test
    public void fetchTest() {
        List<MailInfo> mailInfoList = mailFetcher.fetch(5);
        for (MailInfo mailInfo : mailInfoList) {
            System.out.println(mailInfo.getSubject());
        }
    }

    @Test
    public void fetchLatestTest() {
        MailInfo mailInfo = mailFetcher.fetchLatest();
        System.out.println(mailInfo.getSubject());
    }
}
