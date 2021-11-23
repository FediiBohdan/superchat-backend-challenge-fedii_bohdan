package ua.fedii.superchat.placeholderHandler.contactPlaceholderHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactHandler {
    public String replacePlaceholder(String messageContent) {
        final Pattern contactPattern = Pattern.compile("(?!(?i)@btc)(?!(?i)@bitcoin)([@][A-za-z0-9]+)");

        Matcher matcher = contactPattern.matcher(messageContent);

        if (matcher.find()) {
            return messageContent.replaceAll(contactPattern.pattern(), "");
        } else {
            return messageContent;
        }
    }
}
