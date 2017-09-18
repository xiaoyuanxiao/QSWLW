package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class ImproveDocumentationBean {

    /**
     * info : {"id":"7","cat_id":"6","type":"online","business_id":"187","name":"津津食品旗舰店","company_name":"津津食品","address":"上海市徐汇区龙华西路968号","starttime":"0","endtime":"0","category":"食品","licenseimg":null,"photo":"/Uploads/proof/2017-04-11/58eca18199d3e.png","taximg":null,"idcardz":null,"idcardb":null,"license":"/Uploads/proof/2017-05-09/5911e4fd283f4.JPG","contract":"/Uploads/proof/2017-05-09/5911e4fd283f4.JPG","province":"10543","city":"10544","district":"10560","shopinfo":null,"mobile":"15720665859","sign":"1","add_time":"2017-08-17 12:10:36","amount":"18900","tagold":"68250","is_perfect_data":"1"}
     * thems : [{"id":"1","name":"生活服务","mobile_name":"生活服务","parent_id":"0","parent_id_path":"0_1","level":"1","sort_order":"0","is_show":"1","image":"/Public/upload/category/2017/02-20/58aa5fee39937.png","is_hot":"1","cat_group":"0","commission_rate":"0"}]
     * clist : [{"id":"28240","name":"广东省","level":"1","parent_id":"0","provincial_manager":"0","city_manager":"0","sheng_qu_manager":"0"}]
     * city_list : [{"id":"28241","name":"广州市","level":"2","parent_id":"28240","provincial_manager":"0","city_manager":"0","sheng_qu_manager":"0"}]
     * district_list : [{"id":"28399","name":"增城区","level":"3","parent_id":"28241","provincial_manager":"0","city_manager":"0","sheng_qu_manager":"0"}]
     */

    private InfoBean info;
    private List<ThemsBean> thems;
    private List<ClistBean> clist;
    private List<CityListBean> city_list;
    private List<DistrictListBean> district_list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ThemsBean> getThems() {
        return thems;
    }

    public void setThems(List<ThemsBean> thems) {
        this.thems = thems;
    }

    public List<ClistBean> getClist() {
        return clist;
    }

    public void setClist(List<ClistBean> clist) {
        this.clist = clist;
    }

    public List<CityListBean> getCity_list() {
        return city_list;
    }

    public void setCity_list(List<CityListBean> city_list) {
        this.city_list = city_list;
    }

    public List<DistrictListBean> getDistrict_list() {
        return district_list;
    }

    public void setDistrict_list(List<DistrictListBean> district_list) {
        this.district_list = district_list;
    }

    public static class InfoBean {
        /**
         * id : 7
         * cat_id : 6
         * type : online
         * business_id : 187
         * name : 津津食品旗舰店
         * company_name : 津津食品
         * address : 上海市徐汇区龙华西路968号
         * starttime : 0
         * endtime : 0
         * category : 食品
         * licenseimg : null
         * photo : /Uploads/proof/2017-04-11/58eca18199d3e.png
         * taximg : null
         * idcardz : null
         * idcardb : null
         * license : /Uploads/proof/2017-05-09/5911e4fd283f4.JPG
         * contract : /Uploads/proof/2017-05-09/5911e4fd283f4.JPG
         * province : 10543
         * city : 10544
         * district : 10560
         * shopinfo : null
         * mobile : 15720665859
         * sign : 1
         * add_time : 2017-08-17 12:10:36
         * amount : 18900
         * tagold : 68250
         * is_perfect_data : 1
         */

        private String id;
        private String cat_id;
        private String type;
        private String business_id;
        private String name;
        private String company_name;
        private String address;
        private String starttime;
        private String endtime;
        private String category;
        private String licenseimg;
        private String photo;
        private String taximg;
        private String idcardz;
        private String idcardb;
        private String license;
        private String contract;
        private String province;
        private String city;
        private String district;
        private String shopinfo;
        private String mobile;
        private String sign;
        private String add_time;
        private String amount;
        private String tagold;
        private String is_perfect_data;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBusiness_id() {
            return business_id;
        }

        public void setBusiness_id(String business_id) {
            this.business_id = business_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getLicenseimg() {
            return licenseimg;
        }

        public void setLicenseimg(String licenseimg) {
            this.licenseimg = licenseimg;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getTaximg() {
            return taximg;
        }

        public void setTaximg(String taximg) {
            this.taximg = taximg;
        }

        public String getIdcardz() {
            return idcardz;
        }

        public void setIdcardz(String idcardz) {
            this.idcardz = idcardz;
        }

        public String getIdcardb() {
            return idcardb;
        }

        public void setIdcardb(String idcardb) {
            this.idcardb = idcardb;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getContract() {
            return contract;
        }

        public void setContract(String contract) {
            this.contract = contract;
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

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getShopinfo() {
            return shopinfo;
        }

        public void setShopinfo(String shopinfo) {
            this.shopinfo = shopinfo;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getTagold() {
            return tagold;
        }

        public void setTagold(String tagold) {
            this.tagold = tagold;
        }

        public String getIs_perfect_data() {
            return is_perfect_data;
        }

        public void setIs_perfect_data(String is_perfect_data) {
            this.is_perfect_data = is_perfect_data;
        }
    }

    public static class ThemsBean {
        /**
         * id : 1
         * name : 生活服务
         * mobile_name : 生活服务
         * parent_id : 0
         * parent_id_path : 0_1
         * level : 1
         * sort_order : 0
         * is_show : 1
         * image : /Public/upload/category/2017/02-20/58aa5fee39937.png
         * is_hot : 1
         * cat_group : 0
         * commission_rate : 0
         */

        private String id;
        private String name;
        private String mobile_name;
        private String parent_id;
        private String parent_id_path;
        private String level;
        private String sort_order;
        private String is_show;
        private String image;
        private String is_hot;
        private String cat_group;
        private String commission_rate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile_name() {
            return mobile_name;
        }

        public void setMobile_name(String mobile_name) {
            this.mobile_name = mobile_name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getParent_id_path() {
            return parent_id_path;
        }

        public void setParent_id_path(String parent_id_path) {
            this.parent_id_path = parent_id_path;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getSort_order() {
            return sort_order;
        }

        public void setSort_order(String sort_order) {
            this.sort_order = sort_order;
        }

        public String getIs_show() {
            return is_show;
        }

        public void setIs_show(String is_show) {
            this.is_show = is_show;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(String is_hot) {
            this.is_hot = is_hot;
        }

        public String getCat_group() {
            return cat_group;
        }

        public void setCat_group(String cat_group) {
            this.cat_group = cat_group;
        }

        public String getCommission_rate() {
            return commission_rate;
        }

        public void setCommission_rate(String commission_rate) {
            this.commission_rate = commission_rate;
        }
    }

    public static class ClistBean {
        /**
         * id : 28240
         * name : 广东省
         * level : 1
         * parent_id : 0
         * provincial_manager : 0
         * city_manager : 0
         * sheng_qu_manager : 0
         */

        private String id;
        private String name;
        private String level;
        private String parent_id;
        private String provincial_manager;
        private String city_manager;
        private String sheng_qu_manager;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
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

        public String getCity_manager() {
            return city_manager;
        }

        public void setCity_manager(String city_manager) {
            this.city_manager = city_manager;
        }

        public String getSheng_qu_manager() {
            return sheng_qu_manager;
        }

        public void setSheng_qu_manager(String sheng_qu_manager) {
            this.sheng_qu_manager = sheng_qu_manager;
        }
    }

    public static class CityListBean {
        /**
         * id : 28241
         * name : 广州市
         * level : 2
         * parent_id : 28240
         * provincial_manager : 0
         * city_manager : 0
         * sheng_qu_manager : 0
         */

        private String id;
        private String name;
        private String level;
        private String parent_id;
        private String provincial_manager;
        private String city_manager;
        private String sheng_qu_manager;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
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

        public String getCity_manager() {
            return city_manager;
        }

        public void setCity_manager(String city_manager) {
            this.city_manager = city_manager;
        }

        public String getSheng_qu_manager() {
            return sheng_qu_manager;
        }

        public void setSheng_qu_manager(String sheng_qu_manager) {
            this.sheng_qu_manager = sheng_qu_manager;
        }
    }

    public static class DistrictListBean {
        /**
         * id : 28399
         * name : 增城区
         * level : 3
         * parent_id : 28241
         * provincial_manager : 0
         * city_manager : 0
         * sheng_qu_manager : 0
         */

        private String id;
        private String name;
        private String level;
        private String parent_id;
        private String provincial_manager;
        private String city_manager;
        private String sheng_qu_manager;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
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

        public String getCity_manager() {
            return city_manager;
        }

        public void setCity_manager(String city_manager) {
            this.city_manager = city_manager;
        }

        public String getSheng_qu_manager() {
            return sheng_qu_manager;
        }

        public void setSheng_qu_manager(String sheng_qu_manager) {
            this.sheng_qu_manager = sheng_qu_manager;
        }
    }

}
