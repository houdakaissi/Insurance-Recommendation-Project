package org.lsi;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Contracts extends Contract {
    public static final String BINARY = "0x6080604052600060015534801561001557600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506110f7806100656000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c80630d9d53371461005c5780632e67acb11461007a5780633dfc26b4146104325780638da5cb5b14610450578063947437741461049a575b600080fd5b610064610764565b6040518082815260200191505060405180910390f35b610430600480360360e081101561009057600080fd5b81019080803590602001906401000000008111156100ad57600080fd5b8201836020820111156100bf57600080fd5b803590602001918460018302840111640100000000831117156100e157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561014457600080fd5b82018360208201111561015657600080fd5b8035906020019184600183028401116401000000008311171561017857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156101db57600080fd5b8201836020820111156101ed57600080fd5b8035906020019184600183028401116401000000008311171561020f57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561027257600080fd5b82018360208201111561028457600080fd5b803590602001918460018302840111640100000000831117156102a657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001909291908035906020019064010000000081111561031357600080fd5b82018360208201111561032557600080fd5b8035906020019184600183028401116401000000008311171561034757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156103aa57600080fd5b8201836020820111156103bc57600080fd5b803590602001918460018302840111640100000000831117156103de57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929050505061076e565b005b61043a610c20565b6040518082815260200191505060405180910390f35b610458610c26565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6104c6600480360360208110156104b057600080fd5b8101908080359060200190929190505050610c4b565b6040518080602001806020018060200180602001888152602001806020018060200187810387528e818151815260200191508051906020019080838360005b83811015610520578082015181840152602081019050610505565b50505050905090810190601f16801561054d5780820380516001836020036101000a031916815260200191505b5087810386528d818151815260200191508051906020019080838360005b8381101561058657808201518184015260208101905061056b565b50505050905090810190601f1680156105b35780820380516001836020036101000a031916815260200191505b5087810385528c818151815260200191508051906020019080838360005b838110156105ec5780820151818401526020810190506105d1565b50505050905090810190601f1680156106195780820380516001836020036101000a031916815260200191505b5087810384528b818151815260200191508051906020019080838360005b83811015610652578082015181840152602081019050610637565b50505050905090810190601f16801561067f5780820380516001836020036101000a031916815260200191505b50878103835289818151815260200191508051906020019080838360005b838110156106b857808201518184015260208101905061069d565b50505050905090810190601f1680156106e55780820380516001836020036101000a031916815260200191505b50878103825288818151815260200191508051906020019080838360005b8381101561071e578082015181840152602081019050610703565b50505050905090810190601f16801561074b5780820380516001836020036101000a031916815260200191505b509d505050505050505050505050505060405180910390f35b6000600154905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146107c757600080fd5b6000831161083d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600e8152602001807f4d757374206265206120636f737400000000000000000000000000000000000081525060200191505060405180910390fd5b6001600081548092919060010191905055506040518060e001604052808881526020018781526020018681526020018581526020018481526020018381526020018281525060026000600154815260200190815260200160002060008201518160000190805190602001906108b392919061101d565b5060208201518160010190805190602001906108d092919061101d565b5060408201518160020190805190602001906108ed92919061101d565b50606082015181600301908051906020019061090a92919061101d565b506080820151816004015560a082015181600501908051906020019061093192919061101d565b5060c082015181600601908051906020019061094e92919061101d565b509050507ffbc3e4d7b55189315bb894aa4a678a3294abfc1c05a9b1411a67c81f1629f719878787878787876040518080602001806020018060200180602001888152602001806020018060200187810387528e818151815260200191508051906020019080838360005b838110156109d45780820151818401526020810190506109b9565b50505050905090810190601f168015610a015780820380516001836020036101000a031916815260200191505b5087810386528d818151815260200191508051906020019080838360005b83811015610a3a578082015181840152602081019050610a1f565b50505050905090810190601f168015610a675780820380516001836020036101000a031916815260200191505b5087810385528c818151815260200191508051906020019080838360005b83811015610aa0578082015181840152602081019050610a85565b50505050905090810190601f168015610acd5780820380516001836020036101000a031916815260200191505b5087810384528b818151815260200191508051906020019080838360005b83811015610b06578082015181840152602081019050610aeb565b50505050905090810190601f168015610b335780820380516001836020036101000a031916815260200191505b50878103835289818151815260200191508051906020019080838360005b83811015610b6c578082015181840152602081019050610b51565b50505050905090810190601f168015610b995780820380516001836020036101000a031916815260200191505b50878103825288818151815260200191508051906020019080838360005b83811015610bd2578082015181840152602081019050610bb7565b50505050905090810190601f168015610bff5780820380516001836020036101000a031916815260200191505b509d505050505050505050505050505060405180910390a150505050505050565b60015481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6002602052806000526040600020600091509050806000018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cf75780601f10610ccc57610100808354040283529160200191610cf7565b820191906000526020600020905b815481529060010190602001808311610cda57829003601f168201915b505050505090806001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d955780601f10610d6a57610100808354040283529160200191610d95565b820191906000526020600020905b815481529060010190602001808311610d7857829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e335780601f10610e0857610100808354040283529160200191610e33565b820191906000526020600020905b815481529060010190602001808311610e1657829003601f168201915b505050505090806003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ed15780601f10610ea657610100808354040283529160200191610ed1565b820191906000526020600020905b815481529060010190602001808311610eb457829003601f168201915b505050505090806004015490806005018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f755780601f10610f4a57610100808354040283529160200191610f75565b820191906000526020600020905b815481529060010190602001808311610f5857829003601f168201915b505050505090806006018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110135780601f10610fe857610100808354040283529160200191611013565b820191906000526020600020905b815481529060010190602001808311610ff657829003601f168201915b5050505050905087565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061105e57805160ff191683800117855561108c565b8280016001018555821561108c579182015b8281111561108b578251825591602001919060010190611070565b5b509050611099919061109d565b5090565b6110bf91905b808211156110bb5760008160009055506001016110a3565b5090565b9056fea265627a7a723158201a4413550460b9afd69956bc2f4c60d637aa84a570959c0884079f8eab6e605064736f6c63430005100032";

    public static final String FUNC_PROPRETIES = "Propreties";

    public static final String FUNC_PROPRETYCOUNT = "PropretyCount";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDLAND = "addLand";

    public static final String FUNC_GETNUMBERLANDS = "getNumberLands";

    public static final Event ADD_EVENT = new Event("Add", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0xffd69992f3C257296C5CdD1D1e4B3D7AA71955C7");
    }

    @Deprecated
    protected Contracts(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Contracts(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Contracts(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Contracts(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddEventResponse> getAddEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADD_EVENT, transactionReceipt);
        ArrayList<AddEventResponse> responses = new ArrayList<AddEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddEventResponse typedResponse = new AddEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.numeroContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.idProprety = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.ownerLand = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.buyerLand = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.cost = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.desc = (String) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.date = (String) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddEventResponse> addEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddEventResponse>() {
            @Override
            public AddEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADD_EVENT, log);
                AddEventResponse typedResponse = new AddEventResponse();
                typedResponse.log = log;
                typedResponse.numeroContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.idProprety = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.ownerLand = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.buyerLand = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.cost = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.desc = (String) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.date = (String) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddEventResponse> addEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADD_EVENT));
        return addEventFlowable(filter);
    }

    public RemoteFunctionCall<Tuple7<String, String, String, String, BigInteger, String, String>> Propreties(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PROPRETIES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple7<String, String, String, String, BigInteger, String, String>>(function,
                new Callable<Tuple7<String, String, String, String, BigInteger, String, String>>() {
                    @Override
                    public Tuple7<String, String, String, String, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, String, String, BigInteger, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> PropretyCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PROPRETYCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addLand(String numeroContract, String idProprety, String _ownerLand, String _buyerLand, BigInteger _cost, String _desc, String _date) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(numeroContract), 
                new org.web3j.abi.datatypes.Utf8String(idProprety), 
                new org.web3j.abi.datatypes.Utf8String(_ownerLand), 
                new org.web3j.abi.datatypes.Utf8String(_buyerLand), 
                new org.web3j.abi.datatypes.generated.Uint256(_cost), 
                new org.web3j.abi.datatypes.Utf8String(_desc), 
                new org.web3j.abi.datatypes.Utf8String(_date)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getNumberLands() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNUMBERLANDS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Contracts load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contracts(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Contracts load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contracts(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Contracts load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Contracts(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Contracts load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Contracts(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Contracts> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Contracts.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Contracts> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Contracts.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Contracts> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Contracts.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Contracts> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Contracts.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AddEventResponse extends BaseEventResponse {
        public String numeroContract;

        public String idProprety;

        public String ownerLand;

        public String buyerLand;

        public BigInteger cost;

        public String desc;

        public String date;
    }
}
