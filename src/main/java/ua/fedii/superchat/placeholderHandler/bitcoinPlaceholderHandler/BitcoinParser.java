package ua.fedii.superchat.placeholderHandler.bitcoinPlaceholderHandler;

import com.google.gson.Gson;
import ua.fedii.superchat.placeholderHandler.bitcoinPlaceholderHandler.model.Root;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class BitcoinParser {
    public Root parseBitcoinPrice() throws IOException {
        URL url = new URL("https://api.cryptowat.ch/markets/kraken/btcusd/price");
        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());

        return new Gson().fromJson(inputStreamReader, Root.class);
    }
}
