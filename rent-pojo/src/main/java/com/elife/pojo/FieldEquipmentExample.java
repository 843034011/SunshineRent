package com.elife.pojo;

import java.util.ArrayList;
import java.util.List;

public class FieldEquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FieldEquipmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEquipNameIsNull() {
            addCriterion("equip_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipNameIsNotNull() {
            addCriterion("equip_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNameEqualTo(String value) {
            addCriterion("equip_name =", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotEqualTo(String value) {
            addCriterion("equip_name <>", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameGreaterThan(String value) {
            addCriterion("equip_name >", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_name >=", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLessThan(String value) {
            addCriterion("equip_name <", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLessThanOrEqualTo(String value) {
            addCriterion("equip_name <=", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLike(String value) {
            addCriterion("equip_name like", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotLike(String value) {
            addCriterion("equip_name not like", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameIn(List<String> values) {
            addCriterion("equip_name in", values, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotIn(List<String> values) {
            addCriterion("equip_name not in", values, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameBetween(String value1, String value2) {
            addCriterion("equip_name between", value1, value2, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotBetween(String value1, String value2) {
            addCriterion("equip_name not between", value1, value2, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeIsNull() {
            addCriterion("equip_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeIsNotNull() {
            addCriterion("equip_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeEqualTo(String value) {
            addCriterion("equip_type =", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNotEqualTo(String value) {
            addCriterion("equip_type <>", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeGreaterThan(String value) {
            addCriterion("equip_type >", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equip_type >=", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeLessThan(String value) {
            addCriterion("equip_type <", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeLessThanOrEqualTo(String value) {
            addCriterion("equip_type <=", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeLike(String value) {
            addCriterion("equip_type like", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNotLike(String value) {
            addCriterion("equip_type not like", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeIn(List<String> values) {
            addCriterion("equip_type in", values, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNotIn(List<String> values) {
            addCriterion("equip_type not in", values, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeBetween(String value1, String value2) {
            addCriterion("equip_type between", value1, value2, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNotBetween(String value1, String value2) {
            addCriterion("equip_type not between", value1, value2, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipPictureIsNull() {
            addCriterion("equip_picture is null");
            return (Criteria) this;
        }

        public Criteria andEquipPictureIsNotNull() {
            addCriterion("equip_picture is not null");
            return (Criteria) this;
        }

        public Criteria andEquipPictureEqualTo(String value) {
            addCriterion("equip_picture =", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureNotEqualTo(String value) {
            addCriterion("equip_picture <>", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureGreaterThan(String value) {
            addCriterion("equip_picture >", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureGreaterThanOrEqualTo(String value) {
            addCriterion("equip_picture >=", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureLessThan(String value) {
            addCriterion("equip_picture <", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureLessThanOrEqualTo(String value) {
            addCriterion("equip_picture <=", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureLike(String value) {
            addCriterion("equip_picture like", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureNotLike(String value) {
            addCriterion("equip_picture not like", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureIn(List<String> values) {
            addCriterion("equip_picture in", values, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureNotIn(List<String> values) {
            addCriterion("equip_picture not in", values, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureBetween(String value1, String value2) {
            addCriterion("equip_picture between", value1, value2, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureNotBetween(String value1, String value2) {
            addCriterion("equip_picture not between", value1, value2, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPriceIsNull() {
            addCriterion("equip_price is null");
            return (Criteria) this;
        }

        public Criteria andEquipPriceIsNotNull() {
            addCriterion("equip_price is not null");
            return (Criteria) this;
        }

        public Criteria andEquipPriceEqualTo(Long value) {
            addCriterion("equip_price =", value, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceNotEqualTo(Long value) {
            addCriterion("equip_price <>", value, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceGreaterThan(Long value) {
            addCriterion("equip_price >", value, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("equip_price >=", value, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceLessThan(Long value) {
            addCriterion("equip_price <", value, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceLessThanOrEqualTo(Long value) {
            addCriterion("equip_price <=", value, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceIn(List<Long> values) {
            addCriterion("equip_price in", values, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceNotIn(List<Long> values) {
            addCriterion("equip_price not in", values, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceBetween(Long value1, Long value2) {
            addCriterion("equip_price between", value1, value2, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipPriceNotBetween(Long value1, Long value2) {
            addCriterion("equip_price not between", value1, value2, "equipPrice");
            return (Criteria) this;
        }

        public Criteria andEquipNumberIsNull() {
            addCriterion("equip_number is null");
            return (Criteria) this;
        }

        public Criteria andEquipNumberIsNotNull() {
            addCriterion("equip_number is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNumberEqualTo(Integer value) {
            addCriterion("equip_number =", value, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberNotEqualTo(Integer value) {
            addCriterion("equip_number <>", value, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberGreaterThan(Integer value) {
            addCriterion("equip_number >", value, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip_number >=", value, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberLessThan(Integer value) {
            addCriterion("equip_number <", value, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberLessThanOrEqualTo(Integer value) {
            addCriterion("equip_number <=", value, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberIn(List<Integer> values) {
            addCriterion("equip_number in", values, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberNotIn(List<Integer> values) {
            addCriterion("equip_number not in", values, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberBetween(Integer value1, Integer value2) {
            addCriterion("equip_number between", value1, value2, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("equip_number not between", value1, value2, "equipNumber");
            return (Criteria) this;
        }

        public Criteria andEquipStockIsNull() {
            addCriterion("equip_stock is null");
            return (Criteria) this;
        }

        public Criteria andEquipStockIsNotNull() {
            addCriterion("equip_stock is not null");
            return (Criteria) this;
        }

        public Criteria andEquipStockEqualTo(Integer value) {
            addCriterion("equip_stock =", value, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockNotEqualTo(Integer value) {
            addCriterion("equip_stock <>", value, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockGreaterThan(Integer value) {
            addCriterion("equip_stock >", value, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip_stock >=", value, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockLessThan(Integer value) {
            addCriterion("equip_stock <", value, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockLessThanOrEqualTo(Integer value) {
            addCriterion("equip_stock <=", value, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockIn(List<Integer> values) {
            addCriterion("equip_stock in", values, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockNotIn(List<Integer> values) {
            addCriterion("equip_stock not in", values, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockBetween(Integer value1, Integer value2) {
            addCriterion("equip_stock between", value1, value2, "equipStock");
            return (Criteria) this;
        }

        public Criteria andEquipStockNotBetween(Integer value1, Integer value2) {
            addCriterion("equip_stock not between", value1, value2, "equipStock");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNull() {
            addCriterion("field_id is null");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNotNull() {
            addCriterion("field_id is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIdEqualTo(Integer value) {
            addCriterion("field_id =", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotEqualTo(Integer value) {
            addCriterion("field_id <>", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThan(Integer value) {
            addCriterion("field_id >", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_id >=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThan(Integer value) {
            addCriterion("field_id <", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThanOrEqualTo(Integer value) {
            addCriterion("field_id <=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIn(List<Integer> values) {
            addCriterion("field_id in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotIn(List<Integer> values) {
            addCriterion("field_id not in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdBetween(Integer value1, Integer value2) {
            addCriterion("field_id between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("field_id not between", value1, value2, "fieldId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}