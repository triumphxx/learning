package org.triumphxx.config;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author:triumphxx
 * @Date: 2021/12/29
 * @Time: 16:01
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 配置执行过程中需要配置的信息
 **/
public class PubConfig {
    /**
     * 取数线程数据读取是否完毕标记,默认为false
     */
    public volatile static boolean DATAEMPTY_FG = false;
    /**
     * 数据分配标记,默认为true
     */
    public volatile static boolean DATAALLOT_FG = true;
    /**
     * 存放线程对应的业务表
     */
    private static final Map<String, ArrayList<String>> TABLEMAP = new HashMap<String, ArrayList<String>>();
    /**
     * 存放正在执行的线程信息
     */
    private static final List<String> EXECTASKLIST = new ArrayList<String>();
    /**
     * 有多少个线程体就由多少套表,每套表都放在一个ArrayList中
     */
    private static ArrayBlockingQueue<ArrayList<String>> mTableNameQueue = new ArrayBlockingQueue<ArrayList<String>>(
            ThreadPoolConfig.maximumPoolSize);
    /**
     * 核心保单打印接口表
     */
    private final static String PPRINTERFACE = "PPrinterFace";
    /**
     * 核心保单打印保单表
     */
    private final static String LCCONT = "LCCont";
    /**
     * 核心保单打印险种表
     */
    private final static String LCPOL = "LCPol";
    /**
     * 核心保单打印责任表
     */
    private final static String LCDUTY = "LCDuty";
    /**
     * 核心保单打印地址表
     */
    private final static String LCADDRESS = "LCAddress";
    /**
     * 核心保单打印投保人表
     */
    private final static String LCAPPNT = "LCAppnt";
    /**
     * 核心保单打印受益人表
     */
    private final static String LCBNF = "LCBnf";
    /**
     * 核心保单打印双主险表
     */
    private final static String LCCONTGROUP = "LCContGroup";
    /**
     * 核心保单打印计划表
     */
    private final static String LCCONTPLAN = "LCContPlan";
    /**
     * 核心保单打印给付表
     */
    private final static String LCGET = "LCGet";
    /**
     * 核心保单打印团险保单表
     */
    private final static String LCGRPCONT = "LCGrpCont";
    /**
     * 核心保单打印团险险种表
     */
    private final static String LCGRPPOL = "LCGrpPol";
    /**
     * 核心保单打印被保人表
     */
    private final static String LCINSURED = "LCInsured";
    /**
     * 核心保单打印特约表
     */
    private final static String LCSPEC = "LCSPec";

    public static ArrayBlockingQueue<ArrayList<String>> getMTableNameQueue() {
        return mTableNameQueue;
    }

    public static Map<String, ArrayList<String>> getTableMap() {
        return TABLEMAP;
    }

    public static List<String> getExecTaskList() {
        return EXECTASKLIST;
    }

    /**
     * 往队列表中插入系列表
     */
    public void putTableNameQueue() {
        for (int i = 1; i <= ThreadPoolConfig.maximumPoolSize; i++) {
            ArrayList<String> mTableList = new ArrayList<String>();
            mTableList.add(PPRINTERFACE + "_" + i);
            mTableList.add(LCCONT + "_" + i);
            mTableList.add(LCPOL + "_" + i);
            mTableList.add(LCDUTY + "_" + i);
            mTableList.add(LCADDRESS + "_" + i);
            mTableList.add(LCAPPNT + "_" + i);
            mTableList.add(LCBNF + "_" + i);
            mTableList.add(LCCONTGROUP + "_" + i);
            mTableList.add(LCCONTPLAN + "_" + i);
            mTableList.add(LCGET + "_" + i);
            mTableList.add(LCGRPCONT + "_" + i);
            mTableList.add(LCGRPPOL + "_" + i);
            mTableList.add(LCINSURED + "_" + i);
            mTableList.add(LCSPEC + "_" + i);
            mTableNameQueue.add(mTableList);
        }
    }
}
