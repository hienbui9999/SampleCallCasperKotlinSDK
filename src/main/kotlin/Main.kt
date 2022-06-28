import com.casper.sdk.BlockIdentifier
import com.casper.sdk.BlockIdentifierType
import com.casper.sdk.ConstValues
import com.casper.sdk.getstateroothash.GetStateRootHashRPC

fun  main(args:Array<String>) {
    println("Hello Casper Kotlin SDK")
    getStateRootHash()
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