package org.triumphxx.compare.node;

/**
 * @author:triumphxx
 * @Date: 2021/12/2
 * @Time: 10:02
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 比较对象节点
 **/
public class CompareNode implements Comparable<CompareNode> {
    /**
     * 省
     */
    private  String province ;
    /**
     * 市
     */
    private  String city;
    /**
     * 县
     */
    private  String county;
    /**
     * 纤细地址
     */
    private  String detailedAddress;

    /**
     * 区排名
     */
    private int rake;

    public CompareNode() {
    }

    public CompareNode(String province, String city, String county, String detailedAddress, Integer rake) {
        this.province = province;
        this.city = city;
        this.county = county;
        this.detailedAddress = detailedAddress;
        this.rake = rake;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    @Override
    public String toString() {
        return "ComparatorNode{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                '}';
    }

    @Override
    public int compareTo(CompareNode o) {
        if (this.rake == o.rake){
            return 0;
        }else if (this.rake > o.rake){
            return 1;
        }else {
            return -1;
        }


    }
}
