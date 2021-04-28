> # Android JNI学习(三)——Java与Native相互调用
>
> https://www.jianshu.com/p/b71aeb4ed13d

# ndk.h

```c
typedef enum {
	P_224,
	P_256,
	P_384,
	P_521,
	ECC_TYPE_MAX,
} ECC_TYPE;

/**
 *
 * @param CurveType
 * @param dgst
 * @param dlen
 * @param sig
 * @param siglen
 * @param eccprikey
 * @return
 */
extern int (*NAPI_AlgECDSASign)(ECC_TYPE CurveType, const unsigned char *dgst, int dlen, unsigned char *sig, unsigned int *siglen, unsigned char *eccprikey);

/**
 *
 * @param CurveType
 * @param dgst
 * @param dlen
 * @param sig
 * @param siglen
 * @param eccpubkey
 * @return
 */
extern int (*NAPI_AlgECDSAVerify)(ECC_TYPE CurveType, const unsigned char *dgst, int dlen, unsigned char *sig, unsigned int siglen, unsigned char *eccpubkey);
```

# jni_usePosNDK.c

```C
//NAPI_AlgECDSASign(ECC_TYPE CurveType, const unsigned char *dgst, int dlen, unsigned char *sig, unsigned int *siglen, unsigned char *eccprikey)
jint NAPI_AlgECDSASign(JNIEnv* env, jobject obj,int type,jbyteArray jdgst,int dlen,jbyteArray jsig,jintArray jsiglen,jbyteArray jeccprikey){
	uchar *dgst=NULL;
	uchar *sig=NULL;
	int *siglen=NULL;
	uchar *eccprikey=NULL;
	if(jdgst != NULL){
		dgst = (uchar *) (*env)->GetByteArrayElements(env, jdgst,NULL);
	}
	if (jsig != NULL){
		sig = (uchar *) (*env)->GetIntArrayElements(env, jsig, NULL);
	}
	if(jsiglen != NULL){
		siglen = (int *) (*env)->GetByteArrayElements(env, jsiglen,NULL);
	}
	if (jeccprikey != NULL){
		eccprikey = (uchar *) (*env)->GetIntArrayElements(env, jeccprikey, NULL);
	}
	int nRet = NAPI_AlgECDSASign(type, dgst, dlen, sig, siglen, eccprikey);

	if (dgst != NULL){
		(*env)->ReleaseByteArrayElements(env, jdgst, (jbyte *) dgst,0);
	}

	if (sig != NULL){
		(*env)->ReleaseIntArrayElements(env, jsig, (jbyte *) sig,0);
	}
	if (siglen != NULL){
		(*env)->ReleaseByteArrayElements(env, jsiglen, (jint *) siglen,0);
	}
	if (eccprikey != NULL){
		(*env)->ReleaseByteArrayElements(env, jeccprikey, (jbyte *) eccprikey,0);
	}
	return (jint)nRet;
}

//NAPI_ERR_CODE NAPI_AlgECDSAVerify(ECC_TYPE CurveType, const unsigned char *dgst, int dlen, unsigned char *sig, unsigned int siglen, unsigned char *eccpubkey);
jint NAPI_AlgECDSAVerify(JNIEnv* env, jobject obj,int type,jbyteArray jdgst,int dlen,jbyteArray jsig,int siglen,jbyteArray jeccpubkey){
	uchar *dgst=NULL;
	uchar *sig=NULL;
	uchar *eccpubkey=NULL;
	if(jdgst != NULL){
		dgst = (uchar *) (*env)->GetByteArrayElements(env, jdgst,NULL);
	}
	if (jsig != NULL){
		sig = (uchar *) (*env)->GetIntArrayElements(env, jsig, NULL);
	}
	if (jeccpubkey != NULL){
		eccpubkey = (uchar *) (*env)->GetIntArrayElements(env, jeccpubkey, NULL);
	}

	int nRet = NAPI_AlgECDSAVerify(type, dgst, dlen, sig, siglen, eccprikey);
if (dgst != NULL){
		(*env)->ReleaseByteArrayElements(env, jdgst, (jbyte *) dgst,0);
	}

	if (sig != NULL){
		(*env)->ReleaseIntArrayElements(env, jsig, (jbyte *) sig,0);
	}
	if (eccpubkey != NULL){
		(*env)->ReleaseByteArrayElements(env, jeccpubkey, (jbyte *) eccpubkey,0);
	}
	return (jint)nRet;
}

/* JNI method table */
static const JNINativeMethod method_table[] = {
		{"getSysPosInfo","(I[I[B)I",(void *)Pos_getSysPosInfo},
		{"setDateTime","(I[B)I",(void *)Pos_setDateTime},
		{"generateNonce", "([B)I",(void *)Pos_generateNonce},
		{"doMKLDAuth","([B[B[B[B)I",(void *)Pos_doMKLDAuth},
		{"loadKey","(I[B)I",(void *)Pos_loadKey},
		{"loadKey_New","(I[B)I",(void *)Pos_loadKey_New},
		{"deleteKey","()I",(void *)Pos_deleteKey},
		{"JNI_PosSecGetTamperStatus","([I)I",(void *)Pos_SecGetTamperStatus},
		{"JNI_PosSecClear","()I",(void *)Pos_SecClear},
		{"JNI_NAPI_SecGetKeyInfo","()I",(void *)Pos_NAPI_SecGetKeyInfo},
		{"JNI_NAPI_SecKLDAuthKla","(I[B[I[B[I[B)I",(void *)Pos_NAPI_SecKLDAuthKla},
		{"JNI_NAPI_AlgECDSASign","(I[BI[B[B[B)I",(void *)NAPI_AlgECDSASign},
		{"JNI_NAPI_AlgECDSAVerify","(I[BI[BI[B)I",(void *)NAPI_AlgECDSAVerify},

};
```

# .java

```java
private static String TAG = "EccTest";



    public static native int JNI_NAPI_AlgECDSASign(int type,byte[] jdgst,int dlen,byte[] jsig,byte[] jsiglen,byte[] jeccprikey);
    public static native int JNI_NAPI_AlgECDSAVerify(int type,byte[] jdgst,int dlen,byte[] jsig,int siglen,byte[] jeccpubkey);

    public  int NAPI_AlgECDSASign(int type,byte[] jdgst,int dlen,byte[] jsig,byte[] jsiglen,byte[] jeccprikey) {
        Log.w(TAG, "into NAPI_AlgECDSASign");
        int ret;
        ret = JNI_NAPI_AlgECDSASign(type,jdgst,dlen,jsig,jsiglen,jeccprikey);
        Log.e(TAG, "outof NAPI_AlgECDSASign:" + ret);
        return ret;
    }

    public int NAPI_AlgECDSAVerify(int type,byte[] jdgst,int dlen,byte[] jsig,int siglen,byte[] jeccpubkey){
        Log.w(TAG, "into NAPI_AlgECDSAVerify");
        int ret;
        ret = JNI_NAPI_AlgECDSAVerify(type,jdgst,dlen,jsig,siglen,jeccpubkey);
        Log.e(TAG, "outof NAPI_AlgECDSAVerify:" + ret);
        return ret;
    }
```

> ```c
> /**
> *@brief	将AscII码的字符串转换成压缩的HEX格式
> *@details	非偶数长度的字符串根据对齐方式，采取左右补0。
> *@param	pszAsciiBuf		被转换的ASCII字符串
> *@param	nLen			输入数据长度(ASCII字符串的长度)
> *@param	ucType			对齐方式  0－左对齐  1－右对齐
> *@retval	psBcdBuf		转换输出的HEX数据
> *@return
> *@li	NDK_OK				操作成功
> *@li	\ref NDK_ERR_PARA "NDK_ERR_PARA"	参数非法(pszAsciiBuf/psBcdBuf为NULL、nLen<=0)
> */
> extern int (*NDK_AscToHex )(const uchar* pszAsciiBuf, int nLen, uchar ucType, uchar* psBcdBuf);
> 
> /**
>  *@brief	将HEX码数据转换成AscII码字符串
>  *@param	psBcdBuf		被转换的Hex数据
>  *@param	nLen			转换数据长度(ASCII字符串的长度)
>  *@param	ucType			对齐方式  1－左对齐  0－右对齐
>  *@retval	pszAsciiBuf		转换输出的AscII码数据
>  *@return
>  *@li	NDK_OK				操作成功
>  *@li	\ref NDK_ERR_PARA "NDK_ERR_PARA"	参数非法(psBcdBuf/pszAsciiBuf为NULL、nLen<0、ucType非法)
> */
> extern int (*NDK_HexToAsc )(const uchar* psBcdBuf, int nLen, uchar ucType, uchar* pszAsciiBuf);
> 
>     /**
>      * 将AscII码的字符串转换成压缩的HEX格式               a,b,c  ->  0xab,0xc0
>      * @param asciiBuf          被转换的ASCII字符串
>      * @param len               输入数据长度(ASCII字符串的长度)
>      * @param type              对齐方式  0－左对齐  1－右对齐
>      * @param bcdBuf            转换输出的HEX数据
>      * @return
>      */
>     public int NdkApi_AscToHex(byte[] asciiBuf,int len,byte type,byte[] bcdBuf){
>         int ret;
>         ret = JNI_NDK_AscToHex(asciiBuf, len, type, bcdBuf);
>         return ret;
>     }
> 
>     /**
>      * 将HEX码数据转换成AscII码字符串      0xaa,0x0b,0x0c --> a,a,0,b,0,c
>      * @param bcdBuf            被转换的Hex数据
>      * @param len               转换数据长度(ASCII字符串的长度)
>      * @param type              对齐方式  1－左对齐  0－右对齐
>      * @param asciiBuf          转换输出的AscII码数据
>      * @return
>      */
>     public int NdkApi_HexToAsc(byte[] bcdBuf,int len,byte type,byte[] asciiBuf){
>         int ret;
>         ret = JNI_NDK_HexToAsc(bcdBuf, len, type, asciiBuf);
>         return ret;
>     }
> ```
>
> 



