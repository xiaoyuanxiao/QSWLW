package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/12/20.
 */

public class ReceivingAddressBean {
    /**
     * address : {"address":"荔新公路","address_id":"313","city":"28241","consignee":"吴森","country":"1","district":"28399","email":"","is_default":"1","is_pickup":"0","mobile":"13902224107","province":"28240","twon":"28403","user_id":"175","zipcode":"5106300"}
     * city : [{"city_manager":"0","id":"28241","level":"2","name":"广州市","parent_id":"28240","provincial_manager":"0,886","sheng_qu_manager":"0"},{"city_manager":"0","id":"28421","level":"2","name":"韶关市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28558","level":"2","name":"深圳市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28626","level":"2","name":"珠海市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28659","level":"2","name":"汕头市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28737","level":"2","name":"佛山市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28785","level":"2","name":"江门市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28880","level":"2","name":"湛江市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29026","level":"2","name":"茂名市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29159","level":"2","name":"肇庆市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29282","level":"2","name":"惠州市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29371","level":"2","name":"梅州市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29498","level":"2","name":"汕尾市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29568","level":"2","name":"河源市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29679","level":"2","name":"阳江市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29755","level":"2","name":"清远市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29855","level":"2","name":"东莞市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29890","level":"2","name":"中山市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29915","level":"2","name":"潮州市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"29977","level":"2","name":"揭阳市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"30086","level":"2","name":"云浮市","parent_id":"28240","provincial_manager":"0","sheng_qu_manager":"0"}]
     * district : [{"city_manager":"0","id":"28242","level":"3","name":"市辖区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28243","level":"3","name":"荔湾区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28266","level":"3","name":"越秀区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28289","level":"3","name":"海珠区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28308","level":"3","name":"天河区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28330","level":"3","name":"白云区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28349","level":"3","name":"黄埔区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28359","level":"3","name":"番禺区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28377","level":"3","name":"花都区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28386","level":"3","name":"南沙区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28392","level":"3","name":"萝岗区","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"883","id":"28399","level":"3","name":"增城市","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"886"},{"city_manager":"0","id":"28409","level":"3","name":"从化市","parent_id":"28241","provincial_manager":"0","sheng_qu_manager":"0"}]
     * province : [{"city_manager":"0","id":"1","level":"1","name":"北京","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"338","level":"1","name":"天津","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"636","level":"1","name":"河北省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"3102","level":"1","name":"山西","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"4670","level":"1","name":"内蒙古","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"5827","level":"1","name":"辽宁省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"7531","level":"1","name":"吉林省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"8558","level":"1","name":"黑龙江省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"10543","level":"1","name":"上海","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"10808","level":"1","name":"江苏省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"12596","level":"1","name":"浙江省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"14234","level":"1","name":"安徽省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"16068","level":"1","name":"福建省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"17359","level":"1","name":"江西省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"19280","level":"1","name":"山东省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"21387","level":"1","name":"河南省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"24022","level":"1","name":"湖北省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"25579","level":"1","name":"湖南省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28240","level":"1","name":"广东省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"30164","level":"1","name":"广西","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"31563","level":"1","name":"海南省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"31929","level":"1","name":"重庆市","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"33007","level":"1","name":"四川省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"37906","level":"1","name":"贵州省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"39556","level":"1","name":"云南省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"41103","level":"1","name":"西藏","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"41877","level":"1","name":"陕西省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"43776","level":"1","name":"甘肃省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"45286","level":"1","name":"青海省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"45753","level":"1","name":"宁夏","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"46047","level":"1","name":"新疆","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"47493","level":"1","name":"台湾省","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"47494","level":"1","name":"香港","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"47495","level":"1","name":"澳门","parent_id":"0","provincial_manager":"0","sheng_qu_manager":"0"}]
     * twon : [{"city_manager":"0","id":"28400","level":"4","name":"荔城街道","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28401","level":"4","name":"增江街道","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28402","level":"4","name":"朱村街道","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28403","level":"4","name":"新塘镇","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28404","level":"4","name":"石滩镇","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28405","level":"4","name":"中新镇","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28406","level":"4","name":"正果镇","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28407","level":"4","name":"派潭镇","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"},{"city_manager":"0","id":"28408","level":"4","name":"小楼镇","parent_id":"28399","provincial_manager":"0","sheng_qu_manager":"0"}]
     */

    private AddressBean address;
    private List<CityBean> city;
    private List<DistrictBean> district;
    private List<ProvinceBean> province;
    private List<TwonBean> twon;

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public List<CityBean> getCity() {
        return city;
    }

    public void setCity(List<CityBean> city) {
        this.city = city;
    }

    public List<DistrictBean> getDistrict() {
        return district;
    }

    public void setDistrict(List<DistrictBean> district) {
        this.district = district;
    }

    public List<ProvinceBean> getProvince() {
        return province;
    }

    public void setProvince(List<ProvinceBean> province) {
        this.province = province;
    }

    public List<TwonBean> getTwon() {
        return twon;
    }

    public void setTwon(List<TwonBean> twon) {
        this.twon = twon;
    }

    public static class AddressBean {
        /**
         * address : 荔新公路
         * address_id : 313
         * city : 28241
         * consignee : 吴森
         * country : 1
         * district : 28399
         * email :
         * is_default : 1
         * is_pickup : 0
         * mobile : 13902224107
         * province : 28240
         * twon : 28403
         * user_id : 175
         * zipcode : 5106300
         */

        private String address;
        private String address_id;
        private String city;
        private String consignee;
        private String country;
        private String district;
        private String email;
        private String is_default;
        private String is_pickup;
        private String mobile;
        private String province;
        private String twon;
        private String user_id;
        private String zipcode;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress_id() {
            return address_id;
        }

        public void setAddress_id(String address_id) {
            this.address_id = address_id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIs_default() {
            return is_default;
        }

        public void setIs_default(String is_default) {
            this.is_default = is_default;
        }

        public String getIs_pickup() {
            return is_pickup;
        }

        public void setIs_pickup(String is_pickup) {
            this.is_pickup = is_pickup;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getTwon() {
            return twon;
        }

        public void setTwon(String twon) {
            this.twon = twon;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
    }

    public static class CityBean {
        /**
         * city_manager : 0
         * id : 28241
         * level : 2
         * name : 广州市
         * parent_id : 28240
         * provincial_manager : 0,886
         * sheng_qu_manager : 0
         */

        private String city_manager;
        private String id;
        private String level;
        private String name;
        private String parent_id;
        private String provincial_manager;
        private String sheng_qu_manager;

        public String getCity_manager() {
            return city_manager;
        }

        public void setCity_manager(String city_manager) {
            this.city_manager = city_manager;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getProvincial_manager() {
            return provincial_manager;
        }

        public void setProvincial_manager(String provincial_manager) {
            this.provincial_manager = provincial_manager;
        }

        public String getSheng_qu_manager() {
            return sheng_qu_manager;
        }

        public void setSheng_qu_manager(String sheng_qu_manager) {
            this.sheng_qu_manager = sheng_qu_manager;
        }
    }

    public static class DistrictBean {
        /**
         * city_manager : 0
         * id : 28242
         * level : 3
         * name : 市辖区
         * parent_id : 28241
         * provincial_manager : 0
         * sheng_qu_manager : 0
         */

        private String city_manager;
        private String id;
        private String level;
        private String name;
        private String parent_id;
        private String provincial_manager;
        private String sheng_qu_manager;

        public String getCity_manager() {
            return city_manager;
        }

        public void setCity_manager(String city_manager) {
            this.city_manager = city_manager;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getProvincial_manager() {
            return provincial_manager;
        }

        public void setProvincial_manager(String provincial_manager) {
            this.provincial_manager = provincial_manager;
        }

        public String getSheng_qu_manager() {
            return sheng_qu_manager;
        }

        public void setSheng_qu_manager(String sheng_qu_manager) {
            this.sheng_qu_manager = sheng_qu_manager;
        }
    }

    public static class ProvinceBean {
        /**
         * city_manager : 0
         * id : 1
         * level : 1
         * name : 北京
         * parent_id : 0
         * provincial_manager : 0
         * sheng_qu_manager : 0
         */

        private String city_manager;
        private String id;
        private String level;
        private String name;
        private String parent_id;
        private String provincial_manager;
        private String sheng_qu_manager;

        public String getCity_manager() {
            return city_manager;
        }

        public void setCity_manager(String city_manager) {
            this.city_manager = city_manager;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getProvincial_manager() {
            return provincial_manager;
        }

        public void setProvincial_manager(String provincial_manager) {
            this.provincial_manager = provincial_manager;
        }

        public String getSheng_qu_manager() {
            return sheng_qu_manager;
        }

        public void setSheng_qu_manager(String sheng_qu_manager) {
            this.sheng_qu_manager = sheng_qu_manager;
        }
    }

    public static class TwonBean {
        /**
         * city_manager : 0
         * id : 28400
         * level : 4
         * name : 荔城街道
         * parent_id : 28399
         * provincial_manager : 0
         * sheng_qu_manager : 0
         */

        private String city_manager;
        private String id;
        private String level;
        private String name;
        private String parent_id;
        private String provincial_manager;
        private String sheng_qu_manager;

        public String getCity_manager() {
            return city_manager;
        }

        public void setCity_manager(String city_manager) {
            this.city_manager = city_manager;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getProvincial_manager() {
            return provincial_manager;
        }

        public void setProvincial_manager(String provincial_manager) {
            this.provincial_manager = provincial_manager;
        }

        public String getSheng_qu_manager() {
            return sheng_qu_manager;
        }

        public void setSheng_qu_manager(String sheng_qu_manager) {
            this.sheng_qu_manager = sheng_qu_manager;
        }
    }

}
