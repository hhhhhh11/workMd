package com.newland.assistant.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LYQ
 */
public class SPUtils
{

    public static final String SETTING = "share_data";
    public final static String REBOOT_KEY = "reboot";
    public final static String OTA_KEY = "ota";
    public final static String OTA_UPDATE = "ota_update";

    public final static String DOWNLOADREBOOT_KEY = "downloadReboot";
    public final static String DOWNLOAD_SUCCESS_KEY = "downloadSuccess";
    public final static String DOWNLOAD_KEY = "download";
    public final static String DOWNLOAD_RESULT_KEY = "result";
    public final static String DOWNLOAD_FILENAME_KEY = "fileName";
    public final static String DOWNLOAD_STATUS_KEY = "status";
    /**
     * desc:保存对象
     * @param context
     * @param
     * @param obj 要保存的对象，只能保存实现了serializable的对象
     * modified:
     */
    public static boolean saveObject(Context context, Object obj, String key){
        try {
            // 保存对象
            SharedPreferences.Editor sharedata = context.getSharedPreferences(SETTING, 0).edit();
            //先将序列化结果写到byte缓存中，其实就分配一个内存空间
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream os=new ObjectOutputStream(bos);
            //将对象序列化写入byte缓存
            os.writeObject(obj);
            //将序列化的数据转为16进制保存
            String bytesToHexString = bytesToHexString(bos.toByteArray());
            //保存该16进制数组
            sharedata.putString(key, bytesToHexString);
            sharedata.commit();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("", "保存obj失败");
            return false;
        }
    }
    /**
     * desc:将数组转为16进制
     * @param bArray
     * @return
     * modified:
     */
    public static String bytesToHexString(byte[] bArray) {
        if(bArray == null){
            return null;
        }
        if(bArray.length == 0){
            return "";
        }
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
    /**
     * desc:获取保存的Object对象
     * @param context
     * @param key
     * @return
     * modified:
     */
    public static Object readObject(Context context, String key){
        try {
            SharedPreferences sharedata = context.getSharedPreferences(SETTING, 0);
            if (sharedata.contains(key)) {
                String string = sharedata.getString(key, "");
                if(TextUtils.isEmpty(string)){
                    return null;
                }else{
                    //将16进制的数据转为数组，准备反序列化
                    byte[] stringToBytes = StringToBytes(string);
                    ByteArrayInputStream bis=new ByteArrayInputStream(stringToBytes);
                    ObjectInputStream is=new ObjectInputStream(bis);
                    //返回反序列化得到的对象
                    Object readObject = is.readObject();
                    return readObject;
                }
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //所有异常返回null
        return null;

    }
    /**
     * desc:将16进制的数据转为数组
     * <p>创建人：聂旭阳 , 2014-5-25 上午11:08:33</p>
     * @param data
     * @return
     * modified:
     */
    public static byte[] StringToBytes(String data){
        String hexString=data.toUpperCase().trim();
        if (hexString.length()%2!=0) {
            return null;
        }
        byte[] retData=new byte[hexString.length()/2];
        for(int i=0;i<hexString.length();i++)
        {
            int int_ch;  // 两位16进制数转化后的10进制数
            char hex_char1 = hexString.charAt(i); ////两位16进制数中的第一位(高位*16)
            int int_ch3;
            if(hex_char1 >= '0' && hex_char1 <='9')
                int_ch3 = (hex_char1-48)*16;   //// 0 的Ascll - 48
            else if(hex_char1 >= 'A' && hex_char1 <='F')
                int_ch3 = (hex_char1-55)*16; //// A 的Ascll - 65
            else
                return null;
            i++;
            char hex_char2 = hexString.charAt(i); ///两位16进制数中的第二位(低位)
            int int_ch4;
            if(hex_char2 >= '0' && hex_char2 <='9')
                int_ch4 = (hex_char2-48); //// 0 的Ascll - 48
            else if(hex_char2 >= 'A' && hex_char2 <='F')
                int_ch4 = hex_char2-55; //// A 的Ascll - 65
            else
                return null;
            int_ch = int_ch3+int_ch4;
            retData[i/2]=(byte) int_ch;//将转化后的数放入Byte里
        }
        return retData;
    }

    /**
     * 清除user所有数据
     * @param context
     * @param
     */
    public static void remove(Context context) {
        SharedPreferences sharedata = context.getSharedPreferences(SETTING, 0);
        sharedata.edit().clear().commit();
    }


    /**
     * 存储数据(Int)
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putIntValue(Context context, String key, int value) {
        SharedPreferences.Editor sp = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE)
                .edit();
        sp.putInt(key, value);
        sp.commit();
    }

    /**
     * 存储数据(String)
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putStringValue(Context context, String key, String value) {
        SharedPreferences.Editor sp = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE)
                .edit();
        sp.putString(key, value);
        sp.commit();
    }

    /**
     * 存储List<String>
     *
     * @param context
     * @param key
     *            List<String>对应的key
     * @param strList
     *            对应需要存储的List<String>
     */
    public static void putStrListValue(Context context, String key,
                                       List<String> strList) {
        if (null == strList) {
            return;
        }
        // 保存之前先清理已经存在的数据，保证数据的唯一性
        removeStrList(context, key);
        int size = strList.size();
//        putIntValue(context, key + "size", size);
        for (int i = 0; i < size; i++) {
            putStringValue(context, key + i, strList.get(i));
        }
    }

    /**
     * 取出数据（int)
     *
     * @param context
     * @param key
     * @param defValue
     *            默认值
     * @return
     */
    public static int getIntValue(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(SETTING,
                Context.MODE_PRIVATE);
        int value = sp.getInt(key, defValue);
        return value;
    }

    /**
     * 取出数据（String)
     *
     * @param context
     * @param key
     * @param defValue
     *            默认值
     * @return
     */
    public static String getStringValue(Context context, String key,
                                         String defValue) {
        SharedPreferences sp = context.getSharedPreferences(SETTING,
                Context.MODE_PRIVATE);
        String value = sp.getString(key, defValue);
        return value;
    }

    /**
     * 取出List<String>
     *
     * @param context
     * @param key
     *            List<String> 对应的key
     * @return List<String>
     */
    public static List<String> getStrListValue(Context context, String key) {
        List<String> strList = new ArrayList<String>();
        int size = getIntValue(context, key + "size", 0);
        //Log.d("sp", "" + size);
        for (int i = 0; i < size; i++) {
            strList.add(getStringValue(context, key + i, null));
        }
        return strList;
    }

    /**
     * 清空List<String>所有数据
     *
     * @param context
     * @param key
     *            List<String>对应的key
     */
    public static void removeStrList(Context context, String key) {
        int size = getIntValue(context, key + "size", 0);
        if (0 == size) {
            return;
        }
        remove(context, key + "size");
        for (int i = 0; i < size; i++) {
            remove(context, key + i);
        }
    }

    /**
     * @Description TODO 清空List<String>单条数据
     * @param context
     * @param key
     *            List<String>对应的key
     * @param str
     *            List<String>中的元素String
     */
    public static void removeStrListItem(Context context, String key, String str) {
        int size = getIntValue(context, key + "size", 0);
        if (0 == size) {
            return;
        }
        List<String> strList = getStrListValue(context, key);
        // 待删除的List<String>数据暂存
        List<String> removeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (str.equals(strList.get(i))) {
                if (i >= 0 && i < size) {
                    removeList.add(strList.get(i));
                    remove(context, key + i);
                    putIntValue(context, key + "size", size - 1);
                }
            }
        }
        strList.removeAll(removeList);
        // 删除元素重新建立索引写入数据
        putStrListValue(context, key, strList);
    }

    /**
     * 清空对应key数据
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences.Editor sp = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE)
                .edit();
        sp.remove(key);
        sp.commit();
    }

    /**
     * 清空所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences.Editor sp = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE)
                .edit();
        sp.clear();
        sp.commit();
    }

}