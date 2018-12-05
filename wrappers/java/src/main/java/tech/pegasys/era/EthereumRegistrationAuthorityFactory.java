package tech.pegasys.era;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.ReadonlyTransactionManager;
import tech.pegasys.era.internal.AutoGeneratedDomainInfo;
import tech.pegasys.era.internal.AutoGeneratedEra;
import tech.pegasys.era.internal.AutoGeneratedFinder;
import java.math.BigInteger;

public class EthereumRegistrationAuthorityFactory {

    private Web3j web3j;
    private Credentials credentials;

    public EthereumRegistrationAuthorityFactory(Web3j web3j, Credentials credentials) {
        this.web3j = web3j;
        this.credentials = credentials;
    }

    public EthereumRegistrationAuthorityFactory(Web3j web3j) {
        this.web3j = web3j;
    }


    public EthereumRegistrationAuthority deployEra() {
        if (credentials == null) return null;

        BigInteger gasPrice = null; //TODO
        BigInteger gasLimit = null; // TODO

        EthereumRegistrationAuthority era = new EthereumRegistrationAuthority(AutoGeneratedEra.deploy(web3j,
                credentials, gasPrice, gasLimit));

        while (!era.isReady()) {
            era.waitUntilReady();
        }

        return era;
    }

    public EthereumRegistrationAuthority eraAtAddress(String contractAddress) {
        ReadonlyTransactionManager rtm = new ReadonlyTransactionManager(web3j, contractAddress);

        BigInteger gasPrice = null;
        BigInteger gasLimit = null;

        return new EthereumRegistrationAuthority(AutoGeneratedEra.load(contractAddress,
                web3j, rtm, gasPrice, gasLimit));
    }

    public DomainInfo deployDomainInfo() {
        if (credentials == null) return null;

        BigInteger gasPrice = null;
        BigInteger gasLimit = null;

        DomainInfo di = new DomainInfo(AutoGeneratedDomainInfo.deploy(web3j,
                credentials, gasPrice, gasLimit));

        while (!di.isReady()) {
            di.waitUntilReady();
        }

        return di;
    }

    public DomainInfo domainInfoAtAddress(String contractAddress) {
        ReadonlyTransactionManager rtm = new ReadonlyTransactionManager(web3j, contractAddress);

        BigInteger gasPrice = null;
        BigInteger gasLimit = null;

        return new DomainInfo(AutoGeneratedDomainInfo.load(contractAddress,
                web3j, rtm, gasPrice, gasLimit));
    }

    public Finder deployFinder() {
        if (credentials == null) return null;

        BigInteger gasPrice = null;
        BigInteger gasLimit = null;

        Finder finder = new Finder(AutoGeneratedFinder.deploy(web3j,
                credentials, gasPrice, gasLimit));

        while (!finder.isReady()) {
            finder.waitUntilReady();
        }

        return finder;
    }

    public Finder finderAtAddress(String contractAddress) {
        ReadonlyTransactionManager rtm = new ReadonlyTransactionManager(web3j, contractAddress);

        BigInteger gasPrice = null;
        BigInteger gasLimit = null;

        return new Finder(AutoGeneratedFinder.load(contractAddress,
                web3j, rtm, gasPrice, gasLimit));
    }
}
