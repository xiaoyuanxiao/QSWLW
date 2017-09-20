package com.qs.qswlw.bean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class ImproveCityBean {

    private List<RegionListBean> region_list;

    public List<RegionListBean> getRegion_list() {
        return region_list;
    }

    public void setRegion_list(List<RegionListBean> region_list) {
        this.region_list = region_list;
    }

    public static class RegionListBean {
        /**
         * city_manager : 0
         * id : 10544
         * level : 2
         * name : 市辖区
         * parent_id : 10543
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
