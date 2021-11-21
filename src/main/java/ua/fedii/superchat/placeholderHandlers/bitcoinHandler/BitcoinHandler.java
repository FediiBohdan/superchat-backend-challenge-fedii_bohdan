package ua.fedii.superchat.placeholderHandlers.bitcoinHandler;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitcoinHandler {
    private final static Pattern bitcoinPattern = Pattern.compile("(?i)@bitcoin|@btc");

    public String checkBitcoinPlaceholder(String messageContent) throws IOException {
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
