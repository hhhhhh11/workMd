```java
/**
 * byte数组反转 0x55 0xfa 0x0a 0x00   ——————> 0x00 0x0a 0xfa 0x55
 * @param byteArray
 * @return 反转后的数组
 */
public  byte[] byteArrayReverse(byte[] byteArray){
    int len=byteArray.length;
    byte[] byteArrayReverse=new byte[len];
    for (int i = 0; i <len ; i++) {
        byteArrayReverse[i]=byteArray[len-1-i];
    }
    return byteArrayReverse;
}
/**
 * 截取byte数组的一部分
 */
public byte[] byteArrayCut(byte[] in,int start,int len){
    if(start+len>in.length){
        len=in.length-start;
    }
    byte[] out=new byte[len];
    System.arraycopy(in,start,out,0,len);
    return out;
}
/**
 * 合并两个byte数组
 */
public byte[] byteArrayMerge(byte[] byte1, byte[] byte2) {
    int byteLen1 = byte1.length;
    int byteLen2 = byte2.length;
    byte[] out = new byte[byteLen1 + byteLen2];
    System.arraycopy(byte1, 0, out, 0, byteLen1);
    
    /**
     * int --> 4个字节 0x00,0x00,0x00,0x01
     */
    public byte[] intToByteArray(int a) {
        return new byte[] {
//                (byte) ((a >> 24) & 0xFF),
//                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * 反向
     * int - 4个字节 0x00,0x00,0x00,0x01
     */
    private  byte[] intToByteArrayReverse(int a) {
        return new byte[] {
                (byte) (a & 0xFF),
                (byte) ((a >> 8) & 0xFF),
//                (byte) ((a >> 16) & 0xFF),
//                (byte) ((a >> 24) & 0xFF)
        };
    }

    /**
     * byte转int
     * @param byteToInt（byte类型）
     * @return  result（int类型）
     */
    public int byteToInt(byte byteToInt) {
        int mask = 0xFF;
        int result = byteToInt&mask;
        return result;
    }

    
    /**
     *byte[]转成16进制String 每个数组成员之间以空格隔开
     * @param byteArray 输入需要转换的byte数组
     * @return 返回16进制形式 String
     */
    public String byteArrayToHexString(byte[] byteArray) {
        String datalogString="";
        for (int byteIndex = 0; byteIndex <byteArray.length; byteIndex++) {
            String hex= Integer.toHexString(byteArray[byteIndex]);
            if(hex.length()>1){
                datalogString+="0x"+hex.substring(hex.length()-2)+" ";
            }
            else {
                datalogString+="0x0"+hex+" ";
            }
        }
        return datalogString;
    }

    /**
     * 字节数组转为普通字符串（ASCII对应的字符）
     *
     * @param byteArray
     *            byte[]
     * @return String
     */
    public static String byteToString(byte[] byteArray) {
        String result = "";
        char temp;

        int length = byteArray.length;
        for (int i = 0; i < length; i++) {
            temp = (char) byteArray[i];
            result += temp;
        }
        return result;
    }
            
```
