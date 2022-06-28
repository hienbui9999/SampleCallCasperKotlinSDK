import com.casper.sdk.BlockIdentifier
import com.casper.sdk.BlockIdentifierType
import com.casper.sdk.ConstValues
import com.casper.sdk.getdeploy.Deploy
import com.casper.sdk.getdeploy.ExecutableDeployItem.ExecutableDeployItem
import com.casper.sdk.getdeploy.ExecutableDeployItem.ExecutableDeployItem_ModuleBytes
import com.casper.sdk.getdeploy.ExecutableDeployItem.NamedArg
import com.casper.sdk.getdeploy.GetDeployParams
import com.casper.sdk.getdeploy.GetDeployRPC
import com.casper.sdk.getstateroothash.GetStateRootHashRPC

fun  main(args:Array<String>) {
    println("Hello Casper Kotlin SDK")
    getStateRootHash()
    getDeployTest()
}

fun getDeployTest() {
    //Get deploy base on deploy at this address
    //https://testnet.cspr.live/deploy/9ff98d8027795a002e41a709d5b5846e49c2e9f9c8bfbe74e4c857adc26d5571
    val getDeployRPC = GetDeployRPC()
    val getDeployParams = GetDeployParams()
    getDeployRPC.methodURL = ConstValues.TESTNET_URL
    getDeployParams.deploy_hash = "9ff98d8027795a002e41a709d5b5846e49c2e9f9c8bfbe74e4c857adc26d5571"
    val postParameter = getDeployParams.generatePostParameterStr()
    try {
        val getDeployResult = getDeployRPC.getDeployFromJsonStr(postParameter)
        val deploy: Deploy = getDeployResult.deploy
        println("Deploy hash is: " + deploy.hash)
        if(deploy.payment.itsType == ExecutableDeployItem.MODULE_BYTES) {
            println("Deploy payment is of type ModuleBytes")
        }
        if(deploy.session.itsType == ExecutableDeployItem.MODULE_BYTES) {
            println("Deploy session is of type ModuleBytes")
        }
        val payment: ExecutableDeployItem_ModuleBytes =
            deploy.payment.itsValue[0] as ExecutableDeployItem_ModuleBytes
        //payment first arg
        val paymentNA: NamedArg = payment.args.listNamedArg[0]
        println("Payment first args name:" + paymentNA.itsName)
        println("Payment first args cl type:" + paymentNA.clValue.itsCLType.itsTypeStr)
        println("Payment first args clvalue bytes:" +paymentNA.clValue.itsBytes )
        println("Payment first args clvalue parse:" + paymentNA.clValue.itsParse.itsValueInStr)
    }  catch (e:  IllegalArgumentException) {
    }
}
fun getStateRootHash() {
    val getStateRootHashTest = GetStateRootHashRPC()
    //Call 1:  Get state root hash with non parameter
    val bi = BlockIdentifier()
    bi.blockType = BlockIdentifierType.NONE
    val str: String = bi.toJsonStr(ConstValues.RPC_GET_STATE_ROOT_HASH)
    try {
        val stateRootHash1 = getStateRootHashTest.getStateRootHash(str)
        println("stateRootHash1" + stateRootHash1)
    } catch (e: IllegalArgumentException) {}
    //Call 2:  Get state root hash with BlockIdentifier of type Block Hash with correct Block Hash
    bi.blockType = BlockIdentifierType.HASH
    bi.blockHash = "fe35810a3dcfbf853b9d3ac2445fe1fa4aaab047d881d95d9009dc257d396e7e"
    val str2: String = bi.toJsonStr(ConstValues.RPC_GET_STATE_ROOT_HASH)
    try {
        val stateRootHash2 = getStateRootHashTest.getStateRootHash(str2)
        println("stateRootHash2" + stateRootHash2)
    } catch (e: IllegalArgumentException){}
    //Call3:  Get state root hash with BlockIdentifier of type Block Height with correct Block Height
    bi.blockType = BlockIdentifierType.HEIGHT
    bi.blockHeight = 673033u
    val str3: String = bi.toJsonStr(ConstValues.RPC_GET_STATE_ROOT_HASH)
    try {
        val stateRootHash3 = getStateRootHashTest.getStateRootHash(str3)
        println("stateRootHash3:" + stateRootHash3)
    } catch (e: IllegalArgumentException){}

    //Negative test

    //Call 4:  Get state root hash with BlockIdentifier of type Block Hash with incorrect Block Hash.
    // Expected result:  latest state root hash
    bi.blockType = BlockIdentifierType.HASH
    bi.blockHash = "aaa_fe35810a3dcfbf853b9d3ac2445fe1fa4aaab047d881d95d9009dc257d396e7e"
    val str4: String = bi.toJsonStr(ConstValues.RPC_GET_STATE_ROOT_HASH)
    try {
        val stateRootHash4 = getStateRootHashTest.getStateRootHash(str4)
        println("stateRootHash4:" + stateRootHash4)
    } catch (e: IllegalArgumentException){}
    //Call5:  Get state root hash with BlockIdentifier of type Block Height with incorrect Block Height,  expected result:  Error
    bi.blockType = BlockIdentifierType.HEIGHT
    bi.blockHeight = 667303389999u
    try {
        val str5:  String = bi.toJsonStr(ConstValues.RPC_GET_STATE_ROOT_HASH)
        getStateRootHashTest.getStateRootHash(str5)
    } catch (e: IllegalArgumentException) {
        println("Error Get State Root Hash,  invalid parameter")
    }
}