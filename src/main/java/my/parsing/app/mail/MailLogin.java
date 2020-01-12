package my.parsing.app.mail;

public class MailLogin {

    private static my.parsing.app.mail.MailOut Sender = new my.parsing.app.mail.MailOut("webparsing90@gmail.com", "Webparsing1990");

    public static void senderOut(String email) {
        Sender.send("Парсинг окончен!", "Данное уведомление подтверждает окончание парсинга!", "webparsing90@gmail.com", email);
    }

}
