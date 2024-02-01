package org.lsi.config;

import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class Web3jConfig {

	public static Web3j web3j() {
        return Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
    }
}
