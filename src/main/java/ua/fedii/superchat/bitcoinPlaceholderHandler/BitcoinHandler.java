package ua.fedii.superchat.bitcoinPlaceholderHandler;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitcoinHandler {
    public String checkBitcoinPlaceholder(String messageContent) throws IOException {
        final Pattern bitcoinPattern = Pattern.compile("(?i)@bitcoin|@btc");

        Matcher matcher = bitcoinPattern.matcher(messageContent);

        if (matcher.find()) {
            return messageContent.replaceAll(bitcoinPattern.pattern(),
                    "BTC price is: " + new BitcoinParser().parseBitcoinPrice().getResult().getPrice() + "\\$");
        }
        else {
            return messageContent;
        }
    }
}
