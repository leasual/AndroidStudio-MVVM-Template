package com.mvvm.javademo.model;

import android.text.TextUtils;

import com.mvvm.javademo.util.Aes256cbc.Encode;
import com.mvvm.javademo.util.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rainy.liao
 */
public class RequestHelper {
    //get Supported Region
    public static final int FUNCTION_GET_SUPPORTED_REGION = 1;
    //get Supported Device
    public static final int FUNCTION_GET_SUPPORTED_DEVICE = 2;
    //get Support Brand
    public static final int FUNCTION_GET_SUPPORTED_BRAND = 3;
    //get Brand Major
    public static final int FUNCTION_GET_BRAND_MAJOR = 4;
    //get Code List Brand_full
    public static final int FUNCTION_GET_CODE_LIST_BRAND_FULL = 5;
    //get Code List Brand_quick
    public static final int FUNCTION_GET_CODE_LIST_BRAND_QUICK = 6;
    //get Supported Key
    public static final int FUNCTION_GET_SUPPORTED_KEY = 7;
    //get Master Key
    public static final int FUNCTION_GET_MASTER_KEY = 8;
    //getDbVersion
    public static final int FUNCTION_GET_DB_VERSION = 9;
    //get Code List signature
    public static final int FUNCTION_GET_CODE_LIST_SIGNATURE = 10;
    //get Code List Brand model
    public static final int FUNCTION_GET_CODE_LIST_BRAND_MODEL = 11;
    //get BrandId
    public static final int FUNCTION_GET_BRAND_ID = 12;
    //get subRegion
    public static final int FUNCTION_GET_SUB_REGION = 13;
    //get Model Num
    public static final int FUNCTION_GET_MODEL_NUM = 14;
    //get Model Num By Code Num
    public static final int FUNCTION_GET_MODEL_NUM_BY_CODE_NUM = 15;
    //get IrData key
    public static final int FUNCTION_GET_IR_DATA_KEY = 501;
    //get IrData code
    public static final int FUNCTION_GET_IR_DATA_CODE = 502;
    //Prepare Interactive Search
    public static final int FUNCTION_PREPARE_INTERACTIVE_SEARCH = 504;
    //Interactive Search
    public static final int FUNCTION_INTERACTIVE_SEARCH = 505;


    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * get Supported Region
     *
     * @return
     */
    public static Map<String, Object> getSupportedRegion() {
        return getParamsFieldMap(FUNCTION_GET_SUPPORTED_REGION, null);
    }

    /**
     * get Supported Device
     *
     * @param region e.g.	US	Region	of	the	IR	code	library
     * @return
     */
    public static Map<String, Object> getSupportedDevice(String region) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        return getParamsFieldMap(FUNCTION_GET_SUPPORTED_DEVICE, paramsMap);
    }

    /**
     * get Supported Brand
     *
     * @param region    e.g.	ASIA	Region	of	the	IR	code	library
     * @param deviceId  e.g.	12	Equipment	device	ID	number
     * @param subRegion e.g.	CN	Subregion	of	the	IR	code	library	(Optional)
     * @param brandx1   e.g.	广东	/	Guangdong
     *                  List	of	brandx1,	for	Cable	in	China,	it	refer	Province	(Accept	CN	/	EN)	(Optional)
     * @param brandx2   e.g.	广州	/	Guangzhou
     *                  City	name	(Accept	CN	/	EN)	(Optional)
     * @return
     */
    public static Map<String, Object> getSupportedBrand(String region, int deviceId, String subRegion, String brandx1, String brandx2) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        if (!TextUtils.isEmpty(subRegion)) {
            paramsMap.put("subRegion", subRegion);
        }
        if (!TextUtils.isEmpty(brandx1)) {
            paramsMap.put("brandx1", brandx1);
        }
        if (!TextUtils.isEmpty(brandx2)) {
            paramsMap.put("brandx2", brandx2);
        }
        return getParamsFieldMap(FUNCTION_GET_SUPPORTED_BRAND, paramsMap);
    }

    /**
     * getBrandMajor
     *
     * @param region   e.g.	ASIA	Region	of	the	IR	code	library
     * @param deviceId e.g.	1	Equipment	device	ID	number
     * @return
     */
    public static Map<String, Object> getBrandMajor(String region, int deviceId) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        return getParamsFieldMap(FUNCTION_GET_BRAND_MAJOR, paramsMap);
    }

    /**
     * Get Code List Brand_full
     *
     * @param region   e.g.	ASIA	Region	of	the	IR	code	library
     * @param deviceId e.g.	1	Equipment	device	ID	number
     * @param brandId  e.g.	2572	Equipment	brand	name	ID	number
     * @return
     */
    public static Map<String, Object> getCodeListBrand_full(String region, int deviceId, int brandId) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("brandId", brandId);
        return getParamsFieldMap(FUNCTION_GET_CODE_LIST_BRAND_FULL, paramsMap);
    }

    /**
     * Get Code List Brand_quick
     *
     * @param region   e.g.	ASIA	Region	of	the	IR	code	library
     * @param deviceId e.g.	1	Equipment	device	ID	number
     * @param brandId  e.g.	2572	Equipment	brand	name	ID	number
     * @return
     */
    public static Map<String, Object> getCodeListBrand_quick(String region, int deviceId, int brandId) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("brandId", brandId);
        return getParamsFieldMap(FUNCTION_GET_CODE_LIST_BRAND_QUICK, paramsMap);
    }

    /**
     * get Supported Key
     *
     * @param region   e.g.	GLOBAL	Region	of	the	IR	code	library
     * @param deviceId e.g.	0	Equipment	device	ID	number
     * @param codeNum  e.g.	655	Code	set	number	of	IR	code
     * @return
     */
    public static Map<String, Object> getSupportedKey(String region, int deviceId, int codeNum) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("codeNum", codeNum);
        return getParamsFieldMap(FUNCTION_GET_SUPPORTED_KEY, paramsMap);
    }

    /**
     * get Master Key
     *
     * @param deviceId
     * @return
     */
    public static Map<String, Object> getMasterKey(int deviceId) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("deviceId", deviceId);
        return getParamsFieldMap(FUNCTION_GET_MASTER_KEY, paramsMap);
    }

    /**
     * get Db Version
     *
     * @return
     */
    public static Map<String, Object> getDbVersion() {
        return getParamsFieldMap(FUNCTION_GET_DB_VERSION, null);
    }

    /**
     * get Code List signature
     *
     * @param region
     * @param deviceId
     * @param brandId
     * @param keyId    ID	number	of	function	key	s0
     * @param s0       Remotec	patent	pending	algorithm	for	code	searching.
     * @param s1       s0,	s1,	s2,	s3	are	IR	signal	signature	information	retrieved	from	Remotec	IR	chip
     * @param s2
     * @param s3
     * @return
     */
    public static Map<String, Object> getCodeList_signature(String region, int deviceId, int brandId, int keyId, String s0, String s1, String s2, String s3) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("brandId", brandId);
        paramsMap.put("keyId", keyId);
        paramsMap.put("s0", s0);
        paramsMap.put("s1", s1);
        paramsMap.put("s2", s2);
        paramsMap.put("s3", s3);
        return getParamsFieldMap(FUNCTION_GET_CODE_LIST_SIGNATURE, paramsMap);
    }

    /**
     * @param region
     * @param deviceId
     * @param brandId
     * @param devModelNum    e.g.	Generic	model	2244 ,Model	number	of	the	equirpment	device(Either	or	both)
     * @param remoteModelNum e.g.	Remote	code	2244
     *                       Model	number	of	the	remote	control	of	the	equirpment	device(Either	or	both)
     * @param brandx1        e.g.	广东	List	of	brandx1,	for	Cable	in	China,	it	refer	Province	(Accept	CN	/	EN)	(Optional)
     * @param brandx2        e.g.	Guangzhou
     *                       City	name	(Accept	CN	/	EN)	(Optional)
     * @param strict         e.g.	1	Using	to	control	the	condition	of	filter	“devModelNum”	and	“remoteModelNum”	0	=	OR,	1	=	AND,	*Default	value	is	0	(AND)
     * @return
     */
    public static Map<String, Object> getCodeListBrand_model(String region, int deviceId, int brandId, String devModelNum, String remoteModelNum, String brandx1, String brandx2, int strict) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("brandId", brandId);
        paramsMap.put("devModelNum", devModelNum);
        paramsMap.put("remoteModelNum", remoteModelNum);
        if (!TextUtils.isEmpty("brandx1")) {
            paramsMap.put("brandx1", brandx1);
        }
        if (!TextUtils.isEmpty("brandx2")) {
            paramsMap.put("brandx2", brandx2);
        }
        paramsMap.put("strict", strict);
        return getParamsFieldMap(FUNCTION_GET_CODE_LIST_BRAND_MODEL, paramsMap);
    }


    /**
     * get Brand Id, To get brand information such as brand id and brand name according to the input PNP ID
     *
     * @param id_type  Fixed	constant	on	this	field
     * @param id_value PNP	Vendor	IDs	consist	of	3	characters,	each	character	being	an	uppercase	letter	(A-Z).
     * @return
     */
    public static Map<String, Object> getBrandId(String id_type, String id_value) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("id_type", id_type);
        paramsMap.put("id_value", id_value);
        return getParamsFieldMap(FUNCTION_GET_BRAND_ID, paramsMap);
    }

    /**
     * get subRegion. To	get	the	subregion	of	the	target	device	ID,	this	list	helps	user	to	choose	a	short	list	of	brand	after	functionID	3.
     *
     * @param region
     * @param deviceId
     * @return
     */
    public static Map<String, Object> getSubRegion(String region, int deviceId) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        return getParamsFieldMap(FUNCTION_GET_SUB_REGION, paramsMap);
    }

    /**
     * get Model Num. To	get	the	device	model	nunber	list.	This	list	help	user	to	choose	a	short	list	of	model	number	in	a	quick	way	instead	of	browse	the	code	number	list
     *
     * @param region
     * @param deviceId
     * @param brandId
     * @return
     */
    public static Map<String, Object> getModelNum(String region, int deviceId, int brandId) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("brandId", brandId);
        return getParamsFieldMap(FUNCTION_GET_MODEL_NUM, paramsMap);
    }

    /**
     * Get Model Num By Code Num
     *
     * @param region
     * @param deviceId
     * @param brandId
     * @param codeNum
     * @return
     */
    public static Map<String, Object> getModelNumByCodeNum(String region, int deviceId, int brandId, int codeNum) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("brandId", brandId);
        paramsMap.put("codeNum", codeNum);
        return getParamsFieldMap(FUNCTION_GET_MODEL_NUM_BY_CODE_NUM, paramsMap);
    }

    /**
     * get Ir Data key.Get	an	IR	data	of	a	key	for	selected	code.	For	data	protection,	there	are	some	access	controls	for	this	command,	when	it	detects	abnormal	access,	such	as	batch	data	dump,	robot	behavior	etc.,	a	user	account	maybe	locked	by	the	system.
     *
     * @param region
     * @param deviceId
     * @param brandId
     * @param codeNum
     * @param keyId
     * @param stPower
     * @param stMode
     * @param stTemp
     * @param stFan
     * @param stSwing
     * @return
     */
    public static Map<String, Object> getIrData_key(String region, int deviceId, int brandId, int codeNum, int keyId, String stPower, String stMode, String stTemp, String stFan, String stSwing) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("brandId", brandId);
        paramsMap.put("codeNum", codeNum);
        paramsMap.put("keyId", keyId);
        if (!TextUtils.isEmpty("stPower")) {
            paramsMap.put("stPower", stPower);
        }
        if (!TextUtils.isEmpty("stMode")) {
            paramsMap.put("stMode", stMode);
        }
        if (!TextUtils.isEmpty("stTemp")) {
            paramsMap.put("stTemp", stTemp);
        }
        if (!TextUtils.isEmpty("stFan")) {
            paramsMap.put("stFan", stFan);
        }
        if (!TextUtils.isEmpty("stSwing")) {
            paramsMap.put("stSwing", stSwing);
        }
        return getParamsFieldMap(FUNCTION_GET_IR_DATA_KEY, paramsMap);
    }

    /**
     * get IrData code. Get full IR data of all keys for selected code. For data protection, there are some access controls for this command, when it detects abnormal access, such as batch data dump, robot behavior etc., a user account maybe locked by the system.
     *
     * @param region
     * @param deviceId
     * @param codeNum
     * @return
     */
    public static Map<String, Object> getIrData_code(String region, int deviceId, int codeNum) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("codeNum", codeNum);
        return getParamsFieldMap(FUNCTION_GET_IR_DATA_CODE, paramsMap);
    }

    /**
     * prepare Interactive Search. Generate	a	conversation	id	to	prepare	the	request	for	function	call	–	C.505	InteractiveSearch
     *
     * @param region
     * @param deviceId
     * @param brandId
     * @return
     */
    public static Map<String, Object> prepareInteractiveSearch(String region, int deviceId, int brandId) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("region", region);
        paramsMap.put("deviceId", deviceId);
        paramsMap.put("brandId", brandId);
        return getParamsFieldMap(FUNCTION_PREPARE_INTERACTIVE_SEARCH, paramsMap);
    }

    /**
     * 	Interactive	Search	(Smart	Search)	is	only	supporting	device	type	in	AV	category	currently
     * @param conversation_id
     * @param answer: Available	value	table	of	parameter	“answer”	Value	Descroption
     *              STAND	To	get	the	first	testing	key[1]	or	get	the	current	status	of	that	conversation_id
     *              YES	The	answer	of	current	testing	key[1]
     *              NO	The	answer	of	current	testing	key[1]
     *              SKIP	To	skip	the	currect	testing	key[1]	without	answering	YES/NO	to	the	next	key	if	the	traditional	remote	does	not	have	that	testing	key
     *              BACK	Jump	back	to	previous	testing	key[1]	if	user	clicked	the	wrong	selection	YES/NO	in	previous	testing	key
     * @return
     */
    public static Map<String, Object> interactiveSearch(String conversation_id, String answer) {
        HashMap paramsMap = new HashMap();
        paramsMap.put("conversation_id", conversation_id);
        paramsMap.put("answer", answer);
        return getParamsFieldMap(FUNCTION_INTERACTIVE_SEARCH, paramsMap);
    }

    /**
     * 通用参数组装
     *
     * @param params
     * @return
     */
    private static Map<String, Object> getParamsFieldMap(int functionId, Map<String, Object> params) {
        long te = System.currentTimeMillis();
        long systemTime = te/10000;			// 13 digits -> 9 digits
//        systemTime += 10;
        String time = Long.toString(systemTime);

        HashMap paramsMap = new HashMap();
        paramsMap.put("function_id", functionId);
        paramsMap.put("auth_cipher", "aes-256-cbc");
//        paramsMap.put("imei", App.getInstance().getImei());
        paramsMap.put("user_email", Encode.getEncode(Constants.USER_EMAIL, time));
        paramsMap.put("user_pwd",  Encode.getEncode(Constants.USER_PWD, time));
        paramsMap.put("pa_key", Constants.PA_KEY);
        paramsMap.put("project_code", Constants.PROJECT_CODE);
        paramsMap.put("customer_code", Constants.CUSTOMER_CODE);
        if (params != null) {
            paramsMap.putAll(params);
        }
        return paramsMap;
    }
}
